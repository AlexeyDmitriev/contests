package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int wallets = in.nextInt();
        int[] sizes = in.nextIntArray(wallets);
        for(int i = 0; i < wallets - 1; ++i) {
            for(int j = 0; j < sizes[i]; ++j) {
                out.print("PRL");
            }
            out.print("R");
        }
        for(int i = 0; i < sizes[wallets - 1]; ++i) {
            out.print("PLR");
        }
    }
}
