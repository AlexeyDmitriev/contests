package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskA1 {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        long[] sumPositive = new long[n + 1];

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

        for(int i = 0; i < n; ++i){
            sumPositive[i + 1] = sumPositive[i] + Math.max(a[i], 0);
            if(!map.containsKey(a[i])) {
                map.put(a[i], new ArrayList<Integer>());
            }
            map.get(a[i]).add(i);
        }

        long bestRes = Long.MIN_VALUE;
        int bestNumber = 0;

        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            if(entry.getValue().size() < 2)
                continue;

            int last = entry.getValue().get(entry.getValue().size() - 1);
            int first = entry.getValue().get(0);
            long sum = sumPositive[last] - sumPositive[first + 1] + 2 * entry.getKey();

            if(sum > bestRes) {
                bestRes = sum;
                bestNumber = entry.getKey();
            }
        }

        int last = map.get(bestNumber).get(map.get(bestNumber).size() - 1);
        int first = map.get(bestNumber).get(0);

        ArrayList<Integer> toCut = new ArrayList<Integer>();

        for(int i = 0; i < n; ++i) {
            if(i < first || i > last || (a[i] < 0 && i != last && i != first)) {
                toCut.add(i);
            }
        }

        out.println(bestRes + " " + toCut.size());
        for (Integer integer : toCut) {
            out.print(integer + 1 + " ");
        }



    }
}
