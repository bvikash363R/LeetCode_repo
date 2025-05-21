import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Node.TreeNode;

class ZigzagLevelOrder_103 {

    public static List<List<Integer>> levelOder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> que = new LinkedList<>();
        boolean leftToright = true;

        que.add(root);

        while (!que.isEmpty()) {
            int n = que.size();
            LinkedList<Integer> ll = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                TreeNode node = que.poll();
                if (leftToright) {
                    ll.addLast(node.data);
                } else {
                    ll.addFirst(node.data);
                }

                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }

            result.add(ll);
            leftToright = !leftToright;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}