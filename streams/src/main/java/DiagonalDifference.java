import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


/**
 * https://www.hackerrank.com/challenges/diagonal-difference/problem
 */
public class DiagonalDifference {


    @Test
    public void difference() {
        /**
         * 1 2 3
         * 4 5 6
         * 9 8 9
         */


        /**
         * 11 2 4
         * 4 5 6
         * 10 8 -12
         */

        /**
         * -1, 1, -7, -8
         * -10, -8, -5, -2
         * 0, 9, 7, -1
         * 4, 4, -2, 1
         */

        int[][] array = new int[][]{{-1, 1, -7, -8}, {-10, -8, -5, -2}, {0, 9, 7, -1}, {4, 4, -2, 1}};

        int r1 = IntStream.range(0, array.length).reduce(0, (f, s) -> f + array[s][s]);
        int r2 = IntStream.range(0, array.length).reduce(0, (f, s) -> f + array[s][(array.length - 1) - s]);
        assertThat(1, equalTo(Math.abs(r1 - r2)));

    }


}
