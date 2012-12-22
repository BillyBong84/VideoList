package javaguru.dao;


import java.util.Collection;
import java.sql.SQLException;

import javaguru.app.Discription;

public interface DiscriptionDao {
  public void addDiscription(Discription discription) throws SQLException;
  public void updateDiscription(Integer d_id, Discription discription) throws SQLException;
  public Discription getDiscriptionById(Integer d_id) throws SQLException;
  @SuppressWarnings("rawtypes")
public Collection getAllDiscriptions() throws SQLException;
  public void deleteDiscription(Discription discription) throws SQLException;
}
