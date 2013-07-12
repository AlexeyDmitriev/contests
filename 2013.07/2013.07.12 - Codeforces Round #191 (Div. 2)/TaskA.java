package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        int ones = 0;
        for(int i = 0; i < n; ++i) {
            if(a[i] == 1)
                ++ones;
        }

        int result = 0;

        for(int i = 0; i < n; ++i) {
            for(int j = i; j < n; ++j){
                int balance = 0;
                for(int k = i; k <= j; ++k) {
                    if(a[k] == 0){
                        ++balance;
                    }
                    else
                        --balance;
                }
                result = Math.max(ones + balance, result);
            }
        }

        out.print(result);

    }
}
