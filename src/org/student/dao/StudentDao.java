package org.student.dao;

import org.student.entity.Student;

import java.util.List;


/**
 * @Author: Mr.Zhou
 * @Date 2019/12/31
 * @Explain:
 */
public interface StudentDao {
    //根据学号查询学生
    Student queryStudentBySno(String sno);

    //根据学号判断是否存在指定学生
    boolean isExist(String sno);

    //添加学生
    boolean add(Student student);

    //根据学号删除学生
    boolean deleteStudent(String sno);

    //根据学号修改学生信息
    boolean updateStudent(String sno, Student student);

    //查询全部学生信息
    List<Student> studentList();
}
