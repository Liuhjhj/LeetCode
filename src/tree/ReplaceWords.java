package tree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.cn/problems/replace-words/">单词替换</a>
 * <p>知识点: 字典数</p>
 *
 * @author liuhjhj
 * @date 2022年07月08日 23:37:53
 */
public class ReplaceWords {

    public static void main(String[] args) {
        ReplaceWords re = new ReplaceWords();
        String[] dictionary = {"catt", "cat", "bat", "rat"};
        String s = re.replaceWords(Arrays.stream(dictionary).collect(Collectors.toList()), "the cattle was rattled by the battery");
        System.out.println(s);
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = getTrie(dictionary);
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            String word = strings[i];
            strings[i] = search(trie, word);
        }
        StringBuilder sb = new StringBuilder();
        for (String word : strings) {
            sb.append(word).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public Trie getTrie(List<String> dictionary) {
        Trie root = new Trie();
        dictionary.forEach(word -> {
            char[] chars = word.toCharArray();
            Trie cur = root;
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new Trie();
                }
                cur = cur.children[ch - 'a'];
                if (i == chars.length - 1) {
                    cur.isDictionary = true;
                }
            }
        });
        return root;
    }

    public String search(Trie trie, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (trie.children[ch - 'a'] != null) {
                trie = trie.children[ch - 'a'];
                if (trie.isDictionary) {
                    return word.substring(0, i + 1);
                }
            } else {
                return word;
            }
        }
        return word;
    }

    static class Trie {
        Trie[] children;

        boolean isDictionary;

        public Trie() {
            children = new Trie[26];
            isDictionary = false;
        }
    }
}
