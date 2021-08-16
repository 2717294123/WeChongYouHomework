package com.example.serlvet_jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class mysqlop {
    public static final String DBDRIVER="com.mysql.cj.jdbc.Driver";
    public static final String DBURL="jdbc:mysql://localhost:3306/user_id";
    public static final String DBUSER="root";
    public static final String DBPASS = "1234567890";
    public String research(int search_id) throws Exception{
        String sql="select * from info where id=?";
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        Class.forName(DBDRIVER);
        conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        pstmt=conn.prepareStatement(sql);
        pstmt.setInt(1,search_id);
        rs=pstmt.executeQuery();
        int id=-1;
        String name=null;
        //结果集需要通过循环读取内容
        while(rs.next()){
            id=rs.getInt(1);
            name=rs.getString(2);
        }
        rs.close();
        pstmt.close();
        conn.close();
        if(id>0&&name!=null){
            return "{id:"+id+",name:"+name+"}";
        }else{
            return "user donot exists\n"+"{}";
        }
    }
}
