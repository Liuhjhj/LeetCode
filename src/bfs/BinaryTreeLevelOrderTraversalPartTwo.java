package bfs;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal-ii/">二叉树的层序遍历-II</a>
 *
 * @author liuhj
 * @date 2021/12/18 18:05
 */
public class BinaryTreeLevelOrderTraversalPartTwo {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int layer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            layer++;
            result.add(new ArrayList<>());
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                result.get(layer - 1).add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        Collections.reverse(result);
        return result;
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        Integer val;
    }
}
