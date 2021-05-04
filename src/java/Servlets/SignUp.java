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
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dulanji
 */
public class SignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");

        System.out.println(uname);
        try {

            Session openSession = Hibernate.HibernateUtil.getSessionFactory().openSession();
            Criteria cr = openSession.createCriteria(User.class);

         

            List<User> ul = cr.list();

            int ucount = 1;

            for (User crs : ul) {
                ++ucount;
                System.out.println(" User "+ucount);
            }
            String uid = "US00" + ucount;
                      
                System.out.println(uid);
            User uu = new User();
            uu.setUserid(uid);
            uu.setName(uname);
            uu.setMobile(mobile);
            uu.setEmail(email);
            uu.setPassword(password);
            uu.setStatus(1);

            openSession.save(uu);

            openSession.beginTransaction().commit();
            response.getWriter().write("Succsess");
            System.out.println("Successs");
            

        } catch (Exception ex) {
            response.getWriter().write("error");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession ss = (HttpSession) request.getSession();
        ss.invalidate();
        System.out.println("ok session");
    }
}
