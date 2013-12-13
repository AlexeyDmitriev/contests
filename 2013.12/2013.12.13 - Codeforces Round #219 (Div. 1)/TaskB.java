package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

public class TaskB {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        char[][] s = new char[n][m];
        for(int i = 0; i < n; ++i) {
            s[i] = in.nextString().toCharArray();
        }
        int[][][][] counts = new int[n + 1][m + 1][n + 1][m + 1];
        for(int x1 = 0; x1 < n; ++x1) {
            for(int x2 = x1 + 1; x2 <= n; ++x2) {
                for(int y1 = 0; y1 < m; ++y1) {

                    for(int y2 = y1 + 1; y2 <= m; ++y2) {
                        boolean good = true;
                        for(int j = x1; j < x2; ++j) {
                            if(s[j][y2 - 1] == '1') {
                                good = false;
                                break;
                            }
                        }

                        if(!good)
                            break;
                        ++counts[x1][y1][x2][y2];
                    }
                }
            }
        }


        //System.err.println(Arrays.deepToString(counts[0][0]));

        for(int sx = 0; sx < n; ++sx) {
            for(int sy = 0; sy < m; ++sy) {
                for(int ex = sx + 1; ex <= n; ++ex) {
                    for(int ey = sy + 1; ey <= m; ++ey) {
                        counts[sx][sy][ex][ey] += counts[sx][sy][ex - 1][ey] + counts[sx][sy][ex][ey - 1] - counts[sx][sy][ex - 1][ey - 1];
                    }
                }
            }
        }

        for(int ex = 1; ex <= n; ++ex) {
            for(int ey = 1; ey <= m; ++ey) {
                for(int sx = ex - 1; sx >= 0; --sx) {
                    for(int sy = ey - 1; sy >= 0; --sy) {
                        counts[sx][sy][ex][ey] += counts[sx + 1][sy][ex][ey] + counts[sx][sy + 1][ex][ey] - counts[sx + 1][sy + 1][ex][ey];
                        //counts[sx][sy][ex][ey] += counts[sx][sy][ex - 1][ey] + counts[sx][sy][ex][ey - 1] - counts[sx][sy][ex - 1][ey - 1];
                    }
                }
            }
        }


        //System.err.println(Arrays.deepToString(counts[0][0]));

        for(int z = 0; z < q; ++z) {
            int sx = in.nextInt() - 1;
            int sy = in.nextInt() - 1;
            int ex = in.nextInt();
            int ey = in.nextInt();

            int ans = 0;
            out.println(counts[sx][sy][ex][ey]);
        }
    }
}
