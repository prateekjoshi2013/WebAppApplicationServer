package org.prateek.demoproject.demoproject.model;
import java.sql.*;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie {

	private long id;
	private String name;
	private String rated;
	private String Category;
	private java.util.Date releaseDate;
	private int length;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public java.util.Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(java.util.Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public Movie(){}
	public Movie(long id, String name, String rated, String category, Date releaseDate, int length) {
		super();
		this.id = id;
		this.name = name;
		this.rated = rated;
		Category = category;
		this.releaseDate = releaseDate;
		this.length = length;
	}


}
