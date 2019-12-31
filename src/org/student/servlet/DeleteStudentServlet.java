package org.student.servlet;

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
@WebServlet(name = "DeleteStudentServlet", urlPatterns = "/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        //接受前端传入的学号
        String sno = request.getParameter("sno");
        //调用业务逻辑成代码
        StudentService studentService = new StudentServiceImpl();
        if (studentService.deleteStudent(sno)) {
            response.getWriter().print("删除成功!");
        } else {
            response.getWriter().print("删除失败!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
