package leetcode.medium.list_node;

public class ListNodeJava {
    int val;
    ListNodeJava next;

    ListNodeJava() {
    }

    ListNodeJava(int val) {
        this.val = val;
    }

    ListNodeJava(int val, ListNodeJava next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        String res = String.valueOf(val);
        ListNodeJava refList = this.next;
        while (refList != null) {
            res = res.concat(String.valueOf(refList.val));
            refList = refList.next;
        }
        return res;
    }
}
