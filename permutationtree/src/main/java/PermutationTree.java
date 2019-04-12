import org.junit.Test;

public class PermutationTree {

     private int branchTotal(int count, int step, int[] stepCombinations, int totalSteps) {
        count = count+step;
        if (count == totalSteps) return 1;
        if (count > totalSteps) return 0;
        int totalForBranch = 0;
        for (Integer i : stepCombinations) {
            totalForBranch += branchTotal(count,i,stepCombinations,totalSteps);
        }
        return totalForBranch;
    }

    private int twoStep(int count, int step) {
        count = count+step;
        if (count == 4) return 1;
        if (count > 4) return 0;
        return twoStep(count,1)+twoStep(count,2);
    }

    @Test
    public void testTwoStep() {


    }

    @Test
    public void testNumWays() {
        int[] stepCombinations = new int[] {1,2,3};
        int totalForBranch = 0;
        for (Integer i : stepCombinations) {
            totalForBranch += branchTotal(0,i,stepCombinations,6);
        }
        System.out.println(totalForBranch);

    }


}
