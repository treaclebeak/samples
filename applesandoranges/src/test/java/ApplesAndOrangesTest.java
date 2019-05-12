import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ApplesAndOrangesTest {

    @Test
    public void testApplesAndOranges() {
        int[] result = ApplesAndOranges.countApplesAndOranges(7, 11, 5, 15, new int[]{-2, 2, 1}, new int[]{5, -6});
        assertThat(result[0], is(equalTo(1)));
        assertThat(result[1], is(equalTo(1)));
    }
}
