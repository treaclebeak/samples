

public class PermutationTree {

    int branchTotal(int count, int step, int[] stepCombinations, int totalSteps) {
        count = count + step;
        if (count == totalSteps) return 1;
        if (count > totalSteps) return 0;
        int totalForBranch = 0;
        for (Integer i : stepCombinations) {
            totalForBranch += branchTotal(count, i, stepCombinations, totalSteps);
        }
        return totalForBranch;
    }

    int twoStep(int count, int step) {
        count = count + step;
        if (count == 4) return 1;
        if (count > 4) return 0;
        return twoStep(count, 1) + twoStep(count, 2);
    }


}
