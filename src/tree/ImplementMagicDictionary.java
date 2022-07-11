package tree;

/**
 * <a href="https://leetcode.cn/problems/implement-magic-dictionary/">实现一个魔法字典</a>
 * <p>知识点: 字典树</p>
 *
 * @author liuhjhj
 * @date 2022/7/11 下午10:41
 */
public class ImplementMagicDictionary {

    public static void main(String[] args) {
        MagicDictionary ma = new MagicDictionary();
        String[] strs = {"hello", "leetcode"};
        ma.buildDict(strs);
        boolean hello = ma.search("hello");
        System.out.println(hello);
    }

    static class MagicDictionary {

        MagicDictionary[] tries;

        boolean isDictionary;

        public MagicDictionary() {
            this.tries = new MagicDictionary[26];
            this.isDictionary = false;
        }

        public void buildDict(String[] dictionary) {
            for (String word : dictionary) {
                MagicDictionary cur = this;
                for (int i = 0; i < word.length(); i++) {
                    if (cur.tries[word.charAt(i) - 'a'] == null) {
                        cur.tries[word.charAt(i) - 'a'] = new MagicDictionary();
                    }
                    cur = cur.tries[word.charAt(i) - 'a'];
                }
                cur.isDictionary = true;
            }
        }

        public boolean search(String searchWord) {
            int index = searchWord.charAt(0) - 'a';

            boolean result = search(tries[index], searchWord.substring(1), true);
            for (int i = 0; i < tries.length; i++) {
                if (i == index) {
                    continue;
                }
                result = result || search(this, (char) (i + 'a') + searchWord.substring(1), false);
            }
            return result;
        }

        public boolean search(MagicDictionary trie, String searchWord, boolean change) {

            if (trie == null) {
                return false;
            }
            if (searchWord.length() == 0) {
                if (!change) {
                    return trie.isDictionary;
                } else {
                    return false;
                }
            }
            int index = searchWord.charAt(0) - 'a';
            if (change) {
                boolean result = search(trie.tries[index], searchWord.substring(1), true);
                for (int i = 0; i < trie.tries.length; i++) {
                    if (i == index) {
                        continue;
                    }
                    result = result || search(trie, (char) (i + 'a') + searchWord.substring(1), false);
                }
                return result;
            } else {
                return search(trie.tries[index], searchWord.substring(1), false);
            }
        }
    }
}
