package javaguru.dao;


import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

import javaguru.app.HibernateUtil;
import javaguru.app.Discription;
import javaguru.dao.DiscriptionDao;

import javax.swing.*;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;


public class DiscriptionDaoImpl implements DiscriptionDao {

	  public void addDiscription(Discription discription) throws SQLException {
		    Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.save(discription);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on paste of Discription", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {

		        session.close();
		      }
		    }
		  }
	  
	  public void updateDiscription(Integer d_id, Discription discription) throws SQLException {
		    Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.update(discription);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on update of Movie", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		  }
	  
	  public Discription getDiscriptionById(Integer ID) throws SQLException {
		    Session session = null;
		    Discription discription = null;
		    try {
		      SessionFactory fly = HibernateUtil.getSessionFactory();
		      session = fly.openSession();
		      discription = (Discription) session.get(Discription.class, ID);
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on getMovieById", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return discription;
		  }
	  
	  @SuppressWarnings("rawtypes")
	public Collection getAllDiscriptions() throws SQLException {
		    Session session = null;
		    List discription = new ArrayList<Discription>();
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      discription = session.createCriteria(Discription.class).list();
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on getAllMovie", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return discription;
		  }
	  
	  public void deleteDiscription(Discription discription) throws SQLException {
		    Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.delete(discription);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on deleteMovie", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		  }

}
