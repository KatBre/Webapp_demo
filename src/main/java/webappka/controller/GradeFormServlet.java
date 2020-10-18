package webappka.controller;

import webappka.database.EntityDao;
import webappka.model.Grade;
import webappka.model.GradeSubject;
import webappka.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/grade/form")
public class GradeFormServlet extends HttpServlet {
    private final EntityDao<Grade> gradeEntityDao = new EntityDao<>();
    private final EntityDao<Student> studentEntityDao = new EntityDao<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentIdString = req.getParameter("studentId");
        if (studentIdString == null) {
            redirectToStudentList(req, resp);
            return;
        }
        Long studentId = Long.parseLong(studentIdString);
        Optional<Student> studentOptional = studentEntityDao.findById(studentId, Student.class);
        if (studentOptional.isPresent()) { // jeśli student, któremu mamy dodać ocenę istnieje
            GradeSubject[] subjects = GradeSubject.values();
            req.setAttribute("availableSubjects", subjects);
            req.setAttribute("studentIdAttribute", studentId);
            req.getRequestDispatcher("/grade_form.jsp").forward(req, resp);
        } else {
            redirectToStudentList(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String modifiedIdString = req.getParameter("modifiedGradeId");
        Long modifiedId = null;
        if (modifiedIdString != null && !modifiedIdString.isEmpty()) {
            modifiedId = Long.parseLong(modifiedIdString);
        }

        String studentIdString = req.getParameter("studentId");
        Long studentId = Long.parseLong(studentIdString);
        Optional<Student> studentOptional = studentEntityDao.findById(studentId, Student.class);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();

            Grade grade = new Grade();
            grade.setId(modifiedId);
            grade.setValue(Double.parseDouble(req.getParameter("value_field")));
            grade.setSubject(GradeSubject.valueOf(req.getParameter("subject_field")));
            grade.setStudent(student);

            gradeEntityDao.saveOrUpdate(grade);
        }
        resp.sendRedirect(req.getContextPath() + ("/student/details?id=") + studentId);
    }

    private void redirectToStudentList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(req.getContextPath() + "/students");
    }
}
