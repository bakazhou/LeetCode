package DailyCode.topic208;

import java.util.HashSet;
import java.util.Set;

public class Trie {
    public Set<String> pre;
    public Set<String> words;
    /** Initialize your data structure here. */
    public Trie() {
        pre = new HashSet<>();
        words = new HashSet<>();
    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        for (int i=1;i<word.length();i++){
            this.pre.add(new String(word.substring(0,i)));
        }
        this.pre.add(word);
        this.words.add(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return this.words.contains(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return this.pre.contains(prefix);
    }
}
