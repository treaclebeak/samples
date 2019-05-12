import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CompareTripletsTest {

    @Test
    public void testTriplets() {
        List<Integer> a = Arrays.asList(1, 2, 2);
        List<Integer> b = Arrays.asList(2, 2, 1);
        List<Integer> result = CompareTriplets.compareTriplets(a, b);
        assertThat(result.get(0), equalTo(1));
        assertThat(result.get(1), equalTo(1));
    }

    @Test
    public void testApplesAndOranges() {
        CompareTriplets.countApplesAndOranges(7, 11, 5, 15, new int[]{-2, 2, 1}, new int[]{5, -6});
    }

}
