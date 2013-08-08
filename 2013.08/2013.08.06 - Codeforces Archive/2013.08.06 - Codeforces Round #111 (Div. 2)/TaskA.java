package main;

import name.admitriev.spsl.collections.ArrayUtils;
import name.admitriev.spsl.collections.ListUtils;
import name.admitriev.spsl.collections.array.IntArray;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.misc.ReverseComparator;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        ArrayUtils.sort(a, new ReverseComparator<Integer>());
        int sum = ListUtils.sum(new IntArray(a));
        int currentSum = 0;
        for(int i = 0; i <= n; ++i) {
            if(currentSum * 2 > sum) {
                out.println(i);
                return;
            }
            currentSum += a[i];
        }
    }
}
