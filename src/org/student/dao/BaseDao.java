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

    /**
     * 增删改的方法
     * @param sql
     * @param param
     * @return
     */
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

    public ResultSet execuSelect(String sql,Object... param){
        try {
            conn=getConn();
           pstmt=conn.prepareStatement(sql);
           if (param!=null){
               for (int i = 0; i <param.length ; i++) {
                   pstmt.setObject(i+1,param[i]);
               }
           }
            rs=pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 查询总数的方法
     * @param sql
     * @return
     */
    public int getStudentCount(String sql){
        int count=-1;
        try {
            this.conn=this.getConn();
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            if (rs.next()){
                count=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
