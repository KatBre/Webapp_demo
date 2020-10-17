package webappka.controller;


import webappka.database.EntityDao;
import webappka.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/students") //musi być slash, bo nie zadziała i musi być adnotacja, bo też nie zadziała
public class StudentListServlet extends HttpServlet {
    private final EntityDao<Student> studentEntityDao = new EntityDao<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //przetwarzamy zapytanie

        // pobieramy z bazy liste studentó, ładujemy je do atrybutó (żeby wyświetlić w html/jsp)
        List<Student> listOfStudents = studentEntityDao.findAll(Student.class);
        req.setAttribute("students", listOfStudents);

        // przekazujemy do request dispatchera, żeby dla nas przetworzył stronę "student_list" i zwrócił ja do użytkownika
        req.getRequestDispatcher("/student_list.jsp").forward(req, resp);
    }
}
