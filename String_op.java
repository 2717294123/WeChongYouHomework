package Stringop;


class Stringop{
    String str;
    public Stringop(){}
    public int isnum(){
        for(int i=0;i<str.length();i++){
            int chr=str.charAt(i);
            if(chr<48||chr>57) {
                return 0;
            }
        }
        return 1;
    }

    public int isbig(){
        for(int i=0;i<str.length();i++){
            int chr=str.charAt(i);
            if(chr<65||chr>90){
                return 0;
            }
        }
        return 1;
    }

    public int issmall(){
        for(int i=0;i<str.length();i++){
            int chr=str.charAt(i);
            if(chr<97||chr>122){
                return 0;
            }
        }
        return 1;
    }

    public String iseng(){
        for(int i=0;i<str.length();i++) {
            int chr = str.charAt(i);
            if ((chr >= 65 && chr <= 90) || (chr >= 97 && chr <= 122)) {
            } else {
                return "0";
            }
        }
        return str.toUpperCase();
    }
    public void arrange(){
        char c[]=str.toCharArray();
        for(int i=0;i<c.length;i++){
            for(int j=1;j<c.length-i;j++){
                int chr1=c[j-1],chr2=c[j];
                if(chr1>chr2){
                    char temp=c[j-1];
                    c[j-1]=c[j];
                    c[j]=temp;
                }
            }
        }
        for(int i=0;i<c.length;i++){
            System.out.print(c[i]+" ");
        }
        System.out.println("");
    }
}
public class String_op {
    public static void main(String[] args) {
        Stringop op=new Stringop();
        String str="acbdw,1269547,AASIDX,AIUydjs,12sjaA,3819247,ausSHSzio,IUFISsi";
        String str1[]=str.split(",");
        for(int i=0;i<str1.length;i++){
            op.str=str1[i];
            if(op.isnum()==1){
                System.out.print("全为数字");
            }
            else if(op.isbig()==1){
                System.out.print("全为大写字母");
            }
            else if(op.issmall()==1){
                System.out.print("全为小写字母");
            }
            else{
                System.out.print("混合品种");
            }
            System.out.println("");
        }
        for(int i=0;i<str1.length;i++){
            op.str=str1[i];
            if(!"0".equals(op.iseng())){
                System.out.println("全部转大写后的英文字符串："+op.iseng());
            }
        }
        for(int i=0;i<str1.length;i++){
            op.str=str1[i];
            if(op.isnum()==1||!"0".equals(op.iseng())){
                op.arrange();
            }
        }
    }
}
