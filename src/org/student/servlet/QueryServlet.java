package org.student.servlet;

import org.student.entity.Page;
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
 * @Date 2020/1/3
 * @Explain:
 */
@WebServlet(name = "QueryServlet", urlPatterns = "/QueryServlet")
public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService = new StudentServiceImpl();
        Page page = new Page();
        int totalCount = studentService.StudentCount();//取得总数据数
        String current = request.getParameter("currentPage");
        if (current == null) {
            current = "0";
        }
        int currentPage = Integer.parseInt(current);
        page.setTotalCount(totalCount);//总数据数
        int pageSize = 3;//页面大小
        page.setCurrentPage(currentPage);//当前页
        page.setPageSize(pageSize);//页面大小

        List<Student> studentList = studentService.queryStudentsByPage(currentPage, pageSize);
        page.setStudents(studentList);
        for (Student student : studentList) {
            System.out.println(student.getSno() + "-" + student.getSname() + "-" + student.getSage() + "-" + student.getSaddress());
        }
        request.setAttribute("p", page);
        request.getRequestDispatcher("index2.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
