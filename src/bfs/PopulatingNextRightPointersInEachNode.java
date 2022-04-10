package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 *
 * @author liuhj
 * @date 2021/12/18 20:16
 */
public class PopulatingNextRightPointersInEachNode {

    public static Node connectIteration(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.next = null;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                if (node.left!=null) {
                    queue.add(node.left);
                    node.left.next = node.right;
                }
                if (node.right!=null) {
                    queue.add(node.right);
                    if (node.next == null) {
                        node.right.next = null;
                    } else {
                        node.right.next = node.next.left;
                    }
                }
            }
        }
        return root;
    }

    public void connectBfs(Node parent,Node child,boolean isLeftChild){
        if (child == null){
            return;
        }
        // parent为null说明是root节点
        if (parent == null){
            child.next = null;
        }else {
            if (isLeftChild) {
                child.next = parent.right;
            }else {
                if (parent.next == null){
                    child.next = null;
                }else {
                    child.next = parent.next.left;
                }
            }
        }
        connectBfs(child,child.left,true);
        connectBfs(child,child.right,false);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    };
}
