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

    HashSet<Node> dictionary;

    public WordDictionary() {
        this.dictionary = new HashSet<>();
    }

    public void addWord(String word) {
        Node current = null;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (i == 0) {
                current = this.dictionary
                        .stream()
                        .filter(node -> node.letter == letter)
                        .findFirst()
                        .orElseGet(() -> {
                            Node newNode = new Node(letter);
                            dictionary.add(newNode);
                            return newNode;
                        });
            } else {
                Node finalCurrent = current;
                current = current.nextLetters
                        .stream()
                        .filter(node -> node.letter == letter)
                        .findFirst()
                        .orElseGet(() -> {
                            Node newNode = new Node(letter);
                            finalCurrent.nextLetters.add(newNode);
                            return newNode;
                        });
            }
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        Stream<Node> nodes = null;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (i == 0) {
                if (letter == '.') {
                    nodes = dictionary.stream();
                } else {
                    if (dictionary.stream().noneMatch(node -> node.letter == letter)) return false;
                    nodes = dictionary
                            .stream()
                            .filter(node -> node.letter == letter);
                }
            } else {
                if (letter == '.') {
                    nodes = nodes
                            .map(node -> node.nextLetters)
                            .flatMap(HashSet::stream);
                } else {
                    nodes = nodes
                            .map(node -> node.nextLetters)
                            .flatMap(HashSet::stream)
                            .filter(node -> node.letter == letter);
                }
            }
//            nodes.findAny().isPresent()
//            if (!nodes.findAny().isPresent()) return false;

        }
        return nodes.anyMatch(node -> node.isEnd);
    }

    private int getIndex(char letter) {
        return letter - 'a';
    }

    static class Node {
        char letter;
        HashSet<Node> nextLetters;
        boolean isEnd;

        public Node(char letter) {
            this.letter = letter;
            nextLetters = new HashSet<>();
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


