package main;



import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class Basketball {
    public void solve(int testNumber, Reader in, OutputWriter out) {
	    int n = in.nextInt();
	    int l = in.nextInt();
	    int[] score = new int[3];
	    for(int i = 0; i < n; ++i){
		    int team = in.nextInt();
		    int d = in.nextInt();
		    int points = d <= l ? 2 : 3;
		    if(d == -1)
			    points = 1;
		    score[team] += points;
	    }
	    out.println(score[1] + ":" + score[2]);
    }
}
