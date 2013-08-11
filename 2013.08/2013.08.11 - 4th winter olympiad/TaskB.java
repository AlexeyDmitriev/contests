package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;

import java.math.BigInteger;
import java.util.LinkedList;

public class TaskB {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        int type = in.nextInt();
        if(type == 7) {
            int n = in.nextInt();
            int[] a = new int[1000];

            for(int i = 0; i < n; ++i) {
                a[i] = in.nextInt() % 10;
            }

            int[] b = in.nextIntArray(n);
            int m = in.nextInt() - 1;

            for(int i = n; i<= m; ++i) {
                for(int j = 0; j < n; ++j) {
                    a[i] += b[j] * a[i - n + j];
                }
                a[i] %= 10;
            }

            out.println(a[m]);

            return;
        }
        if(type == 8) {
            int n = in.nextInt();

            int[] a = in.nextIntArray(n);
            int[] b = in.nextIntArray(n);

            int m = in.nextInt();

            if(m <= n) {
                out.println(a[m - 1] % 10);
                return;
            }

            int sum = 0;
            LinkedList<Integer> queue = new LinkedList<Integer>();
            for (int i : a) {
                queue.add(i % 10);
                sum += i;
            }

            sum %= 10;

            for(int i = 0; i < m - n; ++i) {
                int next = (sum * b[0]) % 10;
                queue.add(next);
                sum += next;
                sum -= queue.poll();

                sum += 50;
                sum %= 10;
            }

            out.println(queue.get(queue.size() - 1));
            return;
        }
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        int[] a = in.nextIntArray(n);
        int[] b = in.nextIntArray(n);
        BigInteger m = new BigInteger(in.nextString());

        for(int i = 0; i < n; ++i) {
            a[i] %= 10;
        }
        if(BigInteger.valueOf(n).compareTo(m) >= 0) {
            out.println(a[m.intValue() - 1]);
            return;
        }

        for(int i = 0; i < n - 1; ++i) {
            matrix[i + 1][i] = 1;
        }
        for(int i = 0; i < n; ++i) {
            matrix[i][n - 1] = b[i] % 10;
        }


        //System.out.println(Arrays.deepToString(matrix));

        int[][] res = power(matrix, m.subtract(BigInteger.valueOf(n)));


        int ans = 0;
        for(int i = 0; i < n; ++i) {
            ans += a[i] * res[i][n - 1];
        }

        out.println(ans % 10);

    }

    private int[][] power(int[][] matrix, BigInteger p) {
        int n = matrix.length;
        int[][] result = new int[n][n];
        for(int i = 0; i < n; ++i) {
            result[i][i] = 1;
        }
        while (!p.equals(BigInteger.ZERO)) {
           // System.out.println(p + " " + Arrays.deepToString(result));
            if(p.testBit(0)) {
                result = multiply(result, matrix);
            }

            matrix = multiply(matrix, matrix);
            p = p.shiftRight(1);
        }
        return result;
    }

    private int[][] multiply(int[][] a, int[][] b) {
        int n = a.length;
        int[][] result = new int[n][n];

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                for(int k = 0; k < n; ++k) {
                    result[i][j] += a[i][k] * b[k][j];
                }
                result[i][j] %= 10;
            }
        }

        return result;

    }
}
