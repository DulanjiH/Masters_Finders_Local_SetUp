/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import POJOS.Coursedetails;
import POJOS.Faculty;
import POJOS.University;
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
public class SaveCourceDetails extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cousrsename = request.getParameter("cname");
        String description = request.getParameter("description");
        String payment = request.getParameter("payment");
        String url = request.getParameter("url");
        String facltyid = request.getParameter("facid");
        String uniid = request.getParameter("unid");
 
        System.out.println("KKKKKKKKKKKKKKKkk "+facltyid);
        System.out.println("KKKKKKKKKKKKKKKkk "+description);
        try {

            Session openSession = Hibernate.HibernateUtil.getSessionFactory().openSession();
            Criteria cr = openSession.createCriteria(Coursedetails.class);
            List<Coursedetails> ul = cr.list();

            int ucount = 1;

            for (Coursedetails crs : ul) {
                ++ucount;
                System.out.println(crs.getUnid());
            }
            String cid = "CS00" + ucount;
            System.out.println(cid);

            User user = (User) request.getSession().getAttribute("u");
            User u = (User) openSession.get(User.class, user.getUserid());

            Coursedetails cs = new Coursedetails();
            cs.setCourseid(cid);
            cs.setCoursename(cousrsename);
            cs.setDescription(description);
            cs.setCoursepayment(Double.parseDouble(payment));
            cs.setCourseurl(url);
            cs.setUser(user);
            Faculty f = (Faculty) openSession.get(Faculty.class, facltyid);
            cs.setFaculty(f);
            University un= (University)openSession.get(University.class, uniid);
            cs.setUnid(uniid);
            cs.setStatus(1);

            openSession.save(cs);

            openSession.beginTransaction().commit();
            response.getWriter().write("Succsess");
            System.out.println("Successs");

        } catch (Exception ex) {
            response.getWriter().write("error");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cousrsename = "Masters in Economics (MEcon)";//request.getParameter("uname");
        String description = "Description 7"; //request.getParameter("email");
        String payment = "400000"; //request.getParameter("mobile");
        String url = "https://arts.cmb.ac.lk/index.php/masters-degree/";//request.getParameter("password");
        String facltyid = "FC002"; //request.getParameter("password");

        try {

            Session openSession = Hibernate.HibernateUtil.getSessionFactory().openSession();
            Criteria cr = openSession.createCriteria(Coursedetails.class);
            List<Coursedetails> ul = cr.list();

            int ucount = 1;

            for (Coursedetails crs : ul) {
                ++ucount;
            }
            String cid = "CS00" + ucount;
    

            User user = (User) request.getSession().getAttribute("u");
            User u = (User) openSession.get(User.class, user.getUserid());

            Coursedetails cs = new Coursedetails();
            cs.setCourseid(cid);
            cs.setCoursename(cousrsename);
            cs.setDescription(description);
            cs.setCoursepayment(Double.parseDouble(payment));
            cs.setCourseurl(url);
            cs.setUser(user);
            Faculty f = (Faculty) openSession.get(Faculty.class, facltyid);
            cs.setFaculty(f);
            cs.setStatus(1);

            openSession.save(cs);

            openSession.beginTransaction().commit();
            response.getWriter().write("Succsess");
            System.out.println("Successs");

        } catch (Exception ex) {
            response.getWriter().write("error");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
