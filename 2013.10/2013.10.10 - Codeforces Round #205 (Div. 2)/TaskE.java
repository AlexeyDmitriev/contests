package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.ArrayList;

public class TaskE {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        String s = in.nextString();
        int n = s.length();
        if(s.charAt(0) == s.charAt(n - 1)) {
            for(int i = 0; i < n; ++i) {
                if(s.charAt(i) != s.charAt(i + 1)) {
                    s = s.substring(i + 1) + s.substring(0, i + 1);
                    break;
                }
            }
        }

        ArrayList<Integer> sizes = new ArrayList<Integer>();
        int ans = 0;
        int start = 0;
        for(int i = 0; i <= n; ++i) {
            if(i == n || s.charAt(i) != s.charAt(start)) {
                sizes.add(i - start);
                if(i - start > 1)
                    ++ans;
                start = i;
            }
        }

        ArrayList<Integer> groups = new ArrayList<Integer>();

        start = 0;
        for(int i = 0; i <= sizes.size(); ++i) {
            if(i == sizes.size() || sizes.get(i) != 1) {
                int length = i - start;
                if(length > 0)
                    groups.add(length);
                start = i + 1;
            }
        }



        if(groups.size() > 1 && sizes.get(0) == 1 && sizes.get(sizes.size() - 1) == 1) {
            groups.set(0, groups.get(groups.size() - 1) + groups.get(0));
            groups.remove(groups.size() - 1);
        }
        for (int group : groups) {
            ans += group / 2;
        }
        out.println(ans);
    }

}
