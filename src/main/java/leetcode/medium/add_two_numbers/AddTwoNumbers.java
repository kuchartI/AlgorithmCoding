package leetcode.medium.add_two_numbers;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode());
        ListNode l2 = new ListNode(9, new ListNode());
        l1.next = new ListNode(9, new ListNode());
        l1.next.next = new ListNode(9);
        l2.next = new ListNode(9, null);
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode();
        ListNode resultRef = resultNode;
        ListNode endList;
        byte remainder = 0;
        while (true) {
            if (l1 == null) {
                countRemainder(l2, resultNode, remainder);
                break;
            } else if (l2 == null) {
                countRemainder(l1, resultNode, remainder);
                break;
            } else {
                while (l1 != null && l2 != null) {
                    if (remainder + l2.val + l1.val > 9) {
                        resultNode.val = (remainder + l2.val + l1.val) % 10;
                        remainder = 1;
                    } else {
                        resultNode.val = remainder + l2.val + l1.val;
                        remainder = 0;
                    }
                    endList = remainder == 1 ? new ListNode(remainder) : null;
                    resultNode.next = l1.next == null && l2.next == null ? endList : new ListNode();
                    resultNode = resultNode.next;
                    l1 = l1.next;
                    l2 = l2.next;
                }
                if (l1 == null && l2 == null) {
                    break;
                }
            }
        }
        return resultRef;
    }

    private static void countRemainder(ListNode l1, ListNode resultNode, byte remainder) {
        ListNode endList;
        while (l1 != null) {
            if (remainder + l1.val > 9) {
                resultNode.val = (remainder + l1.val) % 10;
                remainder = 1;
            } else {
                resultNode.val = remainder + l1.val;
                remainder = 0;
            }
            endList = remainder == 1 ? new ListNode(remainder) : null;
            resultNode.next = l1.next == null ? endList : new ListNode();
            resultNode = resultNode.next;
            l1 = l1.next;
        }
    }
}

