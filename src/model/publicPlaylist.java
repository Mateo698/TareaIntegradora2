package model;
public class publicPlaylist extends Playlist{
	
	private double grade;
	private int amountGrades;
	
	public publicPlaylist(String name){
		super(name);
		grade = 0;
		amountGrades = 0;
	}
	
	/**
	*Generates a String with the information of the playlist<br>
	*<b>pre: </b> A sub class object of Playlist must already be created. <br>
	*<b>post: </b> Gives a String with all the info of the playlist. <br>
	*@return The informationof the playlist.
	*/
	@Override
	public String showInfo(){
		String msg = super.showInfo() + "Playlist publica" + "\nCalificacion de la playlist: " + grade + "\n";
		return msg;
	}
	
	/**
	*Gives acces to all users<br>
	*<b>pre: </b> At least one user must be logged In <br>
	*<b>post: </b> Give acces to every user <br>
	*@param nickname Is the name of the user. nickname != null
	*@return 
	*/
	@Override
	public boolean haveAcces(String nickname){
		return true;
	}
	
	/**
	*Adds a new user grade to the playlist average calification<br>
	*<b>pre: </b> There must be at least one user logged in <br>
	*<b>post: </b> Updates the calification of the palylist <br>
	*@param newUserGrade double with the new grade made by a user. newUserGrade >= 0 || newUserGrade <= 5
	*/
	public void addGrade(double newUserGrade){
		if(amountGrades == 0){
			grade = newUserGrade;
			amountGrades = 1;
		}
		else{
			double newGrade = (grade + newUserGrade)/2;
			grade = newGrade;
			amountGrades++;
		}
	}
	
	
	
}