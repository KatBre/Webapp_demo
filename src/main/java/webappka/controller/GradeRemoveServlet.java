package webappka.controller;

import webappka.database.EntityDao;
import webappka.model.Grade;
import webappka.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/grade/remove")
public class GradeRemoveServlet extends HttpServlet {
    private final EntityDao<Grade> gradeEntityDao = new EntityDao<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gradetIdString = req.getParameter("gradeId");
        Long gradeId = Long.parseLong(gradetIdString);
        Long studentId = null;
        Optional<Grade> gradeOptional = gradeEntityDao.findById(gradeId, Grade.class);
        if(gradeOptional.isPresent()) {
        Grade grade = gradeOptional.get();
        studentId = grade.getStudent().getId();
        gradeEntityDao.delete(grade);
        }
        if(studentId != null) {
            resp.sendRedirect(req.getContextPath() + "/student/details?id=" + studentId);
        } else {
            resp.sendRedirect(req.getContextPath() + "/students");
        }
    }

}
