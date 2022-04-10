package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 知识点: 深/广度优先遍历
 *
 * @author liuhj
 * @date 2021/12/15 22:28
 */
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        return iteration(root);
    }

    public static boolean bfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return bfs(left.left, right.right) && bfs(left.right, right.left) && left.val == right.val;
        }
        return false;
    }

    public static boolean iteration(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (true) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.get(0);
                list.remove(0);
                if (node != null) {
                    list.add(node.left);
                    list.add(node.right);
                }
            }

            if (list.size() % 2 == 1) {
                return false;
            }
            if (list.isEmpty()) {
                return true;
            }
            for (int i = 0; i <= list.size() / 2; i++) {
                TreeNode head = list.get(i);
                TreeNode end = list.get(list.size() - 1 - i);
                if (head != null && end != null) {
                    if (head.val != end.val) {
                        return false;
                    }
                } else if (head == null && end == null) {
                    continue;
                } else {
                    return false;
                }
            }
        }
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(Integer val) {
            this.val = val;
        }
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!"null".equals(item)) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!"null".equals(item)) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        /// String line = "[1,2,2,3,4,4,3]";
        /// String line = "[1,2,2,null,3,null,3]";
        /// String line = "[2,3,3,4,5,5,4,null,null,8,9,null,null,9,8]";
        String line = "[9,25,25,null,-95,-95,null,-100,null,null,-15]";
        TreeNode root = stringToTreeNode(line);
        assert root != null;
        boolean ret = isSymmetric(root);

        String out = booleanToString(ret);

        System.out.print(out);
    }
}
