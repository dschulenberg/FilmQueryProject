package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
//  public DatabaseAccessorObject() throws ClassNotFoundException {
//	    Class.forName("com.mysql.cj.jdbc.Driver");
//	  }

  public Film findFilmById(int filmId1) {
			Film film = null;
			String user = "student";
			String pass = "student";
			try {
				Connection conn = DriverManager.getConnection(URL, user, pass);
				String sql = "SELECT * "
					+ " FROM film WHERE id =?";
				
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1, filmId1);

				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {
					int filmId = rs.getInt("id");
					String title = rs.getString("title");
					String desc = rs.getString("description");
					int releaseYear = rs.getInt("release_year");
					int langId = rs.getInt(5);
					double rentDur = rs.getInt(6);
					double rate = rs.getDouble(7);
					int length = rs.getInt(8);
					double repCost = rs.getDouble(9);
					String rating = rs.getString(10);
					String features = rs.getString(11);
					
					 film = new Film(filmId, title, desc, releaseYear, langId, 
								rentDur, rate, length, repCost, rating,
								features);
				}
				rs.close();
				stmt.close();
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return film;
		}
  
public Actor findActorById(int actorId) {
	Actor actor = null;
	String user = "student";
	String pass = "student";
	try {
	Connection conn = DriverManager.getConnection(URL, user, pass);
	

	String sql = "SELECT * FROM actor WHERE id = ?";

	PreparedStatement stmt = conn.prepareStatement(sql);
	stmt.setInt(1, actorId);

	ResultSet actorResult = stmt.executeQuery();

	if (actorResult.next()) {
		actor = new Actor(); 
		
		actor.setId(actorResult.getInt("id"));
		actor.setLastName(actorResult.getString("last_name"));
		actor.setFirstName(actorResult.getString("first_name"));
		
		
//		List<Film> films = findFilmsByActorId(actorId);
//		actor.setFilms(films); 
	}

	actorResult.close();
	stmt.close();

	conn.close();
	} catch(SQLException e) {
		e.getStackTrace();
	}
	return actor;
}

public List<Actor> findActorsByFilmId(int filmId) {
	
	return null;
}

}
