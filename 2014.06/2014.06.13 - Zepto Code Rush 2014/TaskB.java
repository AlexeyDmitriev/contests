package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        String[] s = in.nextStringArray(n);
        int[] ans = new int[m];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if (s[i].charAt(j) == 'R') {
                    if(j + i < m) {
                        ans[j + i] ++;
                    }
                }
                if(s[i].charAt(j) == 'L') {
                    if(j - i >= 0) {
                        ans[j - i]++;
                    }
                }
                if(s[i].charAt(j) == 'U') {
                    if(i % 2 == 0) {
                        ans[j] ++;
                    }
                }
            }
        }
        for(int i = 0; i < m; ++i) {
            out.print(ans[i] + " ");
        }
    }
}
