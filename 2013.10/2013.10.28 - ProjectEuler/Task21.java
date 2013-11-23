package main;

import name.admitriev.spsl.collections.ListUtils;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.numbers.IntegerUtils;

public class Task21 {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[] sums = new int[n + 1];
        for(int i = 1; i <= n; ++i) {
            sums[i] = (int) ListUtils.sum(IntegerUtils.getDivisors(i)) - i;
        }
        int ans = 0;
        for(int i = 1; i <= n; ++i) {
            if(sums[i] <= n && sums[sums[i]] == i && i != sums[i]) {
                ans += i;
            }
        }
        out.println(ans);
    }
}
