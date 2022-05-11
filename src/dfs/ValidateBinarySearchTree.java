package dfs;

import pub.BinaryTreeNode;

/**
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/">验证二叉搜索树</a>
 *
 * @author liuhjhj
 * @date 2022/4/17
 **/
public class ValidateBinarySearchTree {

    public boolean isValidBST(BinaryTreeNode root) {
        return isSearchTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 边界情况, 最大值和最小值需要使用long类型整数
     *
     * @param node 当前遍历节点
     * @param min  最小值
     * @param max  最大值
     * @return 是否为二叉搜索树
     */
    public boolean isSearchTree(BinaryTreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isSearchTree(node.left, min, node.val) && isSearchTree(node.right, node.val, max);
    }
}
