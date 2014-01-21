package main;

import java.util.Arrays;

public class AlienAndSetDiv1 {
    int K;
    int N;
    private int mod = 1000000007;

    public int getNumber(int N, int K) {
        this.K = K - 1;
        this.N = N;
        Arrays.fill(memo, -1);
        return solve(0, 0, 0);
    }


    int[] memo = new int[6000000];

    int solve(int n, int inLeft, int lastKinLeft) {
        lastKinLeft = lastKinLeft & ((1 << K) - 1);
        int key = n + inLeft * 55 + lastKinLeft * 55 * 55;
        if(memo[key] != -1)
            return memo[key];
        if(n == 2 * N) {
            return 1;
        }
        int inRight = n - inLeft;
        int numberLastInLeft = Integer.bitCount(lastKinLeft);
        int numberLastInRight = Math.min(n, K) - numberLastInLeft;
        int ans = 0;
        if(inLeft < N) {

            if(inLeft >= inRight || (inRight - inLeft) > numberLastInRight) {
                ans += solve(n + 1, inLeft + 1, next(lastKinLeft) + 1);
            }

        }
        if(inRight < N) {
            if(inRight >= inLeft || (inLeft - inRight) > numberLastInLeft) {
                ans += solve(n + 1, inLeft, next(lastKinLeft));
            }
        }
        if(ans > mod)
            ans -= mod;
        memo[key] = ans;

        return ans;
    }

    private int next(int lastKinLeft) {
        return (lastKinLeft << 1) & ((1 << K) - 1);
    }
}