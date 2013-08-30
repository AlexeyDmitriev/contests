package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        int n = in.nextInt();
        int velocity = 0;
        int d = 0;
        long x = 0;
        long y = 0;
        for(int i = 0; i < n; ++i) {
            String s = in.nextString();
            if(s.equals("Fwrd") && velocity == 0) {
                velocity = 1;
            }
            else if(s.equals("Back") && velocity == 0) {
                velocity = -1;
            }
            else if(s.equals("More") && velocity > 0 && velocity < 5) {
                ++velocity;
            }
            else if(s.equals("Less") && velocity > 0) {
                --velocity;
            }
            else if(s.equals("Stop")) {
                velocity = 0;
            }
            else if(s.equals("Rght") && velocity == 0) {
                d = (d + 1) % 4;
            }
            else if(s.equals("Left") && velocity == 0) {
                d = (d + 3) % 4;
            }

            x += dx[d] * velocity;
            y += dy[d] * velocity;
        }

        out.println((x * 100) + " " + (y * 100));
    }
}
