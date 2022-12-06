package com.app.entity.model;

public class Meeting {
	private int id;
	private String name;
	private String location;
	private String date;
	private String start;
	private String end;
	private String toastmaster;
	private String ahCounter;
	private String grammarian;
	private String evaluator;
	private String timer;
	
	
	public Meeting(String name, String location, String date, String start, String end) {
		super();
		this.name = name;
		this.location = location;
		this.date = date;
		this.start = start;
		this.end = end;
	}
	public Meeting(int id, String name, String location, String date, String start, String end) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.date = date;
		this.start = start;
		this.end = end;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getToastmaster() {
		return toastmaster;
	}
	public void setToastmaster(String toastmaster) {
		this.toastmaster = toastmaster;
	}
	public String getAhCounter() {
		return ahCounter;
	}
	public void setAhCounter(String ahCounter) {
		this.ahCounter = ahCounter;
	}
	public String getGrammarian() {
		return grammarian;
	}
	public void setGrammarian(String grammarian) {
		this.grammarian = grammarian;
	}
	public String getEvaluator() {
		return evaluator;
	}
	public void setEvaluator(String evaluator) {
		this.evaluator = evaluator;
	}
	public String getTimer() {
		return timer;
	}
	public void setTimer(String timer) {
		this.timer = timer;
	}
	
}
