package StringOption;

import java.util.Scanner;
class Queue{
    int rear=0,front=0;
    char[] array=new char[100];
    /*入队*/
    public void add(char data){
        if(isfull()){
            System.out.println("队列已满!");
        }else{
            array[rear]=data;
            rear++;
        }
    }
    /*出队*/
    public void delete(){
        if(isempty()){
            System.out.println("队列为空!");
        }else{
            front++;
        }
    }
    /*判断队列是否已满*/
    public boolean isfull(){
        return rear==100;
    }
    /*判断队列是否为空*/
    public boolean isempty(){
        return front==rear;
    }
    /*计算出现的次数*/
    public int count(char a){
        int time=0;
        for(int i=front;i<=rear;i++){
            if(array[i]==a){
                time++;
            }
        }
        return time;
    }
}
class Solution2{
    public int firstUniqChar(String s){
        int pos = -1;
        Queue q=new Queue();
        char[] s1=s.toCharArray();
        for(int i=0;i<s1.length;i++){
            q.add(s1[i]);
        }
        for(int i=0;i<s1.length;i++){
            if(q.count(s1[i])==1){
                pos=i;
                break;
            }
        }
        return pos;
    }
}
public class QueueOp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一行字符串:");
        String s=sc.next();
        char[] s1=s.toCharArray();
        Solution2 way=new Solution2();
        int pos=way.firstUniqChar(s);
        if(pos==-1){
            System.out.println(" ");
        }else{
            System.out.println(s1[pos]);
        }
    }
}
