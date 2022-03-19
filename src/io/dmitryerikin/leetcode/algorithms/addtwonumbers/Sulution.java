package io.dmitryerikin.leetcode.algorithms.addtwonumbers;

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // pointers of begin of each list
        ListNode currentNode1 = l1;
        ListNode currentNode2 = l2;

        // pointer of result list head to return;
        ListNode resultHead = new ListNode();

        // pointer of current node of result list
        ListNode resultCursor = resultHead;
        int carry = 0;

        // calculate result until there is nothing to calculate (both lists reached the end and there is no carry)
        while (currentNode1 != null || currentNode2 != null || carry == 1) {
            // calculate current decimal place
            resultCursor.val =
                    (currentNode1 == null ? 0 : currentNode1.val) +
                            (currentNode2 == null ? 0 : currentNode2.val) +
                            carry;

            // take a carry if sum of decimal places more than 9 and take only second digit of sum for current decimal
            // place
            if (resultCursor.val > 9) {
                resultCursor.val = resultCursor.val % 10;
                carry = 1;
            } else {
                carry = 0;
            }

            // add next node to result only if there is nothing to calculate (both lists reached the end and there is
            // no carry)
            if ((currentNode1 != null && currentNode1.next != null)
                    || (currentNode2 != null && currentNode2.next != null)
                    || carry == 1) {
                resultCursor.next = new ListNode();
            }
            resultCursor = resultCursor.next;
            currentNode1 = currentNode1 == null ? null : currentNode1.next;
            currentNode2 = currentNode2 == null ? null : currentNode2.next;
        }

        return resultHead;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // run test cases
        ListNode listNode1 =
                new ListNode(2,
                        new ListNode(4,
                                new ListNode(3)));
        ListNode listNode2 =
                new ListNode(2,
                        new ListNode(4,
                                new ListNode(3)));
        printList(solution.addTwoNumbers(listNode1, listNode2));

        listNode1 =
                new ListNode(0);
        listNode2 =
                new ListNode(0);
        printList(solution.addTwoNumbers(listNode1, listNode2));

        listNode1 =
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(9,
                                                        new ListNode(9,
                                                                new ListNode(9)))))));
        listNode2 =
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9))));
        printList(solution.addTwoNumbers(listNode1, listNode2));

    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.next != null ? node.val + " -> " : node.val +"\n");
            node = node.next;
        }
    }
}

class ListNode {
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