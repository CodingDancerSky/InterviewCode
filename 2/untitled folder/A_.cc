#include <iostream>
#include <string>

using namespace std;

int main(int argc, char const* argv[])
{
    int N, male = 0, female = 0;
    string name;

    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> name;
        if (name[name.length() - 1] == 'a') {
            male++;
        } else {
            female++;
        }
    }

    cout << male << ' ' << female << endl;

    return 0;
}
