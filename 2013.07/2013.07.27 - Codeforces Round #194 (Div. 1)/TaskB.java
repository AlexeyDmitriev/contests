package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        boolean[] badX = new boolean[n];
        boolean[] badY = new boolean[n];
        for(int i = 0; i < m; ++i) {
            badX[in.nextInt() - 1] = true;
            badY[in.nextInt() - 1] = true;
        }

        long answer = 0;

        for(int i = 1; i < n / 2; ++i) {
            int allowedX = (badX[i] ? 0 : 1) + (badX[n - 1 - i] ? 0 : 1);
            int allowedY = (badY[i] ? 0 : 1) + (badY[n - 1 - i] ? 0 : 1);
            answer += solve(allowedX, allowedY);
        }

        if(n % 2 == 1) {
            if(!badX[n / 2] || !badY[n / 2])
                ++answer;
        }

        out.println(answer);
    }

    private long solve(int allowedX, int allowedY) {
        return allowedX + allowedY;
    }
}
