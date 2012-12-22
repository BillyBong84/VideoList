package javaguru.ui.page;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javaguru.app.Movie;
import javaguru.dao.Factory;
import javaguru.ui.page.DiscriptionPage;


import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage{

	private static final long serialVersionUID = 1L;
	private int filmCount;
	
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public HomePage(final PageParameters parameters) throws SQLException {

		ArrayList list = new ArrayList();
		Collection movies = Factory.getInstance().getMovieDao().getAllMovies();
		Iterator iterator = movies.iterator();

	    RepeatingView repeat = new RepeatingView("Movie");
	    add(repeat);
	    
	    while (iterator.hasNext()) {
	    	Movie movie = (Movie) iterator.next();
            
            PageParameters pageParameters = new PageParameters();
            
            WebMarkupContainer parent = new WebMarkupContainer(repeat.newChildId());
            repeat.add(parent);
            
            parent.add(new Label("label1", "Movie name: " + movie.getFilname()));
            parent.add(new Label("label2", "Country: " + movie.getCountry()));
        
            parent.add(new Label("label3", "Descriptor: " + movie.getDirector()));
            parent.add(new Label("label4", "Discription: " + movie.getDiscription() + "\n" + movie.getRating()));
            
            BookmarkablePageLink link=new BookmarkablePageLink("link", DiscriptionPage.class,
                    new PageParameters("l" + movie.getID().toString()));
            link.add(new Label("linkname","See more"));
            parent.add(link);
            
            setFilmCount(getFilmCount() + 1);
	    }
	    add(new Label("label5", "Total film count: " + getFilmCount()));
	}

	public int getFilmCount() {
		return filmCount;
	}

	public void setFilmCount(int filmCount) {
		this.filmCount = filmCount;
	}
}
	