package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.TreeSet;

public class SquareDetector {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        TreeSet<Integer> rows = new TreeSet<Integer>();
        TreeSet<Integer> columns = new TreeSet<Integer>();
        int all = 0;
        int n = in.nextInt();
        for(int i = 0; i < n; ++i) {
            String s = in.nextString();
            for(int j = 0; j < n; ++j) {
                if(s.charAt(j) == '#') {
                    rows.add(i);
                    columns.add(j);
                    ++all;
                }
            }
        }
        out.print("Case #" + testNumber + ": ");
        if(rows.size() == columns.size() && rows.size() * columns.size() == all && rows.first() + rows.size() - 1 == rows.last() && columns.first() + columns.size() - 1 == columns.last()){
            out.println("YES");
        }
        else
            out.println("NO");
    }
}
