package linkedlist;

import pub.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/4ueAj6/">剑指 Offer II 029. 排序的循环链表</a>
 *
 * @author liuhj
 * @date 2022/6/18
 **/
public class SortCircularLinkedList {

    public ListNode insert(ListNode head, int insertVal) {
        if (head == null){
            ListNode newListNode = new ListNode(insertVal);
            newListNode.next = newListNode;
            return newListNode;
        }
        ListNode cur = head.next;
        ListNode last = head;
        if (cur == last){
            insertListNode(cur, insertVal);
            return head;
        }
        Set<ListNode> set = new HashSet<>();
        while (true){
            set.add(last);
            // set.contains(cur)表示已经循环遍历了一次链表
            // cur.val < last.val 表示此时达到了边界, cur.val为链表中的最小值, last.val为链表中的最大值
            // 如果循环遍历了一次链表还没找到可插入的位置, 则表示链表中所有节点的值都是一样的
            if (set.contains(cur) || cur.val < last.val){
                if (cur.val > insertVal || last.val <= insertVal){
                    insertListNode(last, insertVal);
                    return head;
                }
            } else {
                if (cur.val > insertVal && last.val <= insertVal){
                    insertListNode(last, insertVal);
                    return head;
                }
            }
            cur = cur.next;
            last = last.next;
        }

    }

    public void insertListNode(ListNode node, int val){
        ListNode newListNode = new ListNode(val);
        newListNode.next = node.next;
        node.next = newListNode;
    }
}
