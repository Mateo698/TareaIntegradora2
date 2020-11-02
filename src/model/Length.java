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
	
	public Length(int minutes, int seconds){
		hours = 0;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public void addLength(int hours, int minutes, int seconds){
		this.hours += hours;
		this.minutes += minutes;
		this.seconds += seconds;
		if(seconds>=60){
			this.seconds = 0;
			this.minutes++;
		}
		if(minutes>=60){
			this.minutes = 0;
			this.hours++;
		}
	}
	
	public void reduceLength(int hours, int minutes, int seconds){
		this.hours -= hours;
		this.minutes -= minutes;
		this.seconds -= seconds;
	}
	
	public int getHours(){
		return hours;
	}
	
	public int getMinutes(){
		return minutes;
	}
	
	public int getSeconds(){
		return seconds;
	}
}