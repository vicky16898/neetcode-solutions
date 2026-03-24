package Trie;

public class PrefixTree {
    Trie trie;

    public PrefixTree() {
        trie = new Trie();
    }

    public void insert(String word) {
        Trie localTrie = trie;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append(word.charAt(i));
            if (localTrie.children[word.charAt(i) - 'a'] == null) {
                localTrie.children[word.charAt(i) - 'a'] = new Trie();
                localTrie.children[word.charAt(i) - 'a'].prefix = sb.toString();
            }
            localTrie = localTrie.children[word.charAt(i) - 'a'];
        }
        localTrie.isEnd = true;
    }

    public boolean search(String word) {
        Trie localTrie = trie;
        for (int i = 0; i < word.length(); i++) {
            if (localTrie.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            localTrie = localTrie.children[word.charAt(i) - 'a'];
        }
        return localTrie.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie localTrie = trie;
        for (int i = 0; i < prefix.length(); i++) {
            if (localTrie.children[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            localTrie = localTrie.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}

class Trie {
    Trie[] children;
    boolean isEnd;
    String prefix;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
        prefix = "";
    }

}