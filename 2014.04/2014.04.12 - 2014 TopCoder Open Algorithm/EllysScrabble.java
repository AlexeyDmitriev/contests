package main;

import name.admitriev.spsl.collections.Pair;

import java.util.NavigableSet;
import java.util.TreeSet;

public class EllysScrabble {
    public String getMin(String letters, int maxDistance) {
        NavigableSet<Pair<Character, Integer>> pairs = new TreeSet<Pair<Character, Integer>>();
        for(int i = 0; i < letters.length() && i < maxDistance; ++i) {
            pairs.add(new Pair<Character, Integer>(letters.charAt(i), i));
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < letters.length(); ++i) {
            if(i + maxDistance < letters.length())
                pairs.add(new Pair<Character, Integer>(letters.charAt(i + maxDistance), i + maxDistance));
            //System.out.println(pairs);
            boolean need = true;
            for (Pair<Character, Integer> pair : pairs) {
                if(pair.second == i - maxDistance) {
                    sb.append(pair.first);
                    pairs.remove(pair);
                    need = false;
                    break;
                }
            }
            if(need) {
                sb.append(pairs.first().first);
                pairs.remove(pairs.first());
            }
        }


        return sb.toString();
    }
}