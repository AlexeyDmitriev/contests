package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskC {
    boolean[][] used;
    int n,m;
    char[][] s;
    public void solve(int testNumber, Reader in, OutputWriter out) {
        n = in.nextInt();
        if(n == 1) {
            out.println("0 0");
            return;
        }
        m = in.nextInt();
        s = new char[n][];
        for(int i = 0; i < n; ++i) {
            s[i] = in.nextString().toCharArray();
        }
        used = new boolean[n][m];

        int first = 0;
        int second = 0;

        for(int i = 0; i < m; ++i) {
            if(s[n - 2][i] != '.' && !used[n - 2][i]) {
                ++first;
                dfs(n - 2, i);
            }
        }


        for(int i = 0; i < n - 1; ++i) {
            for(int j = 0; j + 3 < m; ++j) {
                if(!used[i][j] && s[i][j] == '[' && s[i][j + 1] == ']' && s[i][j + 2] == '[' && s[i][j + 3] == ']') {
                    boolean bad = false;
                    for(int k = i - 1; k <= i + 1; ++k) {
                        for(int l =  j - 1; l <= j + 4; ++l) {
                            if(k != i - 1 && k!= i + 1 && l != j - 1 && l != j + 4)
                                continue;
                            if(correct(k, l) && s[k][l] != '.') {
                                bad = true;
                                break;
                            }
                        }
                    }
                    if(!bad)
                        ++second;
                }
            }
        }



        out.println(first + " " + second);
    }


    private void dfs(int x, int y) {
        if(used[x][y])
            return;

        used[x][y] = true;

        for(int i = -1; i <= 1; ++i) {
            for(int j = -1; j <= 1; ++j) {
                if(correct(x + i, y + j) && s[x + i][y + j] != '.')
                    dfs(x + i, y + j);
            }
        }
    }

    boolean correct(int x, int y) {
        return x >= 0 && x < n - 1 && y >= 0 && y < m;
    }
}
