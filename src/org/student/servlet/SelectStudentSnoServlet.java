package org.student.servlet;

import org.student.entity.Student;
import org.student.service.Impl.StudentServiceImpl;
import org.student.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Mr.Zhou
 * @Date 2019/12/31
 * @Explain:
 */
@WebServlet(name = "SelectStudentSnoServlet",urlPatterns = "/SelectStudentSnoServlet")
public class SelectStudentSnoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setCharacterEncoding("utf-8");
    String sno=request.getParameter("sno");
        StudentService studentService=new StudentServiceImpl();
        Student student = studentService.queryStudentBySno(sno);
        System.out.println("学号:"+student.getSno()+"\t姓名:"+student.getSname()
                +"\t年龄:"+student.getSage()+"\t住址:"+student.getSaddress());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }
}
