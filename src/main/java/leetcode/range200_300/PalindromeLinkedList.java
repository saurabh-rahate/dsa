package leetcode.range200_300;

import leetcode.ListNode;

import java.util.LinkedList;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        PalindromeLinkedList obj = new PalindromeLinkedList();

        System.out.println(obj.isPalindrome(ListNode.numberToList(1, 2, 2, 1)));
        System.out.println(obj.isPalindrome(ListNode.numberToList(1, 2)));
        System.out.println(obj.isPalindrome(ListNode.numberToList(1)));
    }

    public boolean isPalindrome(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        if (list.size() == 1) return true;

        while (list.size() > 1) {
            if (list.pollFirst() != list.pollLast()) return false;
        }

        return true;
    }
}
