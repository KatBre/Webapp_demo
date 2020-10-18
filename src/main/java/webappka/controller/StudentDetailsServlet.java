package webappka.controller;

import webappka.database.EntityDao;
import webappka.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/student/details")
public class StudentDetailsServlet extends HttpServlet {
    private final EntityDao<Student> studentEntityDao = new EntityDao<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentIdString = request.getParameter("id");
        if (studentIdString == null) {
            response.sendRedirect(request.getContextPath() + "/students");
            return;
        }
        Long studentId = Long.parseLong(studentIdString);
        Optional<Student> studentOptional = studentEntityDao.findById(studentId, Student.class);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            request.setAttribute("studentToDisplay", student);
            request.getRequestDispatcher("/student_details.jsp").forward(request, response);
        }
    }
}