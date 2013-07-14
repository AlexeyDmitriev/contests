package main;



import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.util.ArrayList;

public class TaskC {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();

        ArrayList<Integer> primesPowers = new ArrayList<Integer>();

        int sumPowers = 0;

        for(int i = 2; i * i <= n; ++i) {
            if(n % i == 0){
                int power = 0;
                while (n % i == 0) {
                    ++power;
                    n /= i;
                }

                primesPowers.add(power);
                sumPowers += power;
            }
        }

        if(n != 1) {
            primesPowers.add(1);
            sumPowers++;
        }


        if(sumPowers < k) {
            out.println("NO");
            return;
        }

        if(primesPowers.size() > 1) {
            out.println("YES");
            return;
        }
        if((k % 2) != (sumPowers % 2)) {
            out.println("NO");
        }
        else
            out.println("YES");
    }
}
