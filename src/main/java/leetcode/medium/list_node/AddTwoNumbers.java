package leetcode.medium.list_node;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNodeJava l1 = new ListNodeJava(9, new ListNodeJava());
        ListNodeJava l2 = new ListNodeJava(9, new ListNodeJava());
        l1.next = new ListNodeJava(9, new ListNodeJava());
        l1.next.next = new ListNodeJava(9);
        l2.next = new ListNodeJava(9, null);
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNodeJava addTwoNumbers(ListNodeJava l1, ListNodeJava l2) {
        ListNodeJava resultNode = new ListNodeJava();
        ListNodeJava resultRef = resultNode;
        ListNodeJava endList;
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
                    endList = remainder == 1 ? new ListNodeJava(remainder) : null;
                    resultNode.next = l1.next == null && l2.next == null ? endList : new ListNodeJava();
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

    private static void countRemainder(ListNodeJava l1, ListNodeJava resultNode, byte remainder) {
        ListNodeJava endList;
        while (l1 != null) {
            if (remainder + l1.val > 9) {
                resultNode.val = (remainder + l1.val) % 10;
                remainder = 1;
            } else {
                resultNode.val = remainder + l1.val;
                remainder = 0;
            }
            endList = remainder == 1 ? new ListNodeJava(remainder) : null;
            resultNode.next = l1.next == null ? endList : new ListNodeJava();
            resultNode = resultNode.next;
            l1 = l1.next;
        }
    }
}

