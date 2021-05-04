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
public class LoadDetails extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoadDetails</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoadDetails at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String type = request.getParameter("type");
        String universirycd = request.getParameter("universirycd");
        String un = request.getParameter("un");

        Session openSession = Hibernate.HibernateUtil.getSessionFactory().openSession();
        JSONObject jo = new JSONObject();
        JSONArray ja = new JSONArray();
        try {
            if (type.equals("faculty")) {
                Criteria cc = openSession.createCriteria(Faculty.class);

                List<Faculty> list = cc.list();
                for (Faculty fac : list) {

                    JSONObject objs = new JSONObject();
                    if (fac.getUniversity().getUnid().equals(universirycd)) {
                        objs.put("facid", fac.getFacid());
                        objs.put("facname", fac.getFacname());
                        ja.add(objs);

                    }
                }

            } else if (type.equals("university")) {
                Criteria cc1 = openSession.createCriteria(University.class);
                cc1.add(Restrictions.eq("status", 1));
                List<University> list1 = cc1.list();
                for (University uni : list1) {

                    JSONObject objs = new JSONObject();

                    objs.put("unid", uni.getUnid());
                    objs.put("uniname", uni.getUniname());

                    ja.add(objs);
                }
                
            } else {
                Criteria cc2 = openSession.createCriteria(Coursedetails.class);
                cc2.add(Restrictions.eq("status", 1));

                List<Coursedetails> list1 = cc2.list();

                for (Coursedetails pr : list1) {
                    JSONObject objs = new JSONObject();

                    if (pr.getFaculty().getUniversity().getUnid().equals(un)) {

                        objs.put("prid", pr.getCourseid());
                        objs.put("prname", pr.getCoursename());
                        ja.add(objs);
                    }
                }
            }

            jo.put("status", "Ok");
            jo.put("data", ja);

        } catch (Exception e) {
            jo.put("status", "Error");
            jo.put("data", e.getMessage());
            e.printStackTrace();
        }

        openSession.close();

        response.getWriter()
                .print(jo.toString());

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
