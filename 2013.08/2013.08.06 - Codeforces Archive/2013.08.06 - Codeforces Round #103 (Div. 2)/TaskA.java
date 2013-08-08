package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        int firstMax = 0;
        int lastMin = 0;
        for(int i = 0; i < n; ++i) {
            if(a[i] > a[firstMax])
                firstMax = i;
            if(a[i] <= a[lastMin])
                lastMin = i;
        }
        int answer = (n - 1 - lastMin) + firstMax;
        if(lastMin < firstMax)
            --answer;
        out.println(answer);
    }
}
