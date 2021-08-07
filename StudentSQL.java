package lan.test;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class StudentSQL {
    public static final String DBDRIVER="com.mysql.cj.jdbc.Driver";
    public static final String DBURL="jdbc:mysql://localhost:3306/students";
    public static final String DBUSER="root";
    public static final String DBPASS="1234567890";
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        do{
            menu();
            int op=sc.nextInt();
            switch(op){
                case 1:
                        addinfo();
                    break;
                case 2:
                        delete();
                    break;
                case 3:
                        correct();
                    break;
                case 4:
                        find();
                    break;
                case 5:
                        return_unpassed();
                    break;
                case 6:
                        returnall();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("输入指令有误请重新输入!");
            }
        }while(true);
    }
    public static void menu(){
        System.out.println("1.添加学生信息       2.删除学生信息\n" +
                           "3.修改学生信息       4.查找学生信息\n" +
                           "5.统计不及格学生信息  6.查看所有学生信息\n"+
                           "            7.退出                 ");
    }
    public static void addinfo() throws Exception{
        Connection conn=null;
        Statement stmt=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学号:");
        int id=sc.nextInt();
        System.out.println("请输入姓名");
        String name=sc.next();
        System.out.println("请输入语文成绩");
        float literature=sc.nextFloat();
        System.out.println("请输入数学成绩");
        float math=sc.nextFloat();
        System.out.println("请输入英语成绩");
        float english=sc.nextFloat();
        String sql="INSERT INTO info(id,name,Literature,Math,English,Total)"
                +"VALUES("+id+",'"+name+"',"+literature+","+math+","+english+","+(literature+math+english)+")";
        Class.forName(DBDRIVER);
        conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        stmt=conn.createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
        conn.close();
    }
    public static void delete() throws Exception{
        Connection conn=null;
        Statement stmt=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("按照学号或者姓名删除 1.学号 2.姓名");
        boolean f=false;
        int id=-1;
        String sql=null,name=null;
        do{
            int op=sc.nextInt();
            switch(op){
                case 1:
                    System.out.println("输入删除的id;");
                    id=sc.nextInt();
                    sql="DELETE FROM info where id="+id;
                    break;
                case 2:
                    System.out.println("输入删除的姓名:");
                    name=sc.next();
                    sql="DELETE FROM info where name='"+name+"'";
                    break;
                default:
                    f=true;
                    break;
            }
        }while(f);
        Class.forName(DBDRIVER);
        conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        stmt=conn.createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
        conn.close();
    }
    public static void correct() throws Exception{
        Connection conn=null;
        Statement stmt=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("选择需要修改成员的姓名");
        String name=sc.next(),sql=null;
        boolean f=false;
        do{
            System.out.println("选择修改的选项:1.学号(id) 2.姓名 3.语文 4.数学 5.英语");
            int op=sc.nextInt();
            switch (op){
                case 1:
                    System.out.println("输入修改后学号");
                    sql="UPDATE info SET id='"+sc.nextInt()+"' WHERE name='"+name+"'";
                    break;
                case 2:
                    System.out.println("输入修改后姓名");
                    sql="UPDATE info SET name='"+sc.next()+"' WHERE name='"+name+"'";
                    break;
                case 3:
                    System.out.println("输入修改后的语文成绩");
                    sql="UPDATE info SET Literature='"+sc.nextInt()+"' WHERE name='"+name+"'";
                    break;
                case 4:
                    System.out.println("输入修改后的数学成绩");
                    sql="UPDATE info SET Math='"+sc.nextInt()+"' WHERE name='"+name+"'";
                    break;
                case 5:
                    System.out.println("输入修改后的英语成绩");
                    sql="UPDATE info SET English='"+sc.nextInt()+"' WHERE name='"+name+"'";
                    break;
                default:
                    System.out.println();
                    f=true;
            }
        }while (f);
        String sql2="UPDATE info SET Total=(Literature+Math+English)";
        Class.forName(DBDRIVER);
        conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        stmt=conn.createStatement();
        stmt.executeUpdate(sql);
        stmt.executeUpdate(sql2);
        stmt.close();
        conn.close();
    }
    public static void find() throws Exception{
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入需要查找学生的姓名:");
        String name=sc.next();
        String sql="SELECT*FROM info WHERE name='"+name+"'";
        Class.forName(DBDRIVER);
        conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        stmt=conn.createStatement();
        rs=stmt.executeQuery(sql);
        rs.next();
        int id=rs.getInt("id");
        int literature=rs.getInt("Literature");
        int math=rs.getInt("Math");
        int english=rs.getInt("English");
        int total=rs.getInt("Total");
        System.out.println("学号:"+id+" ,姓名:"+name+
                " ,语文:"+literature+" ,数学:"+math+" ,英语:"+english+" ,总分:"+total);
        rs.close();
        stmt.close();
        conn.close();
    }
    public static void return_unpassed() throws Exception{
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        String sql="SELECT*FROM info WHERE Total<"+180+"";
        Class.forName(DBDRIVER);
        conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        stmt=conn.createStatement();
        rs=stmt.executeQuery(sql);
        while(rs.next()){
            int id=rs.getInt("id");
            String name=rs.getString("name");
            int literature=rs.getInt("Literature");
            int math=rs.getInt("Math");
            int english=rs.getInt("English");
            int total=rs.getInt("Total");
            System.out.println("学号:"+id+" ,姓名:"+name+
                    " ,语文:"+literature+" ,数学:"+math+" ,英语:"+english+" ,总分:"+total);
            System.out.println("------------------------------------------------------");
        }
        rs.close();
        stmt.close();
        conn.close();
    }
    public static void returnall() throws Exception{
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        String sql="SELECT*FROM info";
        Class.forName(DBDRIVER);
        conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        stmt=conn.createStatement();
        rs=stmt.executeQuery(sql);
        while(rs.next()){
            int id=rs.getInt("id");
            String name=rs.getString("name");
            int literature=rs.getInt("Literature");
            int math=rs.getInt("Math");
            int english=rs.getInt("English");
            int total=rs.getInt("Total");
            System.out.println("学号:"+id+" ,姓名:"+name+
                    " ,语文:"+literature+" ,数学:"+math+" ,英语:"+english+" ,总分:"+total);
            System.out.println("------------------------------------------------------");
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}
