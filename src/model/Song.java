package model;
public class Song{
	private String title;
	private String artist;
	public Genre songGenre;
	private Length songLength;
	
	public Song(String title, String artist, int songGenre, Length songLength){
		this.title = title;
		this.artist = artist;
		switch(songGenre){
			case 1:
				songGenre = Genre.rock;
			break;
			
			case 2:
				songGenre = Genre.hip_hop;
			break;
			
			case 3:
				songGenre = Genre.classic;
			break;
			
			case 4:
				songGenre = Genre.reggae;
			break;
			
			case 5:
				songGenre = Genre.salsa;
			break;
			
			case 6:
				songGenre = Genre.metal;
			break;
			
			default:
		}
	}
	
}