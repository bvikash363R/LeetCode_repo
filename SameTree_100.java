// https://leetcode.com/problems/same-tree/description

public class SameTree_100 {
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

    // public static ArrayList<Integer> inOrder(Node root, ArrayList<Integer> list)
    // {
    // if (root == null) {
    // return list;
    // }
    // inOrder(root.left, list);
    // list.add(root.data);
    // inOrder(root.right, list);

    // return list;
    // }

    // public static ArrayList<Integer> inOrder(Node root) {
    // return inOrder(root, new ArrayList<>());
    // }

    // Approaches --> 1
    public static boolean isSameTree(Node root1, Node root2) {
        {
            if (root1 == null && root2 == null)
                return true;
            if (root1 == null || root2 == null)
                return false;
            if (root1.data != root2.data)
                return false;

            return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);

        }

    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(4);
        root.right.right.right = new Node(5);
        root.right.right.right.right = new Node(6);

        Node root1 = new Node(3);
        root1.right = new Node(2);
        root1.right.right = new Node(4);
        root1.right.right.right = new Node(5);
        root1.right.right.right.right = new Node(6);

        System.out.println(isSameTree(root, root1));

    }
}
