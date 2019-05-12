import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class PermutationTreeTest {

    @Test
    public void testNumWays() {
        PermutationTree pt = new PermutationTree();
        int[] stepCombinations = new int[]{1, 2, 3};
        int totalForBranch = 0;
        for (Integer i : stepCombinations) {
            totalForBranch += pt.branchTotal(0, i, stepCombinations, 6);
        }
        assertThat(totalForBranch, is(equalTo(24)));

    }
}
