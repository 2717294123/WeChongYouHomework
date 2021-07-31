package StringOption;
import java.util.ArrayList;
import java.util.Scanner;
class solution{
    public ArrayList<String> uncommonFromSentences(String s1, String s2) {
        String[] od_s1=s1.split(" ");
        String[] od_s2=s2.split(" ");
        ArrayList<String> arlist=new ArrayList<String>();
        for(int i=0;i<od_s1.length;i++){
            if(count(od_s1[i],od_s1)+count(od_s1[i],od_s2)==1){
                arlist.add(od_s1[i]);
            }
        }
        for(int i=0;i< od_s2.length;i++){
            if(count(od_s2[i],od_s2)+count(od_s2[i],od_s1)==1){
                arlist.add(od_s2[i]);
            }
        }
        return arlist;
    }
    public int count(String s1,String[] s2){
        int time=0;
        for(int i=0;i< s2.length;i++){
            if(s2[i].equals(s1)){
                time++;
            }
        }
        return time;
    }
}
public class WordFreq {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        solution sl=new solution();
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        ArrayList<String> result=sl.uncommonFromSentences(s1,s2);
        System.out.println(result);
    }

}
