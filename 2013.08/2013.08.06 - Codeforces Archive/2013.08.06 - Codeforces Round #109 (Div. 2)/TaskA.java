package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        int max = a[0];
        int min = a[0];
        int answer = 0;
        for(int i = 1; i < n; ++i) {
            if(a[i] > max) {
                max = a[i];
                ++answer;
            }
            if(a[i] < min) {
                min = a[i];
                ++answer;
            }
        }
        out.println(answer);
    }
}
