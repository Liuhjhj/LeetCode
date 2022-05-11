package map;

import pub.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <a href="https://leetcode-cn.com/problems/find-duplicate-subtrees/">寻找重复的子树</a>
 *
 * @author liuhjhj
 * @date 2022/3/4
 **/
public class FindDuplicateSubtrees {

    List<BinaryTreeNode> result = new ArrayList<>();
    Map<String, BinaryTreeNode> map = new ConcurrentHashMap<>();

    public List<BinaryTreeNode> findDuplicateSubtrees(BinaryTreeNode root) {
        transferTreeToString(root);
        return result;
    }

    public String transferTreeToString(BinaryTreeNode node) {
        if (node == null) {
            // 这里必须要返回#， 不能返回空字符串
            // 解答错误: [0,0,0,0,null,null,0,null,null,null,0]
            return "#";
        }
        String leftString = transferTreeToString(node.left);
        String rightString = transferTreeToString(node.right);
        // 这里中间要加","
        // 解答错误: [2,1,11,11,null,1]
        String resultStr = node.val+"," + leftString +"," + rightString;
        // 如果map.get(resultStr) == null 则什么也不做
        if (map.containsKey(resultStr) && map.get(resultStr)!=null){
            map.put(resultStr,null);
            result.add(node);
        }else if(!map.containsKey(resultStr)){
            map.put(resultStr,node);
        }
        return resultStr;
    }
}
