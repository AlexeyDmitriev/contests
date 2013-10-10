package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskB {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(2 * n);
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < 2 * n; ++i) {
            if(!map.containsKey(a[i]))
                map.put(a[i], new ArrayList<Integer>());

            map.get(a[i]).add(i);
        }

        int oneTime = 0;
        int twoTimes = 0;

        int where = 1;
        int[] rest = new int[]{n, n};

        int[] ans = new int[2 * n];

        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            if(entry.getValue().size() >= 2) {
                ans[entry.getValue().get(0)] = 1;
                ans[entry.getValue().get(1)] = 2;
                --rest[0];
                --rest[1];
                ++twoTimes;
            }
            else {

                ans[entry.getValue().get(0)] = where;
                --rest[where - 1];
                where = 3 - where;
                ++oneTime;
            }

        }

        //out.println(Arrays.toString(ans) + " " + Arrays.toString(rest));


        out.println((twoTimes + oneTime / 2) * (twoTimes + (oneTime + 1) / 2));

        for(int i = 0; i < 2 * n; ++i) {
            if(ans[i] != 0) {
                out.print(ans[i] + " ");
            }
            else if(rest[0] > 0) {
                --rest[0];
                out.println("1 ");
            }
            else {
                out.print("2 ");
            }
        }
    }
}
