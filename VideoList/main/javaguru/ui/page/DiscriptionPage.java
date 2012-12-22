package javaguru.ui.page;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import javaguru.app.Discription;
import javaguru.app.Movie;
import javaguru.dao.Factory;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;

import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class DiscriptionPage extends WebPage {
	private static final long serialVersionUID = 1L;
	public String message;
	public Integer index;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DiscriptionPage(final PageParameters parameters) throws SQLException {
		
		message = parameters.toString();
		index= Character.getNumericValue(message.charAt(1));
		
		Movie movie = Factory.getInstance().getMovieDao().getMovieById(index);	
	   Discription discriptions = Factory.getInstance().getDiscriptionDao().getDiscriptionById(index);	
	   
       	add(new Label("name", movie.getFilname()));
        add(new Label("actors", "Actors: " + discriptions.getACTORS()));
        add(new Label("duration", "Duration: " + discriptions.getDURATION()));
        add(new Label("cost", "Cost: " + discriptions.getBUDJET()));
	}
};
