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

@WebServlet("/student/remove")
public class StudentRemoveServlet extends HttpServlet {
    private final EntityDao<Student> studentEntityDao = new EntityDao<Student>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentIdString = req.getParameter("stId");
        if (studentIdString == null) {
            resp.sendRedirect(req.getContextPath() + "/students");
            return;
        }
        Long studentId = Long.parseLong(studentIdString);
        Optional<Student> studentOptional = studentEntityDao.findById(studentId, Student.class);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            studentEntityDao.delete(student);
        }
        resp.sendRedirect(req.getContextPath() + ("/students"));
    }
}
