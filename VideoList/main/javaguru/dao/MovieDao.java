package javaguru.dao;


import java.util.Collection;
import java.sql.SQLException;

import javaguru.app.Movie;

public interface MovieDao {
  public void addMovie(Movie movie) throws SQLException;
  public void updateMovie(Integer ID, Movie movie) throws SQLException;
  public Movie getMovieById(Integer ID) throws SQLException;
  @SuppressWarnings("rawtypes")
public Collection getAllMovies() throws SQLException;
  public void deleteMovie(Movie movie) throws SQLException;
}
