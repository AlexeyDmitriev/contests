package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.HashSet;

public class MagicPairs {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        long x1 = in.nextLong(); 
        long a1 = in.nextLong(); 
        long b1 = in.nextLong(); 
        long c1 = in.nextLong(); 
        long r1 = in.nextLong();
        long x2 = in.nextLong();
        long a2 = in.nextLong();
        long b2 = in.nextLong();
        long c2 = in.nextLong();
        long r2 = in.nextLong();
        long[] board1 = new long[n];
        long[] board2 = new long[m];
        board1[0] = x1;
        board2[0] = x2;
        for(int i = 1; i < n || i < m; ++i) {
            if(i < n) {
                board1[i] = (a1 * board1[(i-1) % n] + b1 * board2[(i-1) % m] + c1) % r1;
            }
            if(i < m) {
                board2[i] = (a2 * board1[(i-1) % n] + b2 * board2[(i-1) % m] + c2) % r2;
            }
        }

        HashSet<Long> colorsInFirst = new HashSet<Long>();
        HashSet<Long> colorsInSecond = new HashSet<Long>();
        int sameSetSince = 0;
        int badElemSince = 0;
        long ans = 0;
        loop: for(int i = 0; i < n; ++i) {
            if(colorsInFirst.contains(board1[i])) {
                ans += badElemSince - sameSetSince;
                continue;
            }
            colorsInFirst.add(board1[i]);
            sameSetSince = badElemSince;
            boolean sameSetSinceSet = false;
            while (badElemSince < m) {
                if(!colorsInFirst.contains(board2[badElemSince])) {
                    break;
                }
                colorsInSecond.add(board2[badElemSince]);
                if(colorsInSecond.size() == colorsInFirst.size() && !sameSetSinceSet) {
                    sameSetSinceSet = true;
                    sameSetSince = badElemSince;
                }
                ++badElemSince;
            }
            if(!sameSetSinceSet) {
                sameSetSince = badElemSince;
            }
            else
                ans += badElemSince - sameSetSince;
        }
        out.println("Case #" + testNumber + ": " + ans);

    }
}
