package main;

import name.admitriev.spsl.collections.ListUtils;
import name.admitriev.spsl.collections.array.ObjectArray;
import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;
import name.admitriev.spsl.misc.Function;

import java.util.Collections;
import java.util.List;

public class Task22 {
    public void solve(int testNumber, Reader in, OutputWriter out) {
        String[] input = in.nextString().split(",");
        List<String> list = ListUtils.apply(new ObjectArray<String>(input), new Function<String, String>() {
            @Override
            public String apply(String argument) {
                return argument.substring(1, argument.length() - 1);
            }
        });

        Collections.sort(list);

        long sum = 0;
        for(int i = 0; i < list.size(); ++i) {
            long curSum = 0;
            for (char c : list.get(i).toCharArray()) {
                curSum += c - 'A' + 1;
            }
            sum += curSum * (i + 1);
        }
        out.println(sum);
    }
}
