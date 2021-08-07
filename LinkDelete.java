package StringOption;
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
class Solution{
    public ListNode deleteNode(ListNode head,int val){
        ListNode p=head;
        if (head==null){
            return null;
        }
        else if(head.val==val){
            head=p.next;
            p.next=null;
        }else{
            while(p.next.val!=val){
                p=p.next;
            }
            p.next=p.next.next;
        }
        return head;
    }
}
/*实现代码*/
public class LinkDelete {
    public static void main(String[] args) {
        Solution s=new Solution();
        ListNode head=new ListNode(4);
        ListNode two=new ListNode(5);
        ListNode three=new ListNode(1);
        ListNode last=new ListNode(9);
        head.next=two;
        two.next=three;
        three.next=last;
        head=s.deleteNode(head,5);
        print(head);
    }
    public static void print(ListNode head){
        ListNode p=head;
        if(head==null){
            return;
        }else if(head.next==null){
            System.out.println(p.val);
        }else{
            while(p.next!=null){
                System.out.println(p.val);
                p=p.next;
            }
            System.out.println(p.val);
        }
    }
}
