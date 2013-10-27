package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskE {
    HashMap<Long, ArrayList<ArrayList<Integer>> > memo = new HashMap<Long, ArrayList<ArrayList<Integer>>>();
    ArrayList<Integer>[] dp = new ArrayList[43];
    {
        dp[0] = new ArrayList<Integer>();
        int[] digits = {4, 7};
        for(int i = 1; i <= 42; ++i) {
            for (int digit : digits) {
                int p = i - digit;
                if(p < 0) {
                    continue;
                }
                if(dp[p] == null)
                    continue;

                if((dp[i] == null || dp[p].size() + 1 < dp[i].size()) && dp[p].size() <= 5) {
                    dp[i] = new ArrayList<Integer>();
                    dp[i].addAll(dp[p]);
                    dp[i].add(digit);
                }
            }
        }
        for(int i = 0; i <= 42; ++i) {
            if(dp[i] == null)
                continue;
            while (dp[i].size() < 6)
                dp[i].add(0);
        }

        memo.put(0L, new ArrayList<ArrayList<Integer>>());
        for(int i = 0; i <= 42; ++i)
            if(dp[i] != null && dp[i].size() != 6)
                throw new AssertionError(i);
    }



    ArrayList<ArrayList<Integer>> solve(long x) {
        if(memo.containsKey(x)) {
            return memo.get(x);
        }
        if(x < 0)
            return null;
        for(int c = (int) (x % 10); c <= 42; c += 10){
            if(dp[c] == null)
                continue;
            ArrayList<ArrayList<Integer>> res = solve((x - c) / 10);
            if(res != null) {
                ArrayList<ArrayList<Integer>> newRes = new ArrayList<ArrayList<Integer>>();
                newRes.addAll(res);
                newRes.add(dp[c]);
                memo.put(x, newRes);

                return newRes;
            }
        }


        return null;

    }
    public void solve(int testNumber, Reader in, OutputWriter out) {
        long x = in.nextLong();
        ArrayList<ArrayList<Integer>> res = solve(x);
        //System.err.println(res);
        if(res == null) {
            out.print(-1);
        }
        else {

            for(int j = 0; j < 6; ++j) {
                boolean flag = false;
                for(int i = 0; i < res.size(); ++i) {
                    if(flag || res.get(i).get(j) != 0) {
                        flag = true;
                        out.print(res.get(i).get(j));
                    }
                }

                if(!flag)
                    out.print("0");
                out.print(" ");
            }

        }
        out.println();

    }
}
