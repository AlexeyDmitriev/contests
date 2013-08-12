package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.numbers.Rational;

public class TaskD {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int min = in.nextInt();

        int[] t = new int[26];

        for (char c : in.nextString().toCharArray()) {
            t[c - 'A'] = 1;
        }

        int[][] a = new int[n][m];
        for(int i = 0; i < n; ++i){
            String s = in.nextString();
            for(int j = 0; j < m; ++j) {
                a[i][j] = t[s.charAt(j) - 'A'];
            }
        }

        int[][] prefixSums = new int[n + 1][m + 1];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < m; ++j) {
                prefixSums[i + 1][j + 1] = prefixSums[i + 1][j] + prefixSums[i][j + 1] + a[i][j] - prefixSums[i][j];
            }

        Rational bestFraction = new Rational(0, 1);
        int maxArea = n * m;


        for(int iL = 0; iL < n; ++iL) {
            for(int iR = iL + min; iR <= n; ++iR) {
                for(int jL = 0; jL < m; ++jL) {
                    for(int jR = jL + min; jR <= m; ++jR) {
                        int sum = prefixSums[iR][jR] - prefixSums[iL][jR] - prefixSums[iR][jL] + prefixSums[iL][jL];
                        int all = (iR - iL) * (jR - jL);
                        Rational fraction = new Rational(sum, all);
                        int cmp = fraction.compareTo(bestFraction);
                        if(cmp > 0 || cmp == 0 && maxArea < all) {
                            bestFraction = fraction;
                            maxArea = all;
                        }
                    }
                }
            }
        }


        //out.println(bestFraction);

        out.println(bestFraction.multiply(new Rational(maxArea)).numerator + "/" + maxArea);
    }
}
