package main;

import name.admitriev.spsl.io.OutputWriter;
import name.admitriev.spsl.io.Reader;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class BasketballGame {
    private static final Comparator<Player> NATURAL_ORDER = new Comparator<Player>() {
        @Override
        public int compare(Player o1, Player o2) {
            if(o1.percentage > o2.percentage)
                return -1;
            if(o1.percentage < o2.percentage)
                return 1;
            return -Integer.compare(o1.height, o2.height);
        }
    };
    class Player{
        String name;
        int percentage;
        int height;

        int timePlayed = 0;

        Player(String name, int percentage, int height) {
            this.name = name;
            this.percentage = percentage;
            this.height = height;
        }

        @Override
        public boolean equals(Object o) {
            throw new NotImplementedException();
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + percentage;
            result = 31 * result + height;
            result = 31 * result + timePlayed;
            return result;
        }
    }
    public void solve(int testNumber, Reader in, OutputWriter out) {


        out.print("Case #" + testNumber + ": ");
        int n = in.nextInt();
        int m = in.nextInt();
        int p = in.nextInt();
        Player[] allPlayers = new Player[n];
        for(int i = 0; i < n; ++i) {
            allPlayers[i] = new Player(in.nextString(), in.nextInt(), in.nextInt());
        }

        TreeSet<String> answers = new TreeSet<String>();

        Arrays.sort(allPlayers, NATURAL_ORDER);
        for(int team = 0; team < 2; ++team) {

            TreeSet<Player> inPlay = new TreeSet<Player>(new Comparator<Player>() {
                @Override
                public int compare(Player o1, Player o2) {
                    if(o1.timePlayed > o2.timePlayed)
                        return -1;
                    if(o1.timePlayed < o2.timePlayed)
                        return 1;
                    return -NATURAL_ORDER.compare(o1, o2);
                }
            });
            TreeSet<Player> queue = new TreeSet<Player>(new Comparator<Player>() {
                @Override
                public int compare(Player o1, Player o2) {
                    if(o1.timePlayed < o2.timePlayed)
                        return -1;
                    if(o1.timePlayed > o2.timePlayed)
                        return 1;
                    return NATURAL_ORDER.compare(o1, o2);
                }
            });

            for(int i = team; i < n; i += 2) {
                if(inPlay.size() == p)
                    queue.add(allPlayers[i]);
                else
                    inPlay.add(allPlayers[i]);
            }

            if(!queue.isEmpty()) {
                for(int i = 0; i < m; ++i) {

                    for (Player player : inPlay) {
                        ++player.timePlayed;
                    }

                    Player toSeat = inPlay.first();
                    inPlay.remove(toSeat);
                    inPlay.add(queue.first());
                    queue.remove(queue.first());
                    queue.add(toSeat);

                }
            }

            for (Player player : inPlay) {
               // out.println(player.name);
                answers.add(player.name);
            }

        }
        for (String answer : answers) {
            out.print(answer + " ");
        }

        out.println();
    }
}
