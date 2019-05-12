/**
 * https://www.hackerrank.com/challenges/apple-and-orange/problem
 */
class ApplesAndOranges {

    static int[] countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int[] result = new int[2];
        int appleCount = 0;
        int orangeCount = 0;
        for (int apple : apples) {
            if (a + apple >= s && a + apple <= t) {
                ++appleCount;
            }
        }
        result[0] = appleCount;
        for (int orange : oranges) {
            if (b + orange >= s)
                if (b + orange <= t) {
                    ++orangeCount;
                }
        }
        result[1] = orangeCount;
        return result;
    }
}
