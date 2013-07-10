package main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Egalitarianism {
    public int maxDifference(String[] isFriend, int d) {
	   int n = isFriend.length;

	    int maxAnswer = 0;

	    for(int start = 0; start < n; ++start) {
		    Queue<Integer> queue = new LinkedList<Integer>();
		    int[] distance = new int[n];
		    Arrays.fill(distance, Integer.MAX_VALUE);
		    distance[start] = 0;
		    queue.add(start);
		    while (!queue.isEmpty()) {
			    int current = queue.poll();
			    for(int to = 0; to < n; ++to) {
				    if(isFriend[current].charAt(to) != 'Y')
					    continue;
				    if (distance[to] != Integer.MAX_VALUE)
					    continue;

				    distance[to] = distance[current] + 1;
				    queue.add(to);
			    }
		    }

		    int maxDistance = 0;

		    for(int i = 0; i < n; ++i) {
			    maxDistance = Math.max(maxDistance, distance[i]);
		    }
		    if(maxDistance == Integer.MAX_VALUE)
			    return -1;

		    maxAnswer = Math.max(maxDistance, maxAnswer);

	    }
	    return d * maxAnswer;
	    //NYNN,YNNN,NNNY,NNYN
	    //NYNY,YNYN,NYNY,YNYN cycle
	    //NYNY,YNNN,NNNY,YNYN 2143

	    //A0->A1:0001 A1->A2:0001, A2->A3:0001 A3->A4:0001, A5->A6:0001 A6->A7:0001, A4->A5:0001 A7->A8:0001, A8->A9:0001, B0->B1:0001 B1->B2:0001, B2->B3:0001 B3->B4:0001, B5->B6:0001 B6->B7:0001, B4->B5:0001 B7->B8:0001, B8->B9:0001, C0->C1:0001 C1->C2:0001, C2->C3:0001 C3->C4:0001, C5->C6:0001 C6->C7:0001, C4->C5:0001 C7->C8:0001, C8->C9:0001, D0->D1:0001 D1->D2:0001, D2->D3:0001 D3->D4:0001, D5->D6:0001 D6->D7:0001, D4->D5:0001 D7->D8:0001, D8->D9:0001, E0->E1:0001 E1->E2:0001, E2->E3:0001 E3->E4:0001, E5->E6:0001 E6->E7:0001, E4->E5:0001 E7->E8:0001, E8->E9:0001, F0->F1:0001 F1->F2:0001, F2->F3:0001 F3->F4:0001, F5->F6:0001 F6->F7:0001, F4->F5:0001 F7->F8:0001, F8->F9:0001, G0->G1:0001 G1->G2:0001, G2->G3:0001 G3->G4:0001, G5->G6:0001 G6->G7:0001, G4->G5:0001 G7->G8:0001, G8->G9:0001, H0->H1:0001 H1->H2:0001, H2->H3:0001 H3->H4:0001, H5->H6:0001 H6->H7:0001, H4->H5:0001 H7->H8:0001, H8->H9:0001, I0->I1:0001 I1->I2:0001, I2->I3:0001 I3->I4:0001, I5->I6:0001 I6->I7:0001, I4->I5:0001 I7->I8:0001, I8->I9:0001
    }
}
