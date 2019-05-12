import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class CircularArrayRotationTest {

    @Test
    public void testRotation() {
        int[] result = CircularArrayRotation.circularArrayRotation(new int[] {1,2,3},2, new int[] {0,1,2});
        assertThat(result[0],is(equalTo(2)));
        assertThat(result[1],is(equalTo(3)));
        assertThat(result[2],is(equalTo(1)));
    }
}
