package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskC {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int m = in.nextInt();
        int n = in.nextInt();

        int[] a = new int[n + 20];
        for(int i = 0; i < n; ++i) {
            a[i + 3] = in.nextInt();
        }

        for(int i = 0; i < n; ++i) {
            if(a[i] + a[i + 1] + a[i + 2] + a[i + 3] > m) {

                out.print(i == 0 ? 0 : i - 1);
                return;
            }
        }

        out.print(n - 1);



    }
}
