package main;

import java.time.LocalDate;

public class News {
	private String title;
	private String info;
	private Language language;
	private LocalDate date;
	
	public News() {
		
	}
	
	public News(String title) {
		this.title = title;
	}
	
	public News(String title, Language language, LocalDate date) {
		this(title);
		this.language = language;
		this.date = date;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getInfo() {
		return info;
	}
	
	public Language getLanguage() {
		return language;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public void setLanguage(Language language) {
		this.language = language;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public String toString() {
	    return "News{" +
	            "title='" + title + '\'' +
	            ", info='" + info + '\'' +
	            ", language=" + language +
	            ", date=" + date +
	            '}';
	}
	
}
