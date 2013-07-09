package main;



import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.math.BigInteger;

public class TableProblem {
    public void solve(int testNumber, Reader in, OutputWriter out) {
	    long n = in.nextLong();
	    BigInteger N = BigInteger.valueOf(n);
	    out.print(N.multiply(BigInteger.valueOf(n + 1)).shiftRight(1));
	    out.print(" ");


	    out.println(solve(n));

    }

	private long stupidSolve(long n) {
		long xor = 0;
		for(int i = 1; i <= n; ++i) {
			xor ^= i;
		}
		int answer = 0;
		for(int i = 1; i <= n; ++i) {
			if((xor ^ i) < i) {
				answer++;
			}
		}

		return answer;

	}

	private long solve(long n) {
		++n;

		long number = 0;

		for(int i = 0; i < 32; ++i) {
			long t = n % (1L << (i + 1));
			long groups = n / (1L << (i + 1));
			long cur = (groups % 2) * (i == 0 ? 1 : 0);
			cur ^= (t <= (1L << i)) ? 0 : ((t - (1L << i)) % 2);

			if(cur == 1) {
				number = (groups * (1L << i)) + ((t <= (1L << i)) ? 0 : ((t - (1L << i))));
			}

		}

		return number;
	}


}
