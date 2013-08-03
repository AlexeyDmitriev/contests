package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.HashMap;
import java.util.TreeSet;

public class TaskB {

    TreeSet<Integer>[] positions = new TreeSet[26];
    String s;
    public void solve(int testNumber, Reader in, OutputWriter out) {
        s = in.nextString();

        for(int i = 0; i < 26; ++i) {
            positions[i] = new TreeSet<Integer>();
        }

        for(int i = 0; i < s.length(); ++i) {
            positions[s.charAt(i) - 'a'].add(i);
        }

        String res = solve(0, s.length(), 100);
        if(res.length() > 100) {
            res = res.substring(0, 50) + res.substring(res.length() - 50, res.length());
        }
        out.println(res);
    }

    HashMap<Long, String> memo = new HashMap<Long, String>();

    private String solve(int l, int r, int rest) {
        if(rest == 0)
            return "";
        if(l == r)
            return "";
        if(l > r)
            throw new AssertionError();
        long key = l * 1000000L + r;
        if(memo.containsKey(key))
            return memo.get(key);

        String best = "";
        for(int i = 0; i < 26; ++i) {
            Integer il = positions[i].higher(l - 1);
            if(il == null)
                continue;
            Integer ir = positions[i].lower(r);
            if(ir == null)
                continue;
            if(il + 1 > ir)
                continue;
            String cur = solve(il + 1, ir, rest - 2);
            if(cur.length() + 2 > best.length()) {
                best = ((char)('a' + i)) + cur + ((char)('a' + i));
            }

            if(best.length() >= rest)
                return best;
        }

        if(best.length() == 0) {
            best = String.valueOf(s.charAt(l));
        }

        memo.put(key, best);
        //System.out.println(l + " " + r + " " + best);
        return best;
    }

}
