package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.ArrayList;

public class DecreasingInfluence {
    public static int MOD = 1000000007;
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[] parents = in.nextIntArray(n - 1);
        for(int i = 0; i < parents.length; ++i)
            --parents[i];

        int[] degree = new int[n];
        for(int p: parents)
            degree[p]++;

        g = new int[n][];
        tin = new int[n];
        tout = new int[n];
        level = new int[n];
        for(int i = 0; i < n; ++i) {
            g[i] = new int[degree[i]];
        }

        for(int i = 0; i < parents.length; ++i) {
            g[parents[i]][--degree[parents[i]]] = i + 1;
        }

        dfs(0, 0);

        int q = in.nextInt();
        SegTree tree = new SegTree(n);
        for(int i = 0; i < q; ++i) {
            int t = in.nextInt();
            int v = in.nextInt() - 1;
            if(t == 1) {
                long x = in.nextInt();
                long k = in.nextInt();
                tree.update(tin[v], tout[v], (x + level[v] * k) % MOD, k);
            }
            else {
                out.println(tree.get(tin[v], level[v]));
            }
        }

    }

    int[][] g;
    int[] tin, tout;
    ArrayList<Integer> order = new ArrayList<Integer>();
    int[] level;

    void dfs(int v, int level) {
        tin[v] = order.size();
        order.add(v);
        this.level[v] = level;

        for(int to: g[v])
            dfs(to, level + 1);

        tout[v] = order.size();
    }


    static class SegTree {
        private int shift;
        private long[] sumX;
        private long[] sumK;

        SegTree(int n) {
            shift = 1;
            while (shift < n)
                shift <<= 1;
            sumX = new long[2 * shift];
            sumK = new long[2 * shift];
        }

        private void realUpdate(int l, int r, long x, long k) {
            if(l >= r)
                return;
            if(l % 2 != 0) {
                sumX[l] += x;
                sumK[l] += k;
                sumX[l] %= MOD;
                sumK[l] %= MOD;
                realUpdate(l + 1, r, x, k);
                return;
            }

            if(r % 2 != 0) {
                --r;
                sumX[r] += x;
                sumK[r] += k;
                sumX[r] %= MOD;
                sumK[r] %= MOD;
                realUpdate(l, r, x, k);
                return;
            }

            realUpdate(l / 2, r / 2, x, k);
        }

        public void update(int l, int r, long x, long k) {
            realUpdate(l + shift, r + shift, x, k);
        }


        public long get(int v, int level) {
            long result = 0;
            v += shift;
            for (;v > 0; v >>= 1) {
                result += sumX[v] - level * sumK[v];
                result %= MOD;
            }
            if(result < 0)
                result += MOD;
            return result;
        }


    }
}
