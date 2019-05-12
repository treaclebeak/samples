import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
public class QueueChaos {

    private Map<Integer,Integer> positions = new HashMap<>();

    void minimumBribes(int[] q) {
        int swap = 0;
        boolean chaotic = false;
        for (int i = 0; i < q.length; i++) {
            if (q[i] > i+3) {
                chaotic = true;
            }
            positions.put(q[i],i);
        }
        if (!chaotic) {
            for (int i = 0; i < q.length; i++) {
                int pos = locate(i+1,q);
                if (pos != i) {
                    swap = swap +(pos-i);
                    shuffle(q,i, pos);
                }
            }
        }
        if (chaotic) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(swap);
        }

    }

    void shuffle(int[] q, int shiftTo, int shiftFrom) {
        for (int i = shiftFrom; i > shiftTo; i--) {
            int temp = q[i-1];
            q[i-1] = q[i];
            positions.put(q[i],i-1);
            q[i] = temp;
            positions.put(temp,i);
        }
    }

    int locate(int n, int[] q) {
//        for (int i = 0; i < q.length; i++) {
//            if (q[i] == n) {
//                return i;
//            }
//        }
//        return -1;
        // submission timed out with array loop so replaced it with lookup
        int r = positions.get(n);
        return r;
    }


}
