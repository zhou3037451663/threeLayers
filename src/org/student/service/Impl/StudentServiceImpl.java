package org.student.service.Impl;

import org.student.dao.BaseDao;
import org.student.dao.Impl.StudentDaoImpl;
import org.student.dao.StudentDao;
import org.student.entity.Student;
import org.student.service.StudentService;

import java.util.List;

/**
 * @Author: Mr.Zhou
 * @Date 2019/12/31
 * @Explain:
 */
public class StudentServiceImpl extends BaseDao implements StudentService {
    StudentDao studentDao=new StudentDaoImpl();
    //根据学号查询学生信息
    public Student queryStudentBySno(String sno) {
        return studentDao.queryStudentBySno(sno);
    }

    @Override
    public boolean isExist(String sno) {
        return false;
    }

    @Override
    public boolean add(Student student) {
        if (!studentDao.isExist(student.getSno())){
            studentDao.add(student);
            return true;
        }else{
            System.out.println("已存在此学号的学生");
            return false;
        }
    }

    //根据学号删除学生
    public boolean deleteStudent(String sno) {
        if (studentDao.isExist(sno)){
            return studentDao.deleteStudent(sno);
        }else{
            System.out.println("删除失败!");
            return false;
        }

    }

    //根据学号修改学生信息
    public boolean updateStudent(String sno, Student student) {
        if (studentDao.isExist(sno)){
            return studentDao.updateStudent(sno,student);
        }
        return false;
    }

   //查询所有学生信息
    public List<Student> studentList() {
       return studentDao.studentList();
    }
}
