package main;

import java.util.ArrayList;

public class ORSolitaire {
    public int getMinimum(int[] numbers, int goal) {
        ArrayList<Integer> usefulNumbers = new ArrayList<Integer>();
        for (int number : numbers) {
            if((number | goal) == goal) {
                usefulNumbers.add(number);
            }
        }
        int[] bits = new int[40];
        for (int number : usefulNumbers) {
            for(int i = 0; i <= 30; ++i) {
                if((number & (1 << i)) != 0)
                    bits[i]++;
            }
        }
        int minAnswer = Integer.MAX_VALUE;
        for(int i = 0; i <= 30; ++i) {
            if((goal & (1 << i)) != 0) {
                minAnswer = Math.min(minAnswer, bits[i]);
            }
        }
        return minAnswer;
    }
}