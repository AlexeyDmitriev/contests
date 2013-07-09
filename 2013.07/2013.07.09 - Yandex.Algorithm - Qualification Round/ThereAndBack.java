package main;



import name.admitriev.spsl.collections.Counter;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.Map;

public class ThereAndBack {
    public void solve(int testNumber, Reader in, OutputWriter out) {
	    int n = in.nextInt();
	    if(!isPowerOf2(n)) {
		    out.println("NO");
		    return;
	    }

	    Counter<Long> counter = new Counter<Long>();
	    for(int i = 0; i < n; ++i) {
		    counter.add(in.nextLong());
	    }

	    while (n != 1) {
		    boolean hasBigPart = false;
		    for (Map.Entry<Long, Long> entry : counter.entrySet()) {
			    if(entry.getValue() >= n / 2) {
				    counter.add(entry.getKey(), - n / 2);
				    hasBigPart = true;
				    break;
			    }
		    }

		    if(!hasBigPart) {
			    out.println("NO");
			    return;
		    }
		    n /= 2;
	    }
	    out.println("YES");

    }

	private boolean isPowerOf2(int n) {
		while (n % 2 == 0)
			n /= 2;
		return n == 1;
	}
}
