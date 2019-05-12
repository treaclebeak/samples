/**
 * https://www.hackerrank.com/challenges/circular-array-rotation/problem
 */
class CircularArrayRotation {

    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        for (int j = 0; j < k; j++) {
            int first = a[a.length-1];
            int removed = a[0];
            for (int i=1; i < a.length; i++) {
                int temp = a[i];
                a[i] = removed;
                removed = temp;
            }
            a[0] = first;
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = a[queries[i]];
        }
        return result;
    }

}
