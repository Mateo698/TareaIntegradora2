package model;
public class Length{
	private int hours;
	private int minutes;
	private int seconds;
	
	public Length(int hours, int minutes, int seconds){
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public void addLength(int hours, int minutes, int seconds){
		this.hours += hours;
		this.minutes += minutes;
		this.seconds += seconds;
	}
	
	public void reduceLength(int hours, int minutes, int seconds){
		this.hours -= hours;
		this.minutes -= minutes;
		this.seconds -= seconds;
	}