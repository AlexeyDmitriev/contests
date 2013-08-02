package main;

import java.util.HashSet;

public class JumpFurther {
    public int furthest(int N, int badStep) {
        HashSet<Integer> steps = new HashSet<Integer>();
        int sum = 0;
        for(int i = 1; i <= N; ++i) {
            sum += i;
            steps.add(sum);
        }

        if(steps.contains(badStep))
            --sum;
        return sum;
    }
}
