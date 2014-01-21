package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AlienAndHamburgers {
    public int getNumber(int[] type, int[] taste) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < type.length; ++i) {
            if(!map.containsKey(type[i]))
                map.put(type[i], new ArrayList<Integer>());
            map.get(type[i]).add(taste[i]);
        }
        ArrayList<Integer> sums = new ArrayList<Integer>();
        for (ArrayList<Integer> list : map.values()) {
            int mx = Integer.MIN_VALUE;

            int sum = 0;
            for (int integer : list) {
                if(integer > 0)
                    sum += integer;
                mx = Math.max(mx, integer);
            }

            if(sum > 0)
                sums.add(sum);
            else
                sums.add(mx);
        }


        Collections.sort(sums, Collections.reverseOrder());
        //System.out.println(sums);

        int curSum = 0;
        int answer = 0;

        for(int i = 0; i < sums.size(); ++i) {
            curSum += sums.get(i);
            answer = Math.max(curSum * (i + 1), answer);
        }
        return answer;
    }
}