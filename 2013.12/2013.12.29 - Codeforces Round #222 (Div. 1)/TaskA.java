package main;

import name.admitriev.spsl.collections.Pair;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

import java.util.ArrayList;

public class TaskA {
    char[][] ans;
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        ans = new char[n][];
        used = new boolean[n][m];
        for(int i = 0; i < n; ++i) {
            ans[i] = in.nextString().toCharArray();
        }
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if(ans[i][j] == '.') {


                    dfs(i, j);
                    for(int t = cells.size() - k; t < cells.size(); ++t) {
                        ans[cells.get(t).first][cells.get(t).second] = 'X';
                    }
                    for(int x = 0; x < n; ++x) {
                        out.println(ans[x]);
                    }
                    return;
                }
            }
        }
    }
    boolean[][] used;
    ArrayList<Pair<Integer, Integer>> cells = new ArrayList<Pair<Integer, Integer>>();

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0,0, -1, 1};
    private void dfs(int x, int y) {
        if(used[x][y])
            return;
        if(ans[x][y] != '.')
            return;
        cells.add(new Pair<Integer, Integer>(x, y));
        used[x][y] = true;
        for(int i = 0; i < 4; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= used.length || ny < 0 || ny >= used[0].length)
                continue;
            dfs(nx, ny);
        }

    }
}
