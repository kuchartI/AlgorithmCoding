package leetcode.medium.add_two_numbers;

public class ListNode {
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

    @Override
    public String toString() {
        String res = String.valueOf(val);
        ListNode refList = this.next;
        while (refList != null) {
            res = res.concat(String.valueOf(refList.val));
            refList = refList.next;
        }
        return res;
    }
}
