package org.student.dao;

import java.sql.*;

/**
 * @Author: Mr.Zhou
 * @Date 2019/12/31
 * @Explain:
 */
public class BaseDao{
   protected Connection conn=null;
   protected PreparedStatement pstmt;
   protected ResultSet rs=null;
    public Connection getConn(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if (conn==null){
                conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/student","admin","1234");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }


    public int execudeUpdate(String sql,Object... param){
        int num=0;
        try {
            conn=getConn();
            pstmt=conn.prepareStatement(sql);
            if (param!=null){
                for (int i = 0; i <param.length ; i++) {
                    pstmt.setObject(i+1,param[i]);
                }
            }
            num=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
}
