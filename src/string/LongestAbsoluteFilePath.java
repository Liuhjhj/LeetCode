package string;

import pub.StringTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/longest-absolute-file-path/">文件的最长绝对路径</a>
 *
 * @author liuhjhj
 * @date 2022/4/20
 **/
public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {
        int result = 0;
        // 字符串中没有 ".", 说明这个字符串里面没有文件
        if (!input.contains(".")) {
            return result;
        }
        // 题目中有时会用4个空格表示制表符
        input = input.replaceAll("\n {4}", "\n\t");
        // 计算文件夹的每一层
        String[] deeps = input.split("\n");
        // deeps[0] 为根节点
        // 如果根节点为文件, 说明没有文件夹, 文件的最长绝对路径为最长文件名的长度
        if (deeps[0].contains(".")) {
            return Arrays.stream(deeps).map(String::length).mapToInt(Integer::intValue).max().orElse(0);
        }
        // 存放根目录的数组, 可能有多个根目录
        List<StringTreeNode> roots = new ArrayList<>(16);
        for (String line : deeps) {
            String[] deepSplit = line.split("\t");
            // deepSplit的长度代表了当前文件或文件夹的深度
            // deepSplit的长度为1, 说明是根目录
            if (deepSplit.length == 1) {
                roots.add(new StringTreeNode(deepSplit[0]));
                continue;
            }
            // 拿到当前层的根目录
            StringTreeNode lastRoot = roots.get(roots.size() - 1);
            // 当前层的根目录的名字
            StringBuilder path = new StringBuilder(lastRoot.val).append("/");
            StringTreeNode nodeTemp = lastRoot;
            // 遍历当前层的所有父目录
            for (int i = 1; i < deepSplit.length - 1; i++) {
                nodeTemp = nodeTemp.children.get(nodeTemp.children.size() - 1);
                path.append(nodeTemp.val).append("/");
            }
            path.append(deepSplit[deepSplit.length - 1]);
            // 当前层是一个文件才计算最长的绝对路径
            // 如果是文件夹, 则不计算(当前层是一个空文件夹)
            if (path.toString().contains(".")) {
                result = Math.max(result, path.length());
            }
            // 将当前层加到父目录的子节点里面
            nodeTemp.children.add(new StringTreeNode(deepSplit[deepSplit.length - 1]));
            path.setLength(0);
        }
        return result;
    }
}
