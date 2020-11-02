package model;
public class publicPlaylist extends Playlist{
	
	private double grade;
	private int amountGrades;
	
	public publicPlaylist(String name){
		super(name);
		grade = 0;
		amountGrades = 0;
	}
	
	@Override
	public String showInfo(){
		String msg = super.showInfo() + "Playlist publica" + "\nCalificacion de la playlist: " + grade + "\n";
		return msg;
	}
	
	@Override
	public boolean haveAcces(String nickname){
		return true;
	}
	
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