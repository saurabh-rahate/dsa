package leetcode;

public class DeleteColumnsToMakeSorted {
    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[]{"cba","daf","ghi"}));

    }
    public static int minDeletionSize(String[] strs) {
        int length = strs[0].length();
        int res = 0;
        for (int i=0;i<length;i++) {
            char prevChar = strs[0].charAt(i);
            for (String str : strs) {
                char c = str.charAt(i);
                if (c < prevChar) {
                    res++;
                    break;
                } else if (c > prevChar)
                    prevChar = c;
            }
        }
        return res;
    }
}
