package main;

import name.admitriev.spsl.collections.ListUtils;
import name.admitriev.spsl.collections.array.ObjectArray;
import name.admitriev.spsl.misc.Function;
import name.admitriev.spsl.strings.StringUtils;

import java.util.Arrays;
import java.util.List;

public class History {
    public String verifyClaims(String[] dynasties, String[] battles, String[] queries) {
        int n = dynasties.length;
        StringBuilder answer = new StringBuilder();
        List<Integer>[] shifts = new List[n];
        for(int i = 0; i < n; ++i) {
            String[] strings = dynasties[i].split(" ");
            shifts[i] = ListUtils.apply(new ObjectArray<String>(strings), new Function<String, Integer>() {
                @Override
                public Integer apply(String argument) {
                    return Integer.parseInt(argument);
                }
            });
        }

        long[][] numbers = new long[n][n];
        for(int i = 0; i < n; ++i) {
            Arrays.fill(numbers[i], -1000000000);
            numbers[i][i] = 0;
        }

        battles = StringUtils.join(battles).split(" ");

        for (String battle : battles) {
            int firstNation = battle.charAt(0) - 'A';
            int firstID = battle.charAt(1) - '0';

            int secondNation = battle.charAt(3) - 'A';
            int secondID = battle.charAt(4) - '0';

            //fN + shifts[firstID] < sN + shifts[secondID + 1]

            numbers[secondNation][firstNation] = Math.max(numbers[secondNation][firstNation], shifts[firstNation].get(firstID) - shifts[secondNation].get(secondID + 1) + 1);
            numbers[firstNation][secondNation] = Math.max(numbers[firstNation][secondNation], -shifts[firstNation].get(firstID + 1) + shifts[secondNation].get(secondID) + 1);
        }


        //System.out.println(Arrays.deepToString(numbers));



        for (String battle : queries) {
            int firstNation = battle.charAt(0) - 'A';
            int firstID = battle.charAt(1) - '0';

            int secondNation = battle.charAt(3) - 'A';
            int secondID = battle.charAt(4) - '0';

            long[][] d = copy(numbers);
            //System.out.println(Arrays.deepToString(d));

            d[secondNation][firstNation] = Math.max(d[secondNation][firstNation], shifts[firstNation].get(firstID) - shifts[secondNation].get(secondID + 1) + 1);
            d[firstNation][secondNation] = Math.max(d[firstNation][secondNation], -shifts[firstNation].get(firstID + 1) + shifts[secondNation].get(secondID) + 1);


            if(hasPositiveCycle(d)) {
                answer.append('N');
            }
            else
                answer.append('Y');
        }

        return answer.toString();
    }

    long INF = 1000000000000000L;

    private boolean hasPositiveCycle(long[][] numbers) {
        int n = numbers.length;
        for(int k = 0; k < n; ++k) {
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < n; ++j) {
                    numbers[i][j] = Math.max(numbers[i][j], numbers[i][k] + numbers[k][j]);
                    if(numbers[i][j] > INF)
                        return true;
                }
            }
        }

        for(int i = 0; i < n; ++i) {
            if(numbers[i][i] > 0)
                return true;
        }

        return false;
    }

    private long[][] copy(long[][] numbers) {
        int n = numbers.length;
        long[][] d = new long[n][n];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                d[i][j] = numbers[i][j];
            }
        }
        return d;
    }
}
