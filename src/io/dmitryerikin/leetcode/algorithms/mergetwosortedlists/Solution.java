package io.dmitryerikin.leetcode.algorithms.mergetwosortedlists;

import java.util.Arrays;
import java.util.Iterator;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String result = listToString(
                solution.mergeTwoLists(
                        createList(new int[] {1, 2, 4}),
                        createList(new int[] {1, 3, 4})
                )
        );
        assert "[1,1,2,3,4,4]".equals(result);
        System.out.println(result);

        result = listToString(
                solution.mergeTwoLists(
                        createList(new int[] {}),
                        createList(new int[] {})
                )
        );
        assert "[]".equals(result);
        System.out.println(result);

        result = listToString(
                solution.mergeTwoLists(
                        createList(new int[] {}),
                        createList(new int[] {0})
                )
        );
        assert "[0]".equals(result);
        System.out.println(result);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        if (list1.val > list2.val) {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        } else {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
    }

    public static String listToString (ListNode node) {
        if (node == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (node != null) {
            sb.append(node.val);
            if (node.next != null) {
                sb.append(",");
            }
            node = node.next;
        }

        sb.append("]");

        return sb.toString();
    }

    public static ListNode createList(int[] vals) {
        if (vals.length == 0) {
            return null;
        }

        ListNode head = new ListNode();
        ListNode current = head;
        Iterator<Integer> valsIterator = Arrays.stream(vals).iterator();
        while (valsIterator.hasNext()) {
            current.val = valsIterator.next();
            if (valsIterator.hasNext()) {
                current.next = new ListNode();
            }
            current = current.next;

        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
