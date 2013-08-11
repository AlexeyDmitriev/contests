package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class TaskC {
    int n, m;
    Random random = new Random();

    int[] dx = {0, 1, -1, 0, 0};
    int[] dy = {0, 0, 0, 1, -1};

    public void solve(int testNumber, Reader in, OutputWriter out) {


        for (int test = 1; test <= 10; ++test) {
            try {
                in = new Reader(new BufferedReader(new FileReader("/home/riad/contest/" + test + ".txt")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            n = in.nextInt();
            m = in.nextInt();
            char[][] map = new char[n][];
            for (int i = 0; i < n; ++i) {
                map[i] = in.nextString().toCharArray();
            }

            iterate(out, map);

                goRight(out, map);

                iterate(out, map);

                goDown(out, map);


            iterate(out, map);


            /*for(int i = 0; i < 5; ++i) {
                emptyEvenLines(out, map);
                emptyOddLines(out, map);
            }

            iterate(out, map);*/

            //System.err.println(toString(map));
            out.println();
            out.println(ones(map));
            out.println();
            out.flush();
        }

    }

    private void goDown(OutputWriter out, char[][] map) {
        for(int i = 0; i < n - 1; ++i) {
            for(int j = 0; j < m; ++j) {

                if(map[i][j] == '1') {
                    flip(map, i + 1, j, out);
                }
            }
        }

        for(int j = 0; j + 2 < n; ++j) {
            if(map[n - 1][j] == '1' && map[n - 1][j + 1] == '1' && map[n - 1][j + 2] == '1') {
                flip(map, n - 1, j + 1, out);
            }
        }
    }

    private void goRight(OutputWriter out, char[][] map) {
        for(int j = 0; j < m - 1; ++j) {
            for(int i = 0; i < n; ++i) {
                if(map[i][j] == '1') {
                    flip(map, i, j + 1, out);
                }
            }
        }

        for(int j = 0; j + 2 < n; ++j) {
            if(map[j][m - 1] == '1' && map[j + 1][m - 1] == '1' && map[j + 2][m - 1] == '1') {
                flip(map, j + 1, m - 1, out);
            }
        }
    }

    private void emptyEvenLines(OutputWriter out, char[][] map) {
        for(int i = 0; i < n; i += 2) {
            emptyLine(out, map, i);
        }
    }

    private void emptyOddLines(OutputWriter out, char[][] map) {
        for(int i = 1; i < n; i += 2) {
            emptyLine(out, map, i);
        }
    }

    private void emptyLine(OutputWriter out, char[][] map, int i) {
        for(int j = n - 1; j >= 1; --j) {
            if(map[i][j] == '1') {
                flip(map, i, j - 1, out);
            }
        }
    }

    private void iterate(OutputWriter out, char[][] map) {
        for(int iteration = 0; iteration < 100; ++iteration) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    int ones = 0;
                    int zeroes = 0;
                    {
                        for (int d = 0; d < 5; ++d) {
                            if (correct(i + dx[d], j + dy[d])) {
                                if (map[i + dx[d]][j + dy[d]] == '1') {
                                    ones++;
                                } else
                                    zeroes++;
                            }
                        }
                    }

             //       System.out.print(i + " " + j + " " + ones + " " + zeroes);


                    if (ones > zeroes || ones == zeroes && random.nextInt(3) != 0) {
                        flip(map, i, j, out);
                    }
                }
            }
        }
    }

    private void flip(char[][] map, int i, int j, OutputWriter out) {
        if(!correct(i, j))
            throw new RuntimeException();
        for (int d = 0; d < 5; ++d) {
            if (correct(i + dx[d], j + dy[d])) {
                map[i + dx[d]][j + dy[d]] = (char) ('0' + '1' - map[i + dx[d]][j + dy[d]]);
            }
        }
        out.print((i + 1) + ":" + (j + 1) + " ");
    }

    private int ones(char[][] map) {
        int result = 0;
        for (char[] chars : map) {
            for (char c : chars) {
                if(c == '1') {
                    ++result;
                }
            }
        }
        return result;
    }

    private String toString(char[][] map) {
        StringBuilder sb = new StringBuilder();
        for (char[] chars : map) {
            sb.append(String.valueOf(chars)).append("\n");
        }
        return sb.toString();
    }

    private boolean correct(int a, int b) {
        return a < n && a >= 0 && b < m && b >= 0;
    }
}
