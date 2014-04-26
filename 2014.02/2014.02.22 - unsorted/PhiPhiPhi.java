package main;

import name.admitriev.spsl.collections.ListUtils;
import name.admitriev.spsl.collections.Pair;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.misc.Filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhiPhiPhi {
    private static final Pair<Long, Long> BAD_PAIR = new Pair<Long, Long>(0L, 0L);
    int maxP = 1000000;
    int[] leastPrime = new int[maxP + 1];

    List<Integer> primes = new ArrayList<Integer>();

    //TODO: change to arrays
    List<Pair<Long, Long>>[] segments = new ArrayList[maxP + 1];
    long[] ans = new long[maxP + 1];


    void sieve() {
        for(int i = 2; i <= maxP; ++i) {
            if(leastPrime[i] == 0) {
                leastPrime[i] = i;
                primes.add(i);
                segments[i] = new ArrayList<Pair<Long, Long>>();
            }

            for(int prime: primes) {
                if(prime > leastPrime[i] || i * prime > maxP) {
                    break;
                }
                leastPrime[i * prime] = prime;
            }
        }
    }

    void addSegment(int p, long l, long r) {
        for(;p > 1; p /= leastPrime[p]) {
            int lp = leastPrime[p];
            int index = segments[lp].size();
            segments[lp].add(new Pair<Long, Long>(l, r));

            while(index > 0 && segments[lp].get(index).compareTo(segments[lp].get(index - 1)) < 0) {
                Collections.swap(segments[lp], index, index - 1);
                --index;
            }
            for(int i = 0; i + 1 < segments[lp].size(); ++i) {
                if(segments[lp].get(i).second >= segments[lp].get(i + 1).first) {
                    segments[lp].get(i).second += segments[lp].get(i + 1).second - segments[lp].get(i + 1).first;
                    segments[lp].set(i + 1, segments[lp].get(i));
                    segments[lp].set(i, BAD_PAIR);
                }
            }

            //TODO: speed up
            segments[lp] = ListUtils.filter(segments[lp], new Filter<Pair<Long, Long>>() {
                @Override
                public boolean accept(Pair<Long, Long> value) {
                    return !value.equals(BAD_PAIR);
                }
            });


        }
    }
    public void solve(int testNumber, Reader in, OutputWriter out) {
        sieve();
        int n = in.nextInt();
        for(int i = 0; i < n; ++i) {
            int p = in.nextInt();
            long a = in.nextLong();

            segments[p].add(new Pair<Long, Long>(0L, a));
        }
        long k = in.nextLong();

        for(int i = maxP; i >= 2; --i) {
            if(segments[i] == null)
                continue;
            for(Pair<Long, Long> seg: segments[i]) {
                if(seg.first < k) {
                    addSegment(i - 1, seg.first + 1, Math.min(seg.second, k) + 1);
                }
                if(seg.second > k) {
                    ans[i] += seg.second - Math.max(seg.first, k);
                }
            }
        }

        int cnt = 0;
        for(int i = 2; i <= maxP; ++i) {
            if(ans[i] > 0) {
                ++cnt;
            }
        }
        out.println(cnt);
        for(int i = 2; i <= maxP; ++i) {
            if(ans[i] > 0) {
                out.println(i, ' ', ans[i]);
            }
        }
    }
}