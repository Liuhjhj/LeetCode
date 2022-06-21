package bfs;

import pub.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/find-bottom-left-tree-value/">找树左下角的值</a>
 *
 * @author liuhjhj
 * @date 2022/6/22 0:22
 **/
public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            result = queue.peek().val;
            for (int i = 0; i < size; i++) {
                BinaryTreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
}
