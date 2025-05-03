// https://leetcode.com/problems/minimum-depth-of-binary-tree/description
class MinimunDepth_111 {

    // Binary tree Node
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    // Inoder traversal
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Soulation of Minimun depth of Binary tree
    public static int minDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public static void main(String[] args) {
        // Create Binary tree
        Node root = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(4);
        root.right.right.right = new Node(5);
        root.right.right.right.right = new Node(6);

        inOrder(root); // Inoder print
        System.out.println();
        System.out.println(minDepth(root)); // Minimun depth methode call

    }
}