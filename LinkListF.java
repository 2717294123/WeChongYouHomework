package StringOption;
import java.util.Scanner;
public class LinkListF {
    Node head=null;
    public static void main(String[] args) {
        LinkListF l=new LinkListF();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.printnode();
        l.fanzhuan();
        l.printnode();
    }
    static class Node{
        int data=0;
        Node next=null;
        public Node(int data){
            this.data=data;
        }
    }
    public void add(int data){
        Node newnode=new Node(data);
        Node p=head;
        if(head==null)
        {
            head=newnode;
        }
        else{
            while(p.next!=null){
                p=p.next;
            }
            p.next=newnode;
            newnode.next=null;
        }
    }
    public void dele(int data){
        Node delone=head;
        if(head.data==data){
            delone=head.next;
            head.next=null;
            head=delone;
            return;
        }else{
            while(delone.next!=null){
                if(delone.next.data==data){
                    delone.next=delone.next.next;
                    System.out.println("删除成功!");
                    return;
                }
                delone=delone.next;
            }
        }
        System.out.println("未找到相关数据!");
    }
    public void ser(int data){
        Node serone=head;
        while(serone.next!=null){
            if(serone.data==data){
                System.out.println("找到了!");
                return;
            }
            serone=serone.next;
        }
        System.out.println("未找到相关数据!");
    }
    public void printnode(){
        Node p=head;
        while(p!=null){
            System.out.print(p.data+"->");
            p=p.next;
        }
        System.out.println("null");
    }
    public void fanzhuan(){
        Node p=head;
        Node pp=head;
        if(head.next==null){
            return;
        }else{
            p=p.next;
            if(p.next==null){
                p.next=head;
                head.next=null;
                head=p;
            }
            else{
                do{
                    Node temp_p=pp;
                    pp=p.next;
                    p.next=temp_p;
                    Node temp_pp=pp;
                    pp=p;
                    p=temp_pp;
                }while(p.next!=null);
                p.next=pp;
                head.next=null;
                head=p;
            }
        }
    }
}
