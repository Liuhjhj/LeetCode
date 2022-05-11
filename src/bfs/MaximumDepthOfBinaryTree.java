package bfs;

import pub.BinaryTreeNode;

/**
 * <a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">二叉树的最大深度</a>
 *
 * @author liuhj
 * @date 2021/12/18 17:53
 */
public class MaximumDepthOfBinaryTree {

    public static int maxDepth(BinaryTreeNode root) {
        return bfs(root,0);
    }

    public static Integer bfs(BinaryTreeNode node, Integer layer){
        if (node == null){
            return layer;
        }
        return Math.max(bfs(node.left,layer+1),bfs(node.right,layer+1));
    }
}
