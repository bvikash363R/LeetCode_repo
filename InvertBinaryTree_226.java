// https://leetcode.com/problems/invert-binary-tree/description

import Node.TreeNode;

class InvertBinaryTree_226 {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode node = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(node);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        TreeNode.preorder(root);

        System.out.println();

        TreeNode.preorder(invertTree(root));
    }
}