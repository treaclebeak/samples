import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BinarySearchTreeTest {

    BinarySearchTree b;

    @Before
    public void buildTree() {
        b = new BinarySearchTree();
        b.add(6, true);
        b.add(2, true);
        b.add(7, true);
        b.add(1, true);
        b.add(12, true);
        b.add(3, true);
        b.add(4, true);
        b.add(5, true);
        b.add(15, false);
    }

    @Test
    public void testPivot() {
        b.pivot();
    }

    @Test
    public void testDFT() {
        b.dft();
    }

    @Test
    public void testLocking() {
        BinarySearchTree.Node[] holder = new BinarySearchTree.Node[1];
        boolean ancestorsLocked = b.checkAncestorLocksAndFindNode(4,b.root,holder);
        boolean childrenLocked = b.checkChildLocks(holder[0]);
        assertThat(ancestorsLocked,equalTo(true));
        assertThat(childrenLocked,equalTo(true));

    }

}
