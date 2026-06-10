package leetcode.range2000_2100;

public class ReversePrefixOfWord {

    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
        System.out.println(reversePrefix("xyxzxe", 'z'));
        System.out.println(reversePrefix("abcd", 'z'));
    }

    public static String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        StringBuilder sb = new StringBuilder();
        for (int i = index; i >= 0; i--)
            sb.append(word.charAt(i));

        sb.append(word.substring(index + 1));
        return sb.toString();
    }
}
