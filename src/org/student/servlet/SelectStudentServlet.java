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
import java.util.List;

/**
 * @Author: Mr.Zhou
 * @Date 2019/12/31
 * @Explain:
 */
@WebServlet(name = "SelectStudentServlet", urlPatterns = "/SelectStudentServlet")
public class SelectStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        StudentService studentService = new StudentServiceImpl();
        List<Student> list = studentService.studentList();
        for (Student li : list) {
            System.out.println("学号:" + li.getSno() + "\t姓名:" + li.getSname()
                    + "\t年龄:" + li.getSage() + "\t住址:" + li.getSaddress());
            System.out.println();
        }
        request.setAttribute("list",list);
        request.getRequestDispatcher("index2.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
