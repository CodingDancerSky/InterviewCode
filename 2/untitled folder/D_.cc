#include <iostream>
#include <cstdio>

using namespace std;

bool dp[35][610][610];

int main (){
    int n;
    cin >> n;

    dp[0][300][300] = true;

    for (int i = 0; i < n; i ++){
        int d;
        cin >> d;

        for (int j = 0; j <= 600; j ++){
            for (int k = 0; k <= 600; k ++){
                if (dp[i][j][k] == true){
                    dp[i+1][j][k] = true;
                    dp[i+1][j][k+d] = true;
                    dp[i+1][j][k-d] = true;
                    dp[i+1][j+d][k] = true;
                    dp[i+1][j-d][k] = true;
                }
            }
        }
    }

    int sum = 0;
    for (int i = 0; i <= 600; i ++){
        for (int j = 0; j <= 600; j ++){
            if (dp[n][i][j]){
                sum ++;
            }
        }
    }

    cout << sum << endl;
}
