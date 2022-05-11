package bfs;

import pub.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuhjhj
 * @date 2022/5/11
 **/
public class SerializeAndDeserializeBinarySearchTree {

    // Encodes a tree to a single string.
    public String serialize(BinaryTreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        serializeDfs(root, preOrder);
        String result = preOrder.toString();
        return result.substring(1, result.length() - 1);
    }

    public void serializeDfs(BinaryTreeNode node, List<Integer> preOrder) {
        if (node == null) {
            return;
        }
        preOrder.add(node.val);
        serializeDfs(node.left, preOrder);
        serializeDfs(node.right, preOrder);
    }

    // Decodes your encoded data to tree.
    public BinaryTreeNode deserialize(String data) {
        String[] split = data.split(", ");
        List<Integer> preOrder = Arrays.stream(split).filter(s -> s.length() > 0).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> inOrder = Arrays.stream(split).filter(s -> s.length() > 0).map(Integer::parseInt).sorted().collect(Collectors.toList());
        return deserializeDfs(preOrder, inOrder);
    }

    public BinaryTreeNode deserializeDfs(List<Integer> preOrder, List<Integer> inOrder) {
        if (preOrder.isEmpty()) {
            return null;
        } else if (preOrder.size() == 1) {
            return new BinaryTreeNode(preOrder.get(0));
        }
        int centerIndex = inOrder.indexOf(preOrder.get(0));
        BinaryTreeNode node = new BinaryTreeNode(preOrder.get(0));

        List<Integer> leftPreList = preOrder.subList(1, centerIndex + 1);
        List<Integer> rightPreList = preOrder.subList(centerIndex + 1, preOrder.size());
        List<Integer> leftInList = inOrder.subList(0, centerIndex);
        List<Integer> rightInList = inOrder.subList(centerIndex + 1, inOrder.size());
        node.left = deserializeDfs(leftPreList, leftInList);
        node.right = deserializeDfs(rightPreList, rightInList);
        return node;
    }
}
