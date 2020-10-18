package webappka.controller;


import webappka.database.EntityDao;
import webappka.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/student/form")
public class StudentFormServlet extends HttpServlet {
    private final EntityDao<Student> studentEntityDao = new EntityDao<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // metoda ma za zadanie przesłać użytkownikowi treść formularza
        req.getRequestDispatcher("/student_form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String modifiedIdString = req.getParameter("modifiedStudentId");
        Long modifiedId = null;
        if (modifiedIdString != null && !modifiedIdString.isEmpty()) {
            modifiedId = Long.parseLong(modifiedIdString);
        }
        Student student = new Student();
        student.setId(modifiedId);
        student.setFirstName(req.getParameter("first_name_field"));
        student.setLastName(req.getParameter("last_name_field"));
        student.setBirthDate(LocalDate.parse(req.getParameter("date_of_birth_field")));
        student.setGraduated(req.getParameter("graduated_field") != null); // on
        student.setHomeDistance(Double.parseDouble(req.getParameter("distance_field")));
        studentEntityDao.saveOrUpdate(student);
        resp.sendRedirect(req.getContextPath() + "/students");
    }
}
