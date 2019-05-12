public class BinarySearchTree {

    class Node {
        int val;
        Node left;
        Node right;
        boolean locked;

        public Node(int val,
                    BinarySearchTree.Node left,
                    BinarySearchTree.Node right,
                    boolean locked) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.locked = locked;
        }
    }

    Node root;

    public void add(int i, boolean locked) {
        root = addNode(root, i, locked);
    }

    Node addNode(Node n, int i, boolean locked) {
        if (n == null) {
            return new Node(i, null, null, locked);
        }
        if (i < n.val) {
            n.left = addNode(n.left, i, locked);
        }
        if (i > n.val) {
            n.right = addNode(n.right, i, locked);
        }
        return n;
    }

    void dft() {
        dft(root, "|");
    }

    void dft(Node n, String dir) {
        if (n == null) {
            return;
        }
        System.out.println(dir + n.val);
        dft(n.left, n.val + "/");
        dft(n.right, n.val + "\\");

    }


    int depth() {
        return depth(root);
    }

    private int depth(Node n) {
        if (n == null) {
            return 0;
        }
        int leftDepth = depth(n.left);
        int rightDepth = depth(n.right);
        return Math.max(leftDepth, rightDepth) + 1;

    }

    int largest() {
        return largest(root);
    }

    int[] largestK(int k) {
        int[] kList = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        largestK(root, kList);
        return kList;
    }

    void largestK(Node n, int[] kList) {
        if (n == null) {
            return;
        }
        largestK(n.right, kList);
        for (int i = 0; i < kList.length; i++) {
            if (n.val > kList[i]) {
                kList[i] = n.val;
                break;
            }
        }
    }

    int largest(Node n) {
        if (n == null) {
            return 0;
        }
        int val = largest(n.right);
        return val >= n.val ? val : n.val;
    }

    public void pivot() {
        pivot(root);
    }

    public void pivot(Node n) {
        if (n == null) {
            return;
        }
        pivot(n.left);
        pivot(n.right);
        Node left = n.left;
        Node right = n.right;
        n.right = left;
        n.left = right;

    }


    boolean lockNode(int target) {
        Node[] holder = new Node[1];
        boolean ancestorsLocked = checkAncestorLocksAndFindNode(target, root, holder);
        boolean childrenLocked = checkChildLocks(holder[0]);
        if (!ancestorsLocked && !childrenLocked) {
            holder[0].locked = true;
        }
        return holder[0].locked;
    }

    boolean checkAncestorLocksAndFindNode(int target, Node current, Node[] holder) {
        if (current.val == target) {
            holder[0] = current;
            return current.locked;
        }
        boolean locked;
        if (target <= current.val) {
            locked = checkAncestorLocksAndFindNode(target, current.left, holder);
        } else {
            locked = checkAncestorLocksAndFindNode(target, current.right, holder);
        }
        return locked && current.locked;
    }

    boolean checkChildLocks(Node n) {
        if (n == null) {
            return true;
        }
        boolean lockedLeft = n.locked && checkChildLocks(n.left);
        boolean lockedRight = n.locked && checkChildLocks(n.right);
        return lockedLeft && lockedRight;
    }


}
