package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

import java.util.Arrays;

public class TaskC {

    int[][] memo = new int[4][101];
    public void solve(int testNumber, Reader in, OutputWriter out) {

        for(int i = 0; i < 4; ++i){
            Arrays.fill(memo[i], -1);
        }
        int n = in.nextInt();
        boolean[][] bad = new boolean[n][2];
        int cnt = in.nextInt();
        for(int i = 0; i < cnt; ++i) {
            bad[in.nextInt() - 1][in.nextInt() - 1] = true;
        }

        int l = 0;

        int startType = 0;

        int xor = 0;

        for(int i = 0; i < n; ++i) {
            if(!bad[i][0] && !bad[i][1]) {
                continue;
            }

            int newStartType = bad[i][0] ? 2 : 1;
            if(i == l) {
                startType = newStartType;
                l = i + 1;
                continue;
            }
            int len = i - l;

            if(startType == 0)
                xor ^= solveB(len);
            else if(startType == newStartType)
                xor ^= solveC(len);
            else
                xor ^= solveD(len);

            startType = newStartType;

            l = i + 1;
        }

        if(l != n) {
            int len = n - l;
            if(startType == 0)
                xor ^= solveA(len);
            else
                xor ^= solveB(len);
        }

        if(xor == 0)
            out.println("LOSE");
        else
            out.println("WIN");
    }

    private int solveA(int len) {
        if(memo[0][len] != -1)
            return memo[0][len];
        boolean[] mex = new boolean[4 * len + 1];

        if(len == 1)
            return 1;

        mex[solveB(len - 1)] = true;

        for(int i = 1; len - 1 - i > 0; ++i) {
            mex[solveB(i) ^ solveB(len - 1 - i)] = true;
        }

        int res = 0;
        while (mex[res])
            ++res;
        return memo[0][len] = res;
    }

    private int solveB(int len) {
        if(memo[1][len] != -1)
            return memo[1][len];
        boolean[] mex = new boolean[4 * len + 1];

        if(len == 1)
            return 1;

        mex[solveB(len - 1)] = true;
        mex[solveC(len - 1)] = true;
        mex[solveD(len - 1)] = true;

        for(int i = 1; len - 1 - i > 0; ++i) {
            mex[solveB(i) ^ solveC(len - 1 - i)] = true;
            mex[solveB(i) ^ solveD(len - 1 - i)] = true;
        }

        int res = 0;
        while (mex[res])
            ++res;
        return memo[1][len] = res;
    }

    private int solveC(int len) {
        if(memo[2][len] != -1)
            return memo[2][len];

        boolean[] mex = new boolean[4 * len + 1];

        if(len == 1)
            return 1;

        mex[solveC(len - 1)] = true;

        for(int i = 1; len - 1 - i > 0; ++i) {
            mex[solveC(i) ^ solveC(len - 1 - i)] = true;
            mex[solveD(i) ^ solveD(len - 1 - i)] = true;
        }

        int res = 0;
        while (mex[res])
            ++res;
        return memo[2][len] = res;
    }

    private int solveD(int len) {
        if(memo[3][len] != -1)
            return memo[3][len];
        boolean[] mex = new boolean[4 * len + 1];

        if(len == 1)
            return 0;

        mex[solveD(len - 1)] = true;

        for(int i = 1; len - 1 - i > 0; ++i) {
            mex[solveC(i) ^ solveD(len - 1 - i)] = true;
        }

        int res = 0;
        while (mex[res])
            ++res;
        return memo[3][len] = res;
    }
}
