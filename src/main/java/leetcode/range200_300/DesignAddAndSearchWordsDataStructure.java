package leetcode.range200_300;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

public class DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
        // ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
        // [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        boolean param_2 = obj.search("pad");
        param_2 = obj.search("bad");
        param_2 = obj.search(".ad");
        param_2 = obj.search("b..");
        param_2 = obj.search("bdd");
    }


}

class WordDictionary {

    Node dictionary;

    public WordDictionary() {
        this.dictionary = new Node('*');
    }

    public void addWord(String word) {
        Node current = dictionary;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (current.nextLetters[getIndex(letter)] == null) {
                Node newNode = new Node(letter);
                current.nextLetters[getIndex(letter)] = newNode;
                current = newNode;
            } else {
                current = current.nextLetters[getIndex(letter)];
            }
        }
        current.isEnd = true;
    }

    private static int getIndex(char letter) {
        return letter - 'a';
    }

    public boolean search(String word) {
        if (Arrays.stream(dictionary.nextLetters).noneMatch(Objects::nonNull)) return false;
        return search(dictionary, 0, word);
    }

    private boolean search(Node node, int index, String word) {
        char letter = word.charAt(index);
        if (letter == '.') {
            Predicate<Node> predicate = index == word.length() - 1 ? n -> n.isEnd : n -> search(n, index + 1, word);
            return Arrays.stream(node.nextLetters).filter(Objects::nonNull).anyMatch(predicate);
        } else {
            node = node.nextLetters[getIndex(letter)];
            if (index == word.length() - 1) {
                return node != null && letter == node.letter && node.isEnd;
            } else {
                return node != null && letter == node.letter && search(node, index + 1, word);
            }
        }
    }

    static class Node {
        char letter;
        Node[] nextLetters;
        boolean isEnd;

        public Node(char letter) {
            this.letter = letter;
            nextLetters = new Node[26];
            isEnd = false;
        }
    }
}


