package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        long l = in.nextInt();
        long r = in.nextInt();
        long ql = in.nextInt();
        long qr = in.nextInt();
        long[] w = in.nextLongArray(n);
        long sum = 0;

        long sumAll = 0;
        for (long l1 : w) {
            sumAll += l1;
        }


        long ans = Integer.MAX_VALUE;

        for(int i = 0; i <= n; ++i) {

            long cur = sum * l + (sumAll - sum )*r;
            if(i > (n - i) + 1) {
                cur += ql * (i - (n - i + 1));
            }
            if(i + 1 < (n - i) )
                cur += qr * (n - i - i - 1);


            ans = Math.min(cur, ans);

            if(i != n)
                sum += w[i];
        }


        out.println(ans);

    }
}
