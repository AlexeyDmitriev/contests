package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

public class Task19 {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        int x = 1;
        int ans = 0;
        int ans2 = 0;
        for(int year = 1900; year <= 2000; ++year) {
            for(int month = 0; month < 12; ++month) {

                int d = days[month];
                if(month == 1 && isLeapYear(year)) {
                    ++d;
                }
                x += d;
                x %= 7;

                if(x == 0) {
                    //out.println("? + " + year + " " + (month + 2));
                    if(year != 1900) {
                        ++ans;

                    }
                }
            }
        }
        out.println(ans);
    }

    private boolean isLeapYear(int d) {
        return d % 4 == 0 && (d % 100 != 0 || d % 400 == 0);
    }
}
