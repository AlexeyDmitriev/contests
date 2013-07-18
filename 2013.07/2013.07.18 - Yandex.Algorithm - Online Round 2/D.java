package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.ArrayList;

public class D {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        long a = in.nextInt();
        long b = in.nextInt();
        long c = in.nextInt();
        ArrayList<Character> operations = new ArrayList<Character>();
        if(a + b == c) {
            operations.add('+');
        }
        if(a - b == c) {
            operations.add('-');
        }
        if(a * b == c) {
            operations.add('*');
        }
        if(b != 0 && a == b * c) {
            operations.add('/');
        }

        if(operations.size() == 1)
            out.println(operations.get(0));
        else
            out.println("Invalid");


    }
}
