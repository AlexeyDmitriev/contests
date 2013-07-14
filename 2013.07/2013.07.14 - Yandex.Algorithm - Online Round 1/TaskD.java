package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;

public class TaskD {

    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        String[] s = in.nextStringArray(n);

        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -Integer.compare(o1.length(), o2.length());
            }
        });

        int[] countG = new int[s[0].length()];
        int[] countS = new int[s[0].length()];

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < s[i].length(); ++j)  {
                if(s[i].charAt(j) == 'G')
                    countG[j]++;
                else
                    countS[j]++;
            }
        }

        int ans = 0;

        for(int i = 0; i < n; ++i) {
            if(try_(countG, s[i].length())) {
                ++ans;
            }
            else if(try_(countS, s[i].length())) {
                ++ans;
            }

        }

        out.println(ans);
    }

    private boolean try_(int[] count, int length) {
        for(int i = 0; i < length; ++i) {
            if(count[i] == 0) {
                return false;
            }
        }
        for(int i = 0; i < length; ++i) {
            count[i]--;
        }
        return true;
    }
}
