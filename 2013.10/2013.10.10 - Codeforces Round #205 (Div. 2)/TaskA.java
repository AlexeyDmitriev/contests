package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int both = 0;
        int one = 0;
        int top = 0;
        for(int i = 0; i < n; ++i) {
            int a = in.nextInt();
            int b = in.nextInt();
            int cnt = 0;
            if(a % 2 == 1)
                ++cnt;
            if(b % 2 == 1)
                ++cnt;


            if(cnt == 2) {
                ++both;
            }
            else if(cnt == 1) {
                ++one;
                if(a % 2 == 1)
                    ++top;
            }

        }



        if(one % 2 == 1 || (both % 2 == 1 && one == 0)) {
            out.println(-1);
        }
        else if((top + both) % 2 == 0) {
            out.print(0);
        }
        else {
            out.println(1);
        }
    }
}
