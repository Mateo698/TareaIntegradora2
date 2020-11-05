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
	
	/**
	*Adds a new length when a new song is added to the playlist<br>
	*<b>pre: </b> The Length must be already created <br>
	*<b>post: </b> Updates de length <br>
	*@param hours Its the hours of the song. 
	*@param minutes Its the minutes of the song. 
	*@param seconds Its the seconds of the song. 
	*/
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

	/**
	*Get the hours of the song/playlist<br>
	*<b>pre: </b> The object length must be already created <br>
	*<b>post: </b> Gives the hours of the song/playlist <br>
	*@return the hours of the song/playlist
	*/
	public int getHours(){
		return hours;
	}
	
	/**
	*Get the minutes of the song/playlist<br>
	*<b>pre: </b> The object length must be already created <br>
	*<b>post: </b> Gives the hours of the song/playlist <br>
	*@return the minutes of the song
	*/
	public int getMinutes(){
		return minutes;
	}
	
	/**
	*Get the seconds of the song/playlist<br>
	*<b>pre: </b> The object length must be already created <br>
	*<b>post: </b> Gives the seconds of the song/playlist <br>
	*@return the seconds of the song/playlist
	*/
	public int getSeconds(){
		return seconds;
	}
}