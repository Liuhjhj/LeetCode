package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/prefix-and-suffix-search/">前缀和后缀搜索</a>
 * <p>知识点: 字典树</p>
 *
 * @author liuhjhj
 * @date 2022/7/15 下午7:30
 */
public class PrefixAndSuffixSearch {

    static class WordFilter {
        Trie preSuffixTrie;

        Trie suffixTrie;

        public WordFilter(String[] words) {
            preSuffixTrie = new Trie();
            suffixTrie = new Trie();
            // 构建正反两个字典树
            for (int i = 0; i < words.length; i++) {
                String s = words[i];

                Trie cur = this.preSuffixTrie;
                for (int j = 0; j < s.length(); j++) {
                    char ch = s.charAt(j);
                    int index = ch - 'a';
                    if (cur.children[index] == null) {
                        cur.children[index] = new Trie();
                    }
                    cur = cur.children[index];
                    cur.wordIndex.add(i);
                }

                cur = this.suffixTrie;
                for (int j = s.length() - 1; j >= 0; j--) {
                    char ch = s.charAt(j);
                    int index = ch - 'a';
                    if (cur.children[index] == null) {
                        cur.children[index] = new Trie();
                    }
                    cur = cur.children[index];
                    cur.wordIndex.add(i);
                }

            }
        }

        public int f(String pref, String suff) {

            Trie curPreSuffix = this.preSuffixTrie;

            for (int i = 0; i < pref.length(); i++) {
                char ch = pref.charAt(i);
                int index = ch - 'a';
                if (curPreSuffix.children[index] == null) {
                    return -1;
                }
                curPreSuffix = curPreSuffix.children[index];
            }
            // 正向遍历, 找出符合前缀的单词的索引
            List<Integer> preSuffixList = curPreSuffix.wordIndex;

            Trie curSuffix = this.suffixTrie;
            for (int i = suff.length() - 1; i >= 0; i--) {
                char ch = suff.charAt(i);
                int index = ch - 'a';
                if (curSuffix.children[index] == null) {
                    return -1;
                }
                curSuffix = curSuffix.children[index];
            }
            // 反向遍历, 找出符合后缀的单词的索引
            List<Integer> suffixList = curSuffix.wordIndex;

            // 只能遍历, 不能取两个数组的差集, 否则会超时
            int preIndex = preSuffixList.size() - 1;
            int index = suffixList.size() - 1;
            while (preIndex >= 0 && index >= 0) {
                int preNum = preSuffixList.get(preIndex);
                int num = suffixList.get(index);
                if (preNum == num) {
                    return num;
                } else if (preNum > num) {
                    preIndex--;
                } else {
                    index--;
                }
            }
            return -1;

        }
    }

    static class Trie {

        Trie[] children;

        /**
         * 用于保存符合当前前缀的单词的下标
         */
        List<Integer> wordIndex;

        public Trie() {
            children = new Trie[26];
            wordIndex = new ArrayList<>(16);
        }
    }
}
