import java.util.Stack;

import Node.TreeNode;

public class Symmetric_tree_101 {

    // Approaches --> 1 using two stacks
    public static boolean isSymmetricTree(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root.left);
        s2.push(root.right);

        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode node1 = s1.pop();
            TreeNode node2 = s2.pop();

            if (node1 == null && node2 == null) {
                continue;
            }

            if (node1 == null || node2 == null || node1.data != node2.data) {
                return false;
            }

            s1.push(node1.left);
            s2.push(node2.right);

            s1.push(node1.right);
            s2.push(node2.left);

        }
        return s1.isEmpty() && s1.isEmpty();
    }

    // Approaches --> 2 using recursive

    public static boolean check(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null || root1.data != root2.data) {
            return false;
        }

        return check(root1.left, root2.right) && check(root1.right, root2.left);
    }

    public static boolean isSymmetricTree_recur(TreeNode root) {
        if (root == null) {
            return true;
        }
        return (check(root.left, root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetricTree(root));
        System.out.println(isSymmetricTree_recur(root));

    }
}
