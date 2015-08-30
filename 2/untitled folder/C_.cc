#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

int main (){
    int n;
    scanf ("%d", &n);
    vector<pair<int, int> > a(n);
    for (int i = 0; i < n; i ++){
        scanf ("%d%d", &a[i].first, &a[i].second);
        a[i].second --;
    }
    sort (a.begin (), a.end ());
    int sum = 0;
    vector<bool> vis (n, 0);
    for (int i = 0; i < n; i ++){
        if (!vis[i]){
            sum ++;
            int now = i;
            do{
                vis[now] = true;
                now = a[now].second;
            }while (now != i);
        }
    }
    printf ("%d\n", n - sum);
}