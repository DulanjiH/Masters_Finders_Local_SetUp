/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import POJOS.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dulanji
 */
public class SignIn extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            System.out.println(email);
            System.out.println(password);

            Session os = Hibernate.HibernateUtil.getSessionFactory().openSession();
            Criteria cr = os.createCriteria(User.class);
            cr.add(Restrictions.eq("status", 1));
            List<User> ul = cr.list();

            boolean b = false;

            for (User user : ul) {
                System.out.println(user.getEmail());
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    b = true;
                    request.getSession().setAttribute("u", user);
                    response.getWriter().write("Succsess");
                    response.sendRedirect("Succsess");
                    System.out.println("success");
                }
            }
            if (!b) {
                System.out.println("error");
                response.sendRedirect("SignIn.jsp?msg=Invalid Details");
            }
        } catch (Exception e) {
            response.sendRedirect("SignIn.jsp?msg=Invalied Details");
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = "pd.manamperi@gmail.com";//request.getParameter("Email");
            String password = "pdmana123";//request.getParameter("Password");

            System.out.println(email);
            System.out.println(password);

            Session os = Hibernate.HibernateUtil.getSessionFactory().openSession();
            Criteria cr = os.createCriteria(User.class);
            cr.add(Restrictions.eq("status", 1));
            List<User> ul = cr.list();

            boolean b = false;

            for (User user : ul) {

                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    b = true;
                    request.getSession().setAttribute("u", user);
                    response.getWriter().write("Succsess");
                    System.out.println("success");
                }
            }
            if (!b) {
                System.out.println("error");
                response.sendRedirect("SignIn.jsp?msg=Invalied Details");
            }
        } catch (Exception e) {
            response.sendRedirect("SignIn.jsp?msg=Invalied Details");
            e.printStackTrace();
        }
    }
}
