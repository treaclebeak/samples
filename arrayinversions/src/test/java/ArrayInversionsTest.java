import org.junit.Test;

public class ArrayInversionsTest {

    @Test
    public void testEqualise() {
        ArrayInversions ai = new ArrayInversions();
        int[] arr = new int[] {24,29,70,43,12,27,29,24,41,12,41,43,24,70,24,100,41,
                        43,43,100,29,70,100,43,41,27,70,70,59,41,24,24,
                        29,43,24,27,70,24,27,70,24,70,27,24,43,27,100,
                        41,12,70,43,70,62,12,59,29,62,41,100,43,43,59,
                        59,70,12,27,43,43,27,27,27,24,43,43,62,43,70,29};
        ai.equalise(arr);
    }

    @Test
    public void testRepeastedString() {
        ArrayInversions ai = new ArrayInversions();
        ai.repeatedString("aba", 10);
    }
}
