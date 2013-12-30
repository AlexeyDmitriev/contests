package main;

import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.io.OutputWriter;

public class TaskD {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int k = in.nextInt();
        int x = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        for(int start1withC = 0 ; start1withC <= 1; ++start1withC) {
            for(int start2withC = 0; start2withC <= 1; ++start2withC) {
                for(int end1withA = 0; end1withA <= 1; ++end1withA) {
                    for(int end2withA = 0; end2withA <= 1; ++end2withA) {
                        for(int timesACin1 = 0; timesACin1 * 2 + start1withC + end1withA <= n; ++timesACin1) {
                            for(int timesACin2 = 0; timesACin2 * 2 + start2withC + end2withA <= m; ++timesACin2) {
                                boolean s1c = start1withC == 1;
                                boolean s2c = start2withC == 1;
                                boolean e1a = end1withA == 1;
                                boolean e2a = end2withA == 1;
                                long cnt1 = timesACin1;
                                long cnt2 = timesACin2;

                                for(int t = 0; t + 2 < k; ++t) {
                                    long cnt3 = cnt1 + cnt2 + (e1a && s2c ? 1 : 0);
                                    if(cnt3 > x) {
                                        cnt2 = cnt3;
                                        break;
                                    }
                                    boolean e3a = e2a;
                                    boolean s3c = s1c;
                                    s1c = s2c;
                                    s2c = s3c;
                                    e1a = e2a;
                                    e2a = e3a;
                                    cnt1 = cnt2;
                                    cnt2 = cnt3;
                                }

                                if(cnt2 == x) {
                                    for(int z = 0; z < start1withC; ++z) {
                                        out.print("C");
                                    }
                                    for(int i = 0; i < timesACin1; ++i )
                                        out.print("AC");
                                    for(int i = 0; i < n - timesACin1 * 2 - start1withC - end1withA; ++i) {
                                        out.print("B");
                                    }
                                    for(int i = 0; i < end1withA; ++i) {
                                        out.print("A");
                                    }
                                    out.println();
                                    for(int z = 0; z < start2withC; ++z) {
                                        out.print("C");
                                    }
                                    for(int i = 0; i < timesACin2; ++i )
                                        out.print("AC");
                                    for(int i = 0; i < m - timesACin2 * 2 - start2withC - end2withA; ++i) {
                                        out.print("B");
                                    }
                                    for(int i = 0; i < end2withA; ++i) {
                                        out.print("A");
                                    }
                                    return;
                                }

                            }
                        }
                    }
                }
            }
        }
        out.println("Happy new year!");
    }
}
