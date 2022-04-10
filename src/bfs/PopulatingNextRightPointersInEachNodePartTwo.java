package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针-II
 *
 * @author liuhj
 * @date 2021/12/18 22:04
 */
public class PopulatingNextRightPointersInEachNodePartTwo {

    /**
     * 迭代耗时 2ms
     * @param root 根节点
     * @return 修改后的根节点
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node parent = queue.poll();
                if (parent == null) {
                    break;
                }
                Node node = parent;
                if (parent.left != null) {
                    while (node != null) {
                        if (node == parent) {
                            if (node.right != null) {
                                parent.left.next = node.right;
                                break;
                            }
                        } else {
                            if (node.left != null) {
                                parent.left.next = node.left;
                                break;
                            } else if (node.right != null) {
                                parent.left.next = node.right;
                                break;
                            }
                        }
                        node = node.next;
                    }
                }
                if (parent.right != null) {
                    node = parent.next;
                    while (node != null) {
                        if (node.left != null) {
                            parent.right.next = node.left;
                            break;
                        } else if (node.right != null) {
                            parent.right.next = node.right;
                            break;
                        }
                        node = node.next;
                    }
                }
                if (parent.left != null) {
                    queue.add(parent.left);
                }
                if (parent.right != null) {
                    queue.add(parent.right);
                }
            }
        }
        return root;
    }

    /**
     * 递归耗时 8ms
     * @param parent 父节点
     * @param child 子节点
     * @param isLeftChild 是否是左节点
     */
    public void bfs(Node parent, Node child, boolean isLeftChild) {
        if (child == null) {
            return;
        }
        // parent为null说明是root节点
        if (parent == null) {
            child.next = null;
        } else {
            if (isLeftChild) {
                Node node = parent;
                while (node != null) {
                    if (node == parent) {
                        if (node.right != null) {
                            child.next = node.right;
                            break;
                        }
                    } else {
                        if (node.left != null) {
                            child.next = node.left;
                            break;
                        } else if (node.right != null) {
                            child.next = node.right;
                            break;
                        }
                    }
                    node = node.next;
                }
            } else {
                Node node = parent.next;
                while (node != null) {
                    if (node.left != null) {
                        child.next = node.left;
                        break;
                    } else if (node.right != null) {
                        child.next = node.right;
                        break;
                    }
                    node = node.next;
                }
            }
        }
        bfs(child, child.left, true);
        bfs(child, child.right, false);
        // 左子树需要递归两次, 因为递归过程中先递归的左子树
        // 导致右子树的next没有被赋值, 导致答案错误
        bfs(child, child.left, true);
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }

    ;
}
