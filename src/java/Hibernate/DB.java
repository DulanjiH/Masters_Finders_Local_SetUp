/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Dulanji
 */
public class DB {

    public interface TransactionProcess {

        public Object doInTransation(HttpServletRequest req, HttpServletResponse resp, Session session) throws Exception;
    }

    public Object executeNew(TransactionProcess r, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Object reObject = null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = s.beginTransaction();
        try {
            reObject = r.doInTransation(req, resp, s);
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            throw e;
        }
        s.flush();
        s.clear();
        s.close();
        return reObject;
    }
}
