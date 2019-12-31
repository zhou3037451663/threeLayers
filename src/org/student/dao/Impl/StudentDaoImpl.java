package org.student.dao.Impl;

import org.student.dao.BaseDao;
import org.student.dao.StudentDao;
import org.student.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr.Zhou
 * @Date 2019/12/31
 * @Explain:
 */
public class StudentDaoImpl  extends BaseDao implements StudentDao {
    //根据学号查学生
    public Student queryStudentBySno(String sno) {
        Student student=null;
        try {
            this.conn=getConn();
            this.pstmt=conn.prepareStatement("select * from student where `sno`=?");
            this.pstmt.setString(1,sno);
            this.rs=pstmt.executeQuery();
            if (rs.next()){
                student=new Student();
                student.setSno(rs.getString(1));
                student.setSname(rs.getString(2));
                student.setSage(rs.getInt(3));
                student.setSaddress(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return student;
    }

    //查询指定学号学生是否存在
    public boolean isExist(String sno) {
       return queryStudentBySno(sno)==null? false:true;
    }

    //添加学生
    public boolean add(Student student) {
        String sql="insert into student(`sno`,`sname`,`sage`,`saddress`) values(?,?,?,?)";
        Object[] param={student.getSno(),student.getSname(),student.getSage(),student.getSaddress()};
        return this.execudeUpdate(sql,param)>=1?true:false;
    }

    //删除学生
    public boolean deleteStudent(String sno) {
        String sql="DELETE FROM student WHERE sno=?";
        Object[] param={sno};
        return this.execudeUpdate(sql,param)>0?true:false;
    }


    //根据学号修改学生信息
    public boolean updateStudent(String sno, Student student) {
        String sql="update student SET sname=?,sage=?,saddress=? WHERE sno=?";
        Object[] param={student.getSname(),student.getSage(),student.getSaddress(),sno};
        return this.execudeUpdate(sql,param)>0?true:false;
    }

   //查询所有学生信息
    public List<Student> studentList() {
        List<Student> studentList=new ArrayList<Student>();
        try {
            this.conn=getConn();
            this.pstmt=conn.prepareStatement("select * from student");
            this.rs=pstmt.executeQuery();
            while (rs.next()) {
                String sno=rs.getString("sno");
                String sname=rs.getString("sname");
                int sage=rs.getInt("sage");
                String saddress=rs.getString("saddress");
                Student student=new Student(sno,sname,sage,saddress);
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }
}
