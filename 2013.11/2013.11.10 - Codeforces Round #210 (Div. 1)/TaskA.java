package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

import java.util.Arrays;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] added = new int[n];
        int[] maxValue = new int[n];
        Arrays.fill(maxValue, 1000000000);

        int[] t = new int[m];
        int[] l = new int[m];
        int[] r = new int[m];
        int[] d = new int[m];
        for(int i = 0; i < m; ++i) {
            t[i] = in.nextInt();
            l[i] = in.nextInt();
            r[i] = in.nextInt();
            d[i] = in.nextInt();
            if(t[i] == 1){
                for(int j = l[i] - 1; j < r[i]; ++j) {
                    added[j] += d[i];
                }

            }
            else {
                for(int j = l[i] - 1; j < r[i]; ++j) {
                    maxValue[j] = Math.min(maxValue[j], d[i] - added[j]);
                }
            }
        }
        for(int i = 0; i < n; ++i) {
            added[i] = maxValue[i];
        }
        for(int i = 0; i < m; ++i) {
           if(t[i] == 1){
                for(int j = l[i] - 1; j < r[i]; ++j) {
                    added[j] += d[i];
                }

            }
            else {
               int mx = -1000000000;


               for(int j = l[i] - 1; j < r[i]; ++j) {
                    mx = Math.max(mx, added[j]);
               }

               if(mx != d[i]) {
                   out.println("NO");
                   return;
               }
            }
        }
         out.println("YES");
        for(int i = 0; i < n; ++i)
            out.print(maxValue[i] + " ");


    }
}
