package org.student.service;

import org.student.entity.Student;

import java.util.List;

/**
 * @Author: Mr.Zhou
 * @Date 2019/12/31
 * @Explain:
 */
public interface StudentService {
    //根据学号查找学生
    Student queryStudentBySno(String sno);

    //根据学号判断是否存在指定学号学生
    boolean isExist(String sno);

    //添加学生
    boolean add(Student student);

    //根据学号删除学生
    boolean deleteStudent(String sno);

    //根据学号修改学生信息
    boolean updateStudent(String sno, Student student);

    //查询全部学生信息
    List<Student> studentList();

    //查询学生总数
    int StudentCount();

    //分页查询 currentPage(当前页)  pageSize(页面大小：每页多少条)
    List<Student> queryStudentsByPage(int currentPage, int pageSize);
}
