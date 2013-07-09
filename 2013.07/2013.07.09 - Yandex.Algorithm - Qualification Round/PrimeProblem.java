package main;



import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.numbers.IntegerUtils;

public class PrimeProblem {
    public void solve(int testNumber, Reader in, OutputWriter out) {

	    //(k - 1)(k + 1) == p1*p2
	    int n = in.nextInt();
	    // k - 1 = 1;
	    // k + 1 = 3;
	    //out.println(4);
	    for(int k = 2; k <= n; ++k) {
		    if(IntegerUtils.isPrime(k - 1) && IntegerUtils.isPrime(k + 1))
			    out.println(k);
	    }

    }
}
