package StringOption;
class myexception extends Exception{
    public myexception(String s) {
        super(s);
    }
}
public class ErrorThrow {
    public static void main(String[] args) {
        int i=-2147483648;
        try{
            if(i==2147483647||i==-2147483648){
                throw new myexception("数据溢出范围。");
            }
            i=decrease(i);
            System.out.println(i);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static int increase(int i){
        return i+1;
    }
    public static int decrease(int i){
        return i-1;
    }
}
