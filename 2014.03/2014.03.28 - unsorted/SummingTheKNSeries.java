package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.numbers.IntegerUtils;

import java.util.ArrayList;

public class SummingTheKNSeries {
    int mod = 1000000007;
    public void solve(int testNumber, Reader in, OutputWriter out) {
        long n = in.nextLong();
        int k = in.nextInt();


        Polynomial answer = new Polynomial();
        ArrayList<Integer> forMult = new ArrayList<Integer>();
        forMult.add(0);
        forMult.add(1);
        Polynomial multiplier = new Polynomial(forMult);
        int currentAnswer = 0;
        for(int i = 1; i <= k + 1; ++i) {
            currentAnswer += IntegerUtils.power(i, k, mod);
            currentAnswer %= mod;
            int oldValue = answer.value(i);
            //out.println(i +  " " + answer.a + " " + currentAnswer + " " + oldValue + " ");
            int newCoefficient = (int) (((currentAnswer - oldValue + mod) % mod) * IntegerUtils.modInverse(multiplier.value(i), mod) % mod);
            //out.println(newCoefficient);
            answer = answer.add(multiplier.multiply(newCoefficient));
            multiplier = multiplier.multiplyXA(i);
        }
        //out.println(answer.a);
        out.println(answer.value((int) (n % mod)));
    }

    class Polynomial {
        ArrayList<Integer> a;
        Polynomial() {
            a = new ArrayList<Integer>();
        }
        Polynomial(ArrayList<Integer> a) {
            this.a = (ArrayList<Integer>) a.clone();
        }

        public Polynomial add(Polynomial b) {
            Polynomial res = new Polynomial();
            for(int i = 0; i <= degree() || i <= b.degree(); ++i) {
                res.a.add((get(i) + b.get(i)) % mod);
            }
            return res;
        }

        public Polynomial multiply(int x) {
            Polynomial res = new Polynomial(a);
            for(int i = 0; i <= res.degree(); ++i) {
                res.a.set(i, (int)(res.a.get(i) * 1L * x % mod));
            }
            return res;
        }
        public Polynomial multiplyXA(int A) {
            Polynomial res = new Polynomial(a);
            res.a.add(0, 0);
            res = res.add(this.multiply(A == 0 ? 0 : mod - A));
            return res;
        }

        int get(int i) {
            if(i < a.size())
                return a.get(i);
            return 0;
        }

        int degree() {
            return a.size() - 1;
        }

        int value(int x) {
            long power = 1;
            long res = 0;
            for(int i = 0; i <= degree(); ++i) {
                res += power * a.get(i);
                res %= mod;
                power *= x;
                power %= mod;
            }
            return (int)res;
        }


    }
}
