package bfs;

import pub.BinaryTreeNode;

import java.util.*;

/**
 * <a href="https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/">二叉树的锯齿形层序遍历</a>
 * <p>知识点: 深/广度优先遍历</p>
 *
 * @author liuhj
 * @date 2021/12/18 17:31
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        int layer = -1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            layer++;
            for (int i = 0; i < size; i++) {
                BinaryTreeNode node = queue.remove();
                if (result.size() <= layer) {
                    result.add(new ArrayList<>());
                }
                if (layer % 2 == 0) {
                    result.get(layer).add(node.val);
                } else {
                    result.get(layer).add(0, node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }
}
