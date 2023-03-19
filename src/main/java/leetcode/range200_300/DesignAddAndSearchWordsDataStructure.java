package leetcode.range200_300;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        if (word.length() == 1) {
            if (letter == '.') return Arrays.stream(dictionary).filter(Objects::nonNull).anyMatch(n -> n.isEnd);
            Node node = dictionary[letter - 'a'];
            if (node == null) return false;
            else return node.letter == letter && node.isEnd;
        }

        if (letter == '.') {
            return Arrays.stream(dictionary).filter(Objects::nonNull).anyMatch(n -> search(n, 1, word));
        } else {
            Node node = dictionary[word.charAt(0) - 'a'];
            if (node == null) return false;
            else return search(node, 1, word);
        }
    }

    private boolean search(Node node, int index, String word) {
        char letter = word.charAt(index);
        if (letter == '.') {
            if (index == word.length() - 1) {
                return Arrays.stream(node.nextLetters)
                        .filter(Objects::nonNull)
                        .anyMatch(n -> n.isEnd);
            } else {
                return Arrays.stream(node.nextLetters)
                        .filter(Objects::nonNull)
                        .anyMatch(n -> search(n, index + 1, word));
            }
        } else {

            if (index == word.length() - 1) {
                Node newNode = node.nextLetters[letter - 'a'];
                if (newNode == null) return false;
                if (letter == newNode.letter) return newNode.isEnd;
                else return false;
            } else {
                Node newNode = node.nextLetters[letter - 'a'];
                if (newNode == null) return false;
                if (letter == newNode.letter) {
                    return search(newNode, index + 1, word);
                } else return false;
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


