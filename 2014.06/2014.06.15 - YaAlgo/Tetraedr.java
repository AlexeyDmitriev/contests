package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

public class Tetraedr {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int[][] x = new int[4][];
        for(int i = 0; i < 4; ++i)
            x[i] = in.nextIntArray(3);

        for(int i = 0; i < 4; ++i) {
            for(int j = 0; j < 3; ++j) {
                x[i][j] *= 4;
            }
        }

        int[] avg = new int[3];
        for(int j = 0; j < 3; ++j){
            for(int i = 0; i < 4; ++i) {
                avg[j] += x[i][j];
            }
            avg[j] /= 4;
        }

        //out.println(S(avg, x[0], x[1]) + " " + S(avg, x[1], x[2]) + "  " + S(avg, x[2], x[0]) + " " + S(x[0], x[1], x[2]));

        if(S(avg, x[0], x[1]) + S(avg, x[1], x[2]) + S(avg, x[2], x[0]) != S(x[0], x[1], x[2])) {
            out.println("Falling");
            return;
        }

        if(on(avg, x[0], x[1]) || on(avg, x[1], x[2]) ||  on(avg, x[2], x[0])) {
            out.println("Unstable");
            return;
        }

        out.print("Standing");

    }

    private boolean on(int[] avg, int[] a, int[] b) {
        return S(avg, a, b) == 0;
    }

    private int S(int[] avg, int[] a, int[] b) {
        return Math.abs((a[0] - avg[0])* (b[1] - avg[1]) - (b[0] - avg[0]) * (a[1] - avg[1]));
    }
}
