public class PartitionList{
    public ListNode partition(ListNode a, int b) {
        if(a == null) return null;
        
        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        fakeHead1.next = a;
        
        ListNode curr = a;
        ListNode prev = fakeHead1;
        ListNode p2 = fakeHead2;
        
        while(curr != null){
            if(curr.val < x){
                curr = curr.next;
                prev = prev.next;
            }
            else{
                p2.next = curr;
                prev.next = curr.next;
                
                curr = prev.next;
                p2 = p2.next;
            }
        }
        p2.next = null;
        
        prev.next = fakeHead2.next;
        return fakeHead.next;
    }
    public static void main(String[] args){
    }
}
