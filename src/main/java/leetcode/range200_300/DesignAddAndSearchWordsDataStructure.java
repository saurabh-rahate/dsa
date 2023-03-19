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

    Node[] dictionary;

    public WordDictionary() {
        this.dictionary = new Node[26];
    }

    public void addWord(String word) {
        char letter = word.charAt(0);
        Node current = dictionary[letter - 'a'] == null ? new Node(letter) : dictionary[letter - 'a'];
        dictionary[letter - 'a'] = current;
        for (int i = 1; i < word.length(); i++) {
            letter = word.charAt(i);
            if (current.nextLetters[letter - 'a'] == null) {
                Node newNode = new Node(letter);
                current.nextLetters[letter - 'a'] = newNode;
                current = newNode;
            } else {
                current = current.nextLetters[letter - 'a'];
            }
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        if (Arrays.stream(dictionary).noneMatch(Objects::nonNull)) return false;

        char letter = word.charAt(0);
        if (letter == '.') {
            Predicate<Node> predicate = word.length() == 1 ? n -> n.isEnd : n -> search(n, 1, word);
            return Arrays.stream(dictionary).filter(Objects::nonNull).anyMatch(predicate);
        } else {
            Node node = dictionary[letter - 'a'];
            if (word.length() == 1) {
                return node != null && node.letter == letter && node.isEnd;
            } else {
                return node != null && search(node, 1, word);
            }
        }
    }

    private boolean search(Node node, int index, String word) {
        char letter = word.charAt(index);
        if (letter == '.') {
            Predicate<Node> predicate = index == word.length() - 1 ? n -> n.isEnd : n -> search(n, index + 1, word);
            return Arrays.stream(node.nextLetters).filter(Objects::nonNull).anyMatch(predicate);
        } else {
            Node newNode = node.nextLetters[letter - 'a'];
            if (index == word.length() - 1) {
                return newNode != null && letter == newNode.letter && newNode.isEnd;
            } else {
                return newNode != null && letter == newNode.letter && search(newNode, index + 1, word);
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return letter == node.letter;
        }

        @Override
        public int hashCode() {
            return letter;
        }
    }
}


