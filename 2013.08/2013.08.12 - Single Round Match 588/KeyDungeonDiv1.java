package main;

import java.util.HashMap;
import java.util.Map;

public class KeyDungeonDiv1 {
    int[] doorR;
    int[] doorG;
    int[] roomR;
    int[] roomG;
    int[] roomW;
    int n;
    public int maxKeys(int[] doorR, int[] doorG, int[] roomR, int[] roomG, int[] roomW, int[] keys) {
        this.doorR = doorR; 
        this.doorG = doorG; 
        this.roomR = roomR; 
        this.roomW = roomW; 
        this.roomG = roomG;
        n = doorR.length;
        return solve(0, keys[0], keys[1], keys[2], 0);
    }

    Map<Long, Integer> memo = new HashMap<Long, Integer>();

    private int solve(int mask, int r, int g, int w, int d) {
        long key = mask * (1L << 40) + r * 200 + g;
        if(d > 15) {
            throw new AssertionError();
        }
        if(memo.containsKey(key))
            return memo.get(key);

        int result = r + g + w;

        for(int i = 0; i < n; ++i) {
            if((mask & (1 << i)) == 0) {

                int spentR = Math.min(r, doorR[i]);
                int spentG = Math.min(g, doorG[i]);
                int spentW = doorR[i] + doorG [i] - spentR - spentG;
                if(w >= spentW) {
                    result = Math.max(result, solve(mask + (1 << i), r - spentR + roomR[i], g - spentG + roomG[i], w - spentW + roomW[i], d + 1));
                }
            }
        }

        memo.put(key, result);
        return result;
    }
}
