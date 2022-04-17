package bfs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/">二叉树的序列化与反序列化</a>
 *
 * @author liuhjhj
 * @date 2022/2/19
 **/
public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree serialize = new SerializeAndDeserializeBinaryTree();
        TreeNode root = serialize.deserialize("9 3 15 20 7 9 15 7 20 3");
        String s = serialize.serialize(root);
        System.out.println(s);
    }

    private static Map<Integer, Integer> map = new HashMap<>();

    private Integer number = 2000;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        dfs1(root, inOrder, postOrder);
        StringBuilder stringBuilder = new StringBuilder();
        inOrder.forEach(integer -> stringBuilder.append(integer).append(" "));
        postOrder.forEach(integer -> stringBuilder.append(integer).append(" "));
        //System.out.println(stringBuilder);
        return stringBuilder.toString();
    }

    public void dfs1(TreeNode node, List<Integer> inOrder, List<Integer> postOrder) {
        if (node == null) {
            return;
        }
        dfs1(node.left, inOrder, postOrder);
        int val = node.val;
        if (map.containsKey(val)) {
            node.val += number++;
        }
        map.put(node.val, val);
        inOrder.add(node.val);
        dfs1(node.right, inOrder, postOrder);
        postOrder.add(node.val);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(" ");
        int[] inOrder = new int[strings.length / 2];
        int[] postOrder = new int[strings.length / 2];
        for (int i = 0; i < strings.length / 2; i++) {
            inOrder[i] = Integer.parseInt(strings[i]);
        }
        for (int i = strings.length / 2; i < strings.length; i++) {
            postOrder[i - strings.length / 2] = Integer.parseInt(strings[i]);
        }
        return dfs2(inOrder, postOrder, 0, inOrder.length - 1, 0, postOrder.length - 1);
    }

    public TreeNode dfs2(int[] inOrder, int[] postOrder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        } else if (inStart == inEnd) {
            return new TreeNode(map.get(inOrder[inStart]));
        }
        int center = map.get(postOrder[postEnd]);
        int centerIndex = Arrays.stream(inOrder).boxed().collect(Collectors.toList()).indexOf(postOrder[postEnd]);
        TreeNode node = new TreeNode(center);
        node.left = dfs2(inOrder, postOrder, inStart, centerIndex - 1, postStart, postStart + centerIndex - 1 - inStart);
        node.right = dfs2(inOrder, postOrder, centerIndex + 1, inEnd, postEnd - 1 - (inEnd - (centerIndex + 1)), postEnd - 1);
        return node;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
