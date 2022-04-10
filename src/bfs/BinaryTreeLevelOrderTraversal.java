package bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二叉树的层次遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 知识点: 深/广度优先遍历
 *
 * @author liuhj
 * @date 2021/12/15 23:01
 */
public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(8);
        bfs(result, root, 1);
        return result;
    }

    public static void bfs(List<List<Integer>> result, TreeNode node, Integer layer) {
        if (node == null) {
            return;
        }
        if (result.size() < layer) {
            result.add(new ArrayList<>(8));
        }
        result.get(layer).add(node.val);
        bfs(result, node.left, layer+1);
        bfs(result, node.right, layer+1);
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}
