package time;

import java.util.Date;
import java.text.SimpleDateFormat;
public class Clock {
    public static void main(String[] args) {
        CLOCK my_clock=new CLOCK();
        my_clock.Printtime();
    }
    public static class CLOCK{
        public String DatetoString(){
            Date date=new Date();
            SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String datestring=formatter.format(date);
            return datestring;
        }
        public void Printtime(){
            while(true){
                System.out.println("现在是北京时间 "+DatetoString());
                try { Thread.sleep(1000); ;
                } catch (InterruptedException ie){}
            }
        }
    }
}
