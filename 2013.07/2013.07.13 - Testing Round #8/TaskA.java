package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.numbers.Rational;

import java.math.BigInteger;

public class TaskA {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int[] a = in.nextIntArray(4);
        int d = a[1] - a[0];
        if(a[2] - a[1] == d && a[3] - a[2] == d) {
            out.println(a[3] + d);
            return;
        }
        if(a[1] == 0 && a[2] == 0 && a[3] == 0){
            out.println(0);
            return;
        }
        if(a[0] == 0) {
            out.println(42);
            return;
        }

        Rational fraction1 = new Rational(a[1], a[0]);
        Rational fraction2 = new Rational(a[2], a[1]);
        Rational fraction3 = new Rational(a[3], a[2]);
        if(fraction1.equals(fraction2) && fraction1.equals(fraction3)) {
            Rational next = new Rational(a[3]).multiply(fraction1);
            if(next.denominator.equals(BigInteger.ONE)){
                out.println(next.numerator);
                return;
            }
        }

        out.println(42);


    }
}
