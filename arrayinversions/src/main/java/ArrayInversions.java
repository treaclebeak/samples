import org.junit.Test;

import java.util.Arrays;

public class ArrayInversions {

    long repeatedString(String s, long n) {

        long acount = s.chars().mapToObj(c -> (char) c).filter(c -> 'a' == c).count();
        long multiple = s.length() / n;
        acount *= multiple;
        long substringLength = n % s.length();
        for (int i = 0; i < substringLength; i++) {
            if (s.charAt(i) == 'a') {
                ++acount;
            }
        }
        return acount;

    }


    int equalise(int[] arr) {
        Arrays.sort(arr);
        int maxLength = 0;
        int currentLength = 1;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1] == arr[i]) {
                ++currentLength;
            } else {
                if (currentLength >= maxLength) {
                    maxLength = currentLength;
                }
                currentLength = 1;
            }
        }
        if (currentLength >= maxLength) {
            maxLength = currentLength;
        }
        int remaining = arr.length - maxLength;
        return remaining;
    }




}
