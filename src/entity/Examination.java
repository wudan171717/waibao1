package entity;

import java.io.Serializable;

public class Examination implements Serializable{
	
	private static final long serialVersionUID = -7390839011300261231L;
	private int id;
	private String startTime;
	private String endTime;
	private String range;
	private String img;
	private int grade;
	private String title;
	private String statue;
	private int people;
	private int overPeople;
	private String publishTeacher;
	
	
	public Examination() {
		super();
	}


	public Examination(int id, String startTime, String endTime, String range,
			String img, int grade, String title, String statue, int people,
			int overPeople, String publishTeacher) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.range = range;
		this.img = img;
		this.grade = grade;
		this.title = title;
		this.statue = statue;
		this.people = people;
		this.overPeople = overPeople;
		this.publishTeacher = publishTeacher;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public String getRange() {
		return range;
	}


	public void setRange(String range) {
		this.range = range;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getStatue() {
		return statue;
	}


	public void setStatue(String statue) {
		this.statue = statue;
	}


	public int getPeople() {
		return people;
	}


	public void setPeople(int people) {
		this.people = people;
	}


	public int getOverPeople() {
		return overPeople;
	}


	public void setOverPeople(int overPeople) {
		this.overPeople = overPeople;
	}


	public String getPublishTeacher() {
		return publishTeacher;
	}


	public void setPublishTeacher(String publishTeacher) {
		this.publishTeacher = publishTeacher;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String toString() {
		return "Examination [id=" + id + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", range=" + range + ", img=" + img
				+ ", grade=" + grade + ", title=" + title + ", statue="
				+ statue + ", people=" + people + ", overPeople=" + overPeople
				+ ", publishTeacher=" + publishTeacher + "]";
	}

}
