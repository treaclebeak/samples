import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


/**
 * https://www.hackerrank.com/challenges/compare-the-triplets/problem?isFullScreen=false
 */
public class CompareTriplets {

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        Integer[] result = IntStream.range(0, a.size())
                .mapToObj(i -> produceIntArray(a, b, i))
                .reduce(CompareTriplets::accumulate).get();
        return Arrays.asList(result);

    }

    private static Integer[] accumulate(Integer[] a1, Integer[] b1) {
        return new Integer[]{a1[0] + b1[0], a1[1] + b1[1]};
    }

    private static Integer[] produceIntArray(List<Integer> a, List<Integer> b, int i) {
        Integer[] results = new Integer[]{0, 0};
        int comparing = a.get(i).compareTo(b.get(i));
        switch (comparing) {
            case -1:
                results[1]++;
                break;
            case 1:
                results[0]++;
        }
        return results;
    }



    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int appleCount = 0;
        int orangeCount = 0;
        for (int apple : apples) {
            if (a + apple >= s && a + apple <= t) {
                ++appleCount;
            }
        }
        System.out.println(appleCount);
        for (int orange : oranges) {
            if (b + orange >= s)
                if (b + orange <= t) {
                    ++orangeCount;
                }
        }
        System.out.println(orangeCount);

    }

}
