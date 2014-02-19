package main;

import name.admitriev.spsl.collections.ArrayUtils;
import name.admitriev.spsl.collections.Pair;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TaskC3 {

    public void solve(int testNumber, Reader in, OutputWriter out){
        int n = in.nextInt();
        int k = in.nextInt() - 1;
        if(k == n) {
            out.println(0);
            return;
        }
        ArrayList<Pair<Integer, Integer>> opponents = new ArrayList<Pair<Integer, Integer>>(n);
        //points, energy
        for(int i = 0; i < n; ++i) {
            opponents.add(new Pair<Integer, Integer>(in.nextInt(), in.nextInt()));
        }

        Collections.sort(opponents, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return Integer.compare(o2.first, o1.first);
            }
        });

        int pointsThreshold = opponents.get(k).first;
        long ans = Long.MAX_VALUE;
        {
            if(pointsThreshold + 2 <= n) {
                int[] energy = new int[n];
                for(int i = 0; i < n; ++i){
                    energy[i] = opponents.get(i).second;
                }
                ArrayUtils.sort(energy);
                int curAns = 0;
                for(int i = 0; i < pointsThreshold + 2; ++i) {
                    curAns += energy[i];
                }

                ans = Math.min(curAns, ans);
            }
        }
        {
            int pointsTry = pointsThreshold + 1;
            if(pointsTry <= n) {

                ArrayList<Integer> more = new ArrayList<Integer>();
                ArrayList<Integer> median = new ArrayList<Integer>();
                ArrayList<Integer> less = new ArrayList<Integer>();

                for(int i = 0; i < n; ++i) {
                    int energy = opponents.get(i).second;
                    int points = opponents.get(i).first;
                    if(points < pointsThreshold) {
                        less.add(energy);
                    }
                    else if(points > pointsThreshold + 1)
                        more.add(energy);
                    else
                        median.add(energy);
                }


                int needWonMedian = Math.max(0, n - k - less.size());

                more.addAll(less);
                Collections.sort(more);
                Collections.sort(median);
//needWonMedian = Math.max(needWonMedian, pointsTry - more.size());
                long sumOthers = 0;


                if(pointsTry >= needWonMedian) {
                    for(int i = 0; i < pointsTry - needWonMedian; ++i) {
                        sumOthers += more.get(i);
                    }

                    long sumMedian = 0;

                    for(int i = 0; i < needWonMedian; ++i) {
                        sumMedian += median.get(i);
                    }

                    ans = Math.min(ans, sumMedian + sumOthers);

                    for(int j = needWonMedian, toDelete = pointsTry - needWonMedian - 1; toDelete >= 0 && j < median.size(); --toDelete, ++j) {
                        sumOthers -= more.get(toDelete);
                        sumMedian += median.get(j);

                        ans = Math.min(ans, sumMedian + sumOthers);
                    }
                }





            }
        }
        {
            int pointsTry = pointsThreshold;
            if(pointsTry <= n) {

                ArrayList<Integer> more = new ArrayList<Integer>();
                ArrayList<Integer> median = new ArrayList<Integer>();
                ArrayList<Integer> less = new ArrayList<Integer>();

                for(int i = 0; i < n; ++i) {
                    int energy = opponents.get(i).second;
                    int points = opponents.get(i).first;
                    if(points < pointsThreshold - 1) {
                        less.add(energy);
                    }
                    else if(points > pointsThreshold)
                        more.add(energy);
                    else
                        median.add(energy);
                }


                int needWonMedian = Math.max(0, n - k - less.size());

                more.addAll(less);
                Collections.sort(more);
                Collections.sort(median);

                //needWonMedian = Math.max(needWonMedian, pointsTry - more.size());
                long sumOthers = 0;


                if(pointsTry >= needWonMedian) {
                    for(int i = 0; i < pointsTry - needWonMedian; ++i) {
                        sumOthers += more.get(i);
                    }

                    long sumMedian = 0;

                    for(int i = 0; i < needWonMedian; ++i) {
                        sumMedian += median.get(i);
                    }

                    ans = Math.min(ans, sumMedian + sumOthers);

                    for(int j = needWonMedian, toDelete = pointsTry - needWonMedian - 1; toDelete >= 0 && j < median.size(); --toDelete, ++j) {
                        sumOthers -= more.get(toDelete);
                        sumMedian += median.get(j);

                        ans = Math.min(ans, sumMedian + sumOthers);
                    }
                }



            }
        }

        if(ans == Long.MAX_VALUE)
            ans = -1;

        out.println(ans);
    }
}