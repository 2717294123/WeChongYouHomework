package StringOption;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Callable;

/*用Callable实现
原理与Runnable相同，不在赘述
 */
class LinePrint{
    static int a=1;
    static int b=1;
    static class mythread implements Callable<String>{
        String name;
        public mythread(String name){
            this.name=name;
        }
        public String call() throws Exception{
            while(a<120){
                if(b==1){
                    System.out.println(name+":"+a);
                    a++;
                    b=2;
                }
            }
            return "打印完毕";
        }
    }
    static class mythread2 implements Callable<String>{
        String name;
        public mythread2(String name){
            this.name=name;
        }
        public String call() throws Exception{
            while(a<121){
                if(b==2){
                    System.out.println(name+":"+a);
                    a++;
                    b=3;
                }
            }
            return "打印完毕";
        }
    }
    static class mythread3 implements Callable<String>{
        String name;
        public mythread3(String name){
            this.name=name;
        }
        public String call() throws Exception{
            while(a<121){
                if(b==3){
                    System.out.println(name+":"+a);
                    a++;
                    b=1;
                }
            }
            return "打印完毕";
        }
    }
    public static void main(String[] args) {
        mythread m1=new mythread("线程1");
        mythread2 m2=new mythread2("线程2");
        mythread3 m3=new mythread3("线程3");
        FutureTask<String> t1=new FutureTask<String>(m1);
        FutureTask<String> t2=new FutureTask<String>(m2);
        FutureTask<String> t3=new FutureTask<String>(m3);
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}
/*用Thread实现
引入了lock来控制线程，实例化3个对象锁，每一个线程由一个锁控制，然后在每个线程运行完后用signal选择下一个运行的线程即可，
但是有时候signal并不能选择到想要的那条线程，应该是Thread类的一个缺陷
*/
/*class LinePrint{
    static int a = 1;
    static Lock lock=new ReentrantLock();
    static Condition x=lock.newCondition();
    static Condition y=lock.newCondition();
    static Condition z=lock.newCondition();
    static class mythread1 extends Thread {
        private String name;
        public mythread1(String name) {
            this.name = name;
        }
        public void run() {
            while (true) {
                if(a<121){
                    lock.lock();
                    System.out.println(name+":"+a);
                    a++;
                    try{
                        y.signal();
                        x.await();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
                else{
                    System.exit(0);
                }
                }
            }
        }
    static class mythread2 extends Thread {
        private String name;
        public mythread2(String name) {
            this.name = name;
        }
        public void run() {
            while (true) {
                if(a<121){
                    lock.lock();
                    System.out.println(name+":"+a);
                    a++;
                    try{
                        z.signal();
                        y.await();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
                else{
                    System.exit(0);
                }
            }
        }
    }
    static class mythread3 extends Thread {
        private String name;
        public mythread3(String name) {
            this.name = name;
        }
        public void run() {
            while (true) {
                if(a<121){
                    lock.lock();
                    System.out.println(name+":"+a);
                    a++;
                    try{
                        x.signal();
                        z.await();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
                else{
                    System.exit(0);
                }
            }
        }
    }
    public static void main(String[] args) {
        mythread1 m1=new mythread1("线程1");
        mythread2 m2=new mythread2("线程2");
        mythread3 m3=new mythread3("线程3");
        m1.start();
        m2.start();
        m3.start();
    }
}*/
/*用Runnable创建
添加两个全局变量a，b，a为打印数字，b为选择数字，每用一个线程打印完后改变b值，再设置每个线程满足条件的b值，即可实现按顺序打印
 */
/*public class LinePrint {
    static int a=1;
    static int b=1;
    static class mythread1 implements Runnable{
        public void run(){
            while(true){
                if(a==120){
                    System.exit(0);
                }else{
                    if(b==1){
                        System.out.println("线程1:"+a);
                        a=a+1;
                        b=2;
                    }
                }
            }
        }
    }
    static class mythread2 implements Runnable{
        public void run(){
            while(true){
                if(a>120){
                    System.exit(0);
                }else{
                    if(b==2){
                        System.out.println("线程2:"+a);
                        a=a+1;
                        b=3;
                    }
                }
            }
        }
    }
    static class mythread3 implements Runnable{
        public void run(){
            while(true){
                if(a>120){
                    System.exit(0);
                }else{
                    if(b==3){
                        System.out.println("线程3:"+a);
                        a=a+1;
                        b=1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        mythread1 m1=new mythread1();
        mythread2 m2=new mythread2();
        mythread3 m3=new mythread3();
        Thread t1=new Thread(m1,"线程1");
        Thread t2=new Thread(m2,"线程2");
        Thread t3=new Thread(m3,"线程3");
        t1.start();
        t2.start();
        t3.start();
    }
}*/
