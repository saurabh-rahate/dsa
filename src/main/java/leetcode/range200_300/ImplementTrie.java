package leetcode.range200_300;

public class ImplementTrie {
    public static void main(String[] args) {
        String word = "abcd";
        String prefix = "ab";
        Trie obj = new Trie();
        obj.insert(word);
        obj.insert("abcc");
        boolean param_2 = obj.search(word);
        boolean param_3 = obj.startsWith(prefix);
    }
}

// TODO: Without map, use Prefix Tree Data Structure
class Trie {
    private final Node[] words;

    public Trie() {
        words = new Node[26];
    }

    public void insert(String word) {
        Node current = null;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (i == 0) {
                current = words[getIndex(letter)] == null ? new Node(word.charAt(i)) : words[getIndex(letter)];
                words[getIndex(current.letter)] = current;
            } else {
                Node newNode = current.nextLetters[getIndex(letter)] == null ? new Node(word.charAt(i)) : current.nextLetters[getIndex(letter)];
                current.nextLetters[getIndex(newNode.letter)] = newNode;
                current = newNode;
            }
        }
        if (current != null) {
            current.isEnd = true;
        }
    }

    private int getIndex(char letter) {
        return letter - 'a';
    }

    private int getIndex(String word, int charAt) {
        return getIndex(word.charAt(charAt));
    }

    public boolean search(String word) {
        Node current = null;
        for (int i = 0; i < word.length(); i++) {
            current = i == 0 ? words[getIndex(word, i)] : current.nextLetters[getIndex(word, i)];
            if (current == null) return false;
        }
        return current != null && current.isEnd;
    }

    public boolean startsWith(String word) {
        Node current = null;
        for (int i = 0; i < word.length(); i++) {
            current = i == 0 ? words[getIndex(word, i)] : current.nextLetters[getIndex(word, i)];
            if (current == null) return false;
        }
        return current != null;
    }

    static class Node {
        private final Node[] nextLetters;
        private final char letter;
        private boolean isEnd;

        Node(char letter) {
            nextLetters = new Node[26];
            this.letter = letter;
            this.isEnd = false;
        }
    }
}
