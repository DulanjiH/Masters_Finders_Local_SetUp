/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import POJOS.Coursedetails;
import POJOS.Distric;
import POJOS.Faculty;
import POJOS.University;
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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Dulanji
 */
public class SearchCourceDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pm= request.getParameter("parameter");
        String university = request.getParameter("university");
        String program = request.getParameter("programme");
        
        Session openSession = Hibernate.HibernateUtil.getSessionFactory().openSession();

        JSONObject jo = new JSONObject();
        JSONArray ja = new JSONArray();

        try {

            Criteria cc = openSession.createCriteria(Coursedetails.class);
            cc.add(Restrictions.eq("status", 1));

             if (university!= null && !university.isEmpty()) {
                cc.add(Restrictions.eq("unid", university));
            }

            if (program != null && !program.isEmpty()) {
                cc.add(Restrictions.eq("coursename", program));
            }

            List<Coursedetails> list = cc.list();

            for (Coursedetails dis : list) {
                
                JSONObject objs = new JSONObject();             
                objs.put("name", dis.getCoursename());
                objs.put("des", dis.getDescription());
                objs.put("pay", dis.getCoursepayment());
                objs.put("uni", dis.getFaculty().getUniversity().getUniname());
                objs.put("loc", dis.getFaculty().getUniversity().getRankworld());
                objs.put("link", dis.getCourseurl());

                ja.add(objs);
            }

            jo.put("status", "Ok");
            jo.put("data", ja);

        } catch (Exception e) {

            jo.put("status", "Error");
            jo.put("data", e.getMessage());
            e.printStackTrace();
        }
        openSession.close();
        response.getWriter().print(jo.toString());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
