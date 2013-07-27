package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.ArrayList;

public class TaskD {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][];
        for(int i = 0; i < n; ++i)
            matrix[i] = in.nextIntArray(m);

        int l = 0, r = 1000000001;
        while(r - l > 1) {
            int c = (l + r) / 2;
            if(exists(c, n, m, matrix)) {
                l = c;
            }
            else
                r = c;

        }

        out.println(l);
    }

    private boolean exists(int c, int n, int m, int[][] matrix) {
        boolean[][] pairs = new boolean[m][m];
        for(int i = 0; i < n; ++i) {
            ArrayList<Integer> big = new ArrayList<Integer>();
            for(int j = 0; j < m; ++j) {
                if(matrix[i][j] >= c) {
                    big.add(j);
                }
            }
            for (int a : big) {
                for (int b : big) {
                    if(a == b)
                        continue;
                    if(pairs[a][b]) {
                        return true;
                    }
                    else
                        pairs[a][b] = true;
                }

            }
        }
        return false;
    }
}
