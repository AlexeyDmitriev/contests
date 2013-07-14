package main;



import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.ArrayList;
import java.util.HashSet;

public class TaskB {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int sum = 0;
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        int n = in.nextInt();
        int m = in.nextInt();

        int count = 0;

        for(count = 1;;){
            if(sum + count <= n * m){
                sum += count;
                ++count;
            }
            else break;
        }



        --count;

        out.println(count);

        int[][] ans = new int[n][m];

        int group = 0;
        int rest = count == 1 ? 1000000000 : 1;

        for(int i = 0; i < n; ++i) {
            if(i % 2 == 0) {
                for(int j = 0; j < m; ++j) {
                    if(rest == 0) {
                        group++;
                        if(group == count - 1) {
                            rest = 1000000000;
                        }
                        else
                            rest = group + 1;
                    }
                    --rest;
                    ans[i][j] = group;
                }
            }
            else {
                for(int j = m - 1; j >= 0; --j) {
                    if(rest == 0) {
                        group++;
                        if(group == count - 1) {
                            rest = 1000000000;
                        }
                        else
                            rest = group + 1;
                    }
                    --rest;
                    ans[i][j] = group;
                }
            }
        }

        char[] c = new char[count];

        HashSet<Integer>[] neighbors = new HashSet[count];

        for(int i = 0; i < count; ++i) {
            neighbors[i] = new HashSet<Integer>();
        }


        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m - 1; ++j) {
                neighbors[ans[i][j]].add(ans[i][j + 1]);
                neighbors[ans[i][j + 1]].add(ans[i][j]);
            }
        }
        for(int i = 0; i < n - 1; ++i) {
            for(int j = 0; j < m; ++j) {
                neighbors[ans[i][j]].add(ans[i + 1][j]);
                neighbors[ans[i + 1][j]].add(ans[i][j]);
            }
        }

        for(int i = 0; i < count; ++i) {
            HashSet<Character> disallowed = new HashSet<Character>();
            for (Integer neighbor : neighbors[i]) {
                if(neighbor >= i)
                    continue;

                disallowed.add(c[neighbor]);
            }

            c[i] = 'A';
            while (disallowed.contains(c[i]))
                ++c[i];
        }

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                out.print(c[ans[i][j]]);
            }
            out.println();
        }


    }
}
