package StringOption;
import java.util.Scanner;
class Stack{
    private int maxSize; // 栈的大小
    private int[] stack; // 数组，数组模拟栈，数据就放在该数组
    private int top = -1;// top表示栈顶，初始化为-1

    //构造器
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //增加一个方法，可以返回当前栈顶的值, 但是不是真正的pop
    public int peek() {
        return stack[top];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }
    //栈空
    public boolean isEmpty() {
        return top == -1;
    }
    //入栈-push
    public void push(int value) {
        //先判断栈是否满
        if(isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }
    //出栈-pop, 将栈顶的数据返回
    public int pop() {
        //先判断栈是否空
        if(isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据~");
        }
        int value = stack[top];
        top--;
        return value;
    }
    //显示栈的情况[遍历栈]， 遍历时，需要从栈顶开始显示数据
    public void list() {
        if(isEmpty()) {
            System.out.println("栈空，没有数据~~");
            return;
        }
        //需要从栈顶开始显示数据
        for(int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
    public void find(int a){
        if(isEmpty()){
            System.out.println("栈空，没有数据~~");
        }
        else{
            for(int i=top;i>=0;i--){
                if(a==stack[i]){
                    System.out.println("找到了，位于"+i);
                }
            }
            System.out.println("栈中不存在该元素");
        }
    }
}
public class StackUse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num= sc.nextInt();
        System.out.println(num+"二进制数:"+toerjin(num));
        System.out.println(num+"八进制数:"+tobajin(num));
        System.out.println(num+"十六进制数:"+toshiliujin(num));
    }
    static public String toerjin(int i){
        Stack stack=new Stack(20);
        String result="";
        while(i>0){
            int x=i%2;
            i=i/2;
            stack.push(x);
        }
        while(!stack.isEmpty()){
            result=result+stack.pop();
        }
        return result;
    }
    static public String tobajin(int i){
        Stack stack=new Stack(20);
        String result="";
        while(i>0){
            int x=i%8;
            i=i/8;
            stack.push(x);
        }
        while(!stack.isEmpty()){
            result=result+stack.pop();
        }
        return result;
    }
    static public String toshiliujin(int i){
        Stack stack=new Stack(20);
        String result="";
        while(i>0){
            int x=i%16;
            i=i/16;
            stack.push(x);
        }
        while(!stack.isEmpty()){
            int s=stack.pop();
            if(s>=0&&s<=9){
                result=result+s;
            }
            else{
                if(s==10){
                    result+="A";
                }
                if(s==11){
                    result+="B";
                }
                if(s==12){
                    result+="C";
                }
                if(s==13){
                    result+="D";
                }
                if(s==14){
                    result+="E";
                }
                if(s==15){
                    result+="F";
                }
            }
        }
        return result;
    }
}
