package main;



import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.math.BigInteger;
import java.util.Arrays;

public class Lab {
    public void solve(int testNumber, Reader in, OutputWriter out) {
	    int n = in.nextInt();
	    long x = in.nextInt();
	    long k = in.nextInt();
	    long[] counts = in.nextLongArray(n);
	    long sum = 0;
	    for(int i = 0; i < n; ++i) {
		    sum += counts[i];
	    }

	    if(x == 0) {
		    out.println((sum + k - 1) / k );
		    return;
	    }

	    long[] reminders = new long[n];
	    for(int i = 0; i < n; ++i) {
		    reminders[i] = counts[i] % x;
	    }
	    Arrays.sort(reminders);

	    long l = 0, r = sum;

	    while (r - l > 1) {
		    long m = (l + r) / 2;
		    long genaSolve = 0;
		    long daysLeft = m;
		    for(int i = 0; i < n; ++i) {
			    long days = Math.min(counts[i] / x, daysLeft);
			    daysLeft -= days;
			    genaSolve += days * x;
		    }
		    if(daysLeft > 0) {
			    for(int i = 1; i <= daysLeft && i <= n; ++i) {
				    genaSolve += reminders[n - i];
			    }
		    }

		    if(BigInteger.valueOf(sum - genaSolve).compareTo(BigInteger.valueOf(m).multiply(BigInteger.valueOf(k))) <= 0){
			    r = m;
		    }
			else {
			    l = m;
		    }
	    }

	    out.println(r);



    }
}
