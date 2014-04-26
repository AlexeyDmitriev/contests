package main;

import java.util.PriorityQueue;

public class EllysSortingTrimmer {
    public String getMin(String S, int L) {
        PriorityQueue<Character> queue = new PriorityQueue<Character>();
        for(int i = 0; i < L; ++i) {
            queue.add((char)-S.charAt(S.length() - 1));
            S = S.substring(0, S.length() - 1);
        }
        while (!S.isEmpty()) {
            queue.poll();
            queue.add((char)-S.charAt(S.length() - 1));
            S = S.substring(0, S.length() - 1);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append((char)-queue.poll());
        }
        return sb.reverse().toString();
    }
}