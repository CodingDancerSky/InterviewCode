#include <iostream>
#include <cstdlib>
#include <climits>
#include <cmath>

using namespace std;

bool g_flag = false;

int check(int N, int x[], int y[], int a, int b, int d, bool visited[]) {
    int counter = 0;

    for (int i = 0; i < N; i++) {
        if (a == x[i] && b == y[i]) {
            g_flag = true;
            return 0;
        }

        if (visited[i]) {
            continue;
        }

        if (pow(a - x[i], 2) + pow(b - y[i], 2) <= pow(d, 2)) {
            counter++;
            visited[i] = true;
        }
    } 

    return counter;
}

int main(int argc, char const* argv[])
{
    int d[3], N;
    cin >> d[0] >> d[1] >> d[2] >> N;

    int x[N], y[N];
    for (int i = 0; i < N; i++) {
        cin >> x[i] >> y[i];
    }

    int max_person = 0;
    // 1st one
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            //2nd one
            for (int m = 0; m < 10; m++) {
                for (int n = 0; n < 10; n++) {
                    if (i == m && j == n) continue;
                    //3rd one)
                    for (int p = 0; p < 10; p++) {
                        for (int q = 0; q < 10; q++) {
                            if ((i == p && j == q) || (m == p && n == q)) {
                                continue;
                            }

                            bool visited[101] = {false};
                            //cout << i << j << m << n << p << q << endl;

                            //check audience amount
                            int aud1 = check(N, x, y, i, j, d[0], visited);
                            if (g_flag) {
                                g_flag = false;
                                continue;
                            }

                            int aud2 = check(N, x, y, m, n, d[1], visited);
                            if (g_flag) {
                                g_flag = false;
                                continue;
                            }

                            int aud3 = check(N, x, y, p, q, d[2], visited);
                            if (g_flag) {
                                g_flag = false;
                                continue;
                            }

                            max_person = max_person < aud1 + aud2 + aud3 ? aud1 + aud2 + aud3 : max_person;
                            //if (max_person == 5) {
                                //cout << aud1 << aud2 << aud3 << endl;
                                //cout << i << j << m << n << p << q << endl;
                                //max_person--;
                            //}
                        }
                    }
                }
            }
        }
    }

    cout <<  max_person << endl;
}
