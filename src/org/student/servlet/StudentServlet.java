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
import java.io.PrintWriter;

/**
 * @Author: Mr.Zhou
 * @Date 2019/12/31
 * @Explain:
 */
@WebServlet(name = "StudentServlet", urlPatterns = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String sno = request.getParameter("sno");
        String sname = request.getParameter("sname");
        int sage = Integer.parseInt(request.getParameter("sage"));
        String saddress = request.getParameter("saddress");
        Student student = new Student(sno, sname, sage, saddress);
        StudentService studentService = new StudentServiceImpl();
        boolean boll = studentService.add(student);
        PrintWriter out = response.getWriter();
        if (boll) {
            out.print("添加成功");
        } else {
            out.print("添加失败!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
