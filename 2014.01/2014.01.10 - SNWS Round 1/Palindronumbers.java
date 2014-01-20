package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.numbers.IntegerUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Palindronumbers {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        TreeSet<Integer> answers = new TreeSet<Integer>();
        List<Integer> divisors = IntegerUtils.getDivisors(n);
        for (int a : divisors) {
            int b = n / a - 1;
            if(b < 2)
                continue;
            if(palindrome(n, b)) {
                answers.add(b);
            }
        }



        for(int b = 2; b * 1L * b <= n; ++b) {
            if(palindrome(n, b))
                answers.add(b);
        }

        for (Integer answer : answers) {
            out.println(answer + " ");
        }
    }

    private boolean palindrome(int n, int b) {
        List<Integer> digits = new ArrayList<Integer>();
        while (n > 0) {
            digits.add(n % b);
            n /= b;
        }
        return isPalindrome(digits);
    }

    private boolean isPalindrome(List<Integer> digits) {
        for(int i = 0; i < digits.size(); ++i) {
            if(!digits.get(i).equals(digits.get(digits.size() - 1 - i)))
                return false;
        }
        return true;
    }
}
