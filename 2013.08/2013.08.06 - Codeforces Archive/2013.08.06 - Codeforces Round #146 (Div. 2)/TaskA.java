package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

import java.util.HashSet;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        HashSet<Character> characters = new HashSet<Character>();
        for (char c : in.nextString().toCharArray()) {
            characters.add(c);
        }
        out.println(characters.size() % 2 == 0 ? "CHAT WITH HER!" : "IGNORE HIM!");
    }
}
