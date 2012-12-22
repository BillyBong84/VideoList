package javaguru.dao;

public class Factory {
		  
		  private static MovieDao movieDao = null;
		  private static DiscriptionDao discriptionDao = null;
		  private static Factory instance = null;

		  public static synchronized Factory getInstance(){
		    if (instance == null){
		      instance = new Factory();
		    }
		    return instance;
		  }

		  public MovieDao getMovieDao(){
		    if (movieDao == null){
		    	movieDao = new MovieDaoImpl();
		    }
		    return movieDao;
		  }
		  public DiscriptionDao getDiscriptionDao(){
			    if (discriptionDao == null){
			    	discriptionDao = new DiscriptionDaoImpl();
		}
			 return discriptionDao;
		}

		}
