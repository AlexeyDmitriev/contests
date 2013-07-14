package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.HashSet;

public class TaskF {

    HashSet<String>[] suffixes;

    HashSet<String>[] substrings;
    HashSet<String>[] prefixes;

    HashSet<String> strings;

    String needle;

    int d;

    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        d = in.nextInt();
        String[] stickers = in.nextStringArray(n);
        
        needle = in.nextString();

        suffixes = new HashSet[d + 1];
        prefixes = new HashSet[d + 1];
        substrings = new HashSet[d + 1];

        strings = new HashSet<String>();

        for(int i = 0; i <= d; ++i) {
            suffixes[i] = new HashSet<String>();
            prefixes[i] = new HashSet<String>();
            substrings[i] = new HashSet<String>();
        }

        for(int i = 0; i < n; ++i) {
            String cur = stickers[i];
            for(int j = 0; j <= d; ++j) {
                prefixes[j].add(cur.substring(0, j));
                suffixes[j].add(cur.substring(d - j, d));
            }

            for(int a = 0; a <= d; ++a) {
                for(int b = a + 1; b <= d; ++b){
                    substrings[b - a].add(cur.substring(a, b));
                }
            }
            strings.add(cur);
        }

        long result = solve(0, false);

        if(result >= 100000)
            out.println("NO");
        else
            out.println(result);

    }

    long[][] p = new long[100000][2];

    private long solve(int start, boolean mayBeNotPrefix) {
        if(p[start][mayBeNotPrefix ? 1 : 0] != 0) {
            return p[start][mayBeNotPrefix ? 1 : 0];
        }
        if(start == needle.length()) {
            if(mayBeNotPrefix)
                return 0;
            else
                return p[start][mayBeNotPrefix ? 1 : 0] =100000;
        }

        if(!mayBeNotPrefix) {

            long res = 100000;
            for(int i = 1; i < d && start + i <= needle.length(); ++i) {

                if(prefixes[i].contains(needle.substring(start, start + i))){
                    res = Math.min(res, 1 + solve(start + i, false));
                }
            }
            if(start + d <= needle.length()) {
                if(strings.contains(needle.substring(start, start + d))) {
                    res = Math.min(res, 1 + solve(start + d, true));
                }
            }
            //System.out.println(start + " false " + res);
            return p[start][mayBeNotPrefix ? 1 : 0] =res;
        }

        long res = 100000;

        for(int i = 1; i <= d && start + i <= needle.length(); ++i) {
            if(suffixes[i].contains(needle.substring(start, start + i))) {
                res = Math.min(res, 1 + solve(start + i, true));
            }
        }

        for(int i = 1; i <= d && start + i <= needle.length(); ++i) {
            if(substrings[i].contains(needle.substring(start, start + i))) {
                res = Math.min(res, 1 + solve(start + i, false));

            }
        }
        //System.out.println(start + " true " + res);
        return p[start][mayBeNotPrefix ? 1 : 0] = res;
    }
}
