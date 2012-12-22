package javaguru.dao;


import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

import javaguru.app.HibernateUtil;
import javaguru.app.Movie;
import javaguru.dao.MovieDao;

import javax.swing.*;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;


public class MovieDaoImpl implements MovieDao {

	  public void addMovie(Movie movie) throws SQLException {
		    Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.save(movie);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on paste of Movie", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {

		        session.close();
		      }
		    }
		  }
	  
	  public void updateMovie(Integer ID, Movie movie) throws SQLException {
		    Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.update(movie);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on update of Movie", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		  }
	  
	  public Movie getMovieById(Integer ID) throws SQLException {
		    Session session = null;
		    Movie movie = null;
		    try {
		      SessionFactory fly = HibernateUtil.getSessionFactory();
		      session = fly.openSession();
		      movie = (Movie) session.get(Movie.class, ID);
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on getMovieById", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return movie;
		  }
	  
	  @SuppressWarnings("rawtypes")
	public Collection getAllMovies() throws SQLException {
		    Session session = null;
		    List movies = new ArrayList<Movie>();
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      movies = session.createCriteria(Movie.class).list();
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on getAllMovie", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return movies;
		  }
	  
	  public void deleteMovie(Movie movie) throws SQLException {
		    Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.delete(movie);
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
