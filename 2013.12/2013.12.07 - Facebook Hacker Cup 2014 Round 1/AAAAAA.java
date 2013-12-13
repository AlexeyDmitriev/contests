package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class AAAAAA {
    char[][] map;
    int[][][][] memo;
    public void solve(int testNumber, Reader in, OutputWriter out) {
        System.err.println(testNumber);
        int n = in.nextInt();
        int m = in.nextInt();
        map = new char[n][];
        for(int i = 0; i < n; ++i) {
            map[i] = in.nextString().toCharArray();
        }
        memo = new int[n][m][2][4];
        out.println("Case #" + testNumber + ": " + solve(0, 0, true, 0));
    }

    private int solve(int x, int y, boolean mayBack, int type) { // 0 down 1 rigth 2 left 3 up

        if(!correct(x, y))
            return 0;
        if(memo[x][y][mayBack ? 1 : 0][type] != 0)
            return memo[x][y][mayBack ? 1 : 0][type];
        int mx = 0;
        if(type != 2) {
            mx = Math.max(mx, solve(x, y + 1, mayBack, 1));
        }
        if(type != 3) {
            mx = Math.max(mx, solve(x + 1, y, mayBack, 0));
        }
        if((mayBack && type != 1) || type == 2) {
            mx = Math.max(mx, solve(x, y - 1, false, 2));
        }
        if((mayBack && type != 0 )|| type == 3) {
            mx = Math.max(mx, solve(x - 1, y, false, 3));
        }
        return memo[x][y][mayBack ? 1 : 0][type] = 1 + mx;
    }

    private boolean correct(int x, int y) {
        return x >= 0 && x < memo.length && y >= 0 && y < memo[x].length && map[x][y] == '.';
    }
}
