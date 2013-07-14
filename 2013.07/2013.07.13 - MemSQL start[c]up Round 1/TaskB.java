package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.math.BigInteger;
import java.util.TreeSet;

public class TaskB {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        long n = in.nextLong();
        TreeSet<BigInteger> possibilities = new TreeSet<BigInteger>();


        for(int playoffRounds = 0; playoffRounds < 70; ++playoffRounds) {
            BigInteger B = BigInteger.ONE.shiftLeft(playoffRounds + 1).subtract(BigInteger.valueOf(3));
            BigInteger C = BigInteger.valueOf(-2 * n);

            BigInteger D = B.multiply(B).subtract(C.multiply(BigInteger.valueOf(4)));


            BigInteger sqrtD = sqrt(D);
            if(sqrtD == null)
                continue;

            BigInteger numerator = B.negate().add(sqrtD);
            if(numerator.testBit(0)){
                continue;
            }

            BigInteger answer = numerator.shiftRight(1);

            if(answer.testBit(0))
                possibilities.add(answer.shiftLeft(playoffRounds));


        }

        if(possibilities.isEmpty()) {
            out.println(-1);
        }
        else {
            for (BigInteger possibility : possibilities) {
                out.println(possibility);
            }
        }
    }

    private BigInteger sqrt(BigInteger d) {
        BigInteger l = BigInteger.ZERO, r = d.add(BigInteger.ONE);

        while (!l.add(BigInteger.ONE).equals(r)) {
            BigInteger m = l.add(r).shiftRight(1);
            if(m.multiply(m).compareTo(d) <= 0){
                l = m;
            }
            else
                r = m;
        }

        return l.multiply(l).equals(d) ? l : null;


    }
}
