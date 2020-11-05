package model;
public class Song{
	private String title;
	private String artist;
	public Genre songGenre;
	private Length songLength;
	
	public Song(String title, String artist, int pSongGenre, Length songLength){
		this.title = title;
		this.artist = artist;
		this.songLength = songLength;
		switch(pSongGenre){
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
	
	/**
	*gets the name of the song<br>
	*<b>pre: </b> The Song must be already created <br>
	*<b>post: </b> Gives the song's name <br>
	*@return the name of the song
	*/
	public String getName(){
		return title;
	}
	
	/**
	*Gets the artist of the song<br>
	*<b>pre: </b> The song must be already created <br>
	*<b>post: </b> Gives the song's artist <br>
	*@return the song's artist
	*/
	public String getArtist(){
		return artist;
	}
	
	/**
	*Generates a String depending on the song's genre<br>
	*<b>pre: </b> The song must be already created <br>
	*<b>post: </b> Gives a String with the genre of the song <br>
	*@return the song's genre
	*/
	public String getGenre(){
		String genre = " ";
		switch(songGenre){
			case rock:
				genre = "Rock";
			break;
			
			case hip_hop:
				genre = "Hip Hop";
			break;
					
			case classic:
				genre = "Classic";
			break;
			
			case reggae:
				genre = "Reggae";
			break;
			
			case salsa:
				genre = "Salsa";
			break;
			
			case metal:
				genre = "Metal";
			break;
			
			default:
				genre = "Unkown";
		}
		
		return genre;
	}
	
	/**
	*Gets the genre of the song of type enum Genre<br>
	*<b>pre: </b> The song must be already created <br>
	*<b>post: </b> gives the song's genre <br>
	*@return the song's genre of type enum Genre
	*/
	public Genre getOriginalGenre(){
		return songGenre;
	}
	
	/**
	*Get the minutes of the song/playlist<br>
	*<b>pre: </b> The object length must be already created <br>
	*<b>post: </b> Gives the hours of the song/playlist <br>
	*@return the minutes of the song
	*/
	public int getMinutes(){
		return songLength.getMinutes();
	}
	
	/**
	*Get the seconds of the song/playlist<br>
	*<b>pre: </b> The object length must be already created <br>
	*<b>post: </b> Gives the seconds of the song/playlist <br>
	*@return the seconds of the song/playlist
	*/
	public int getSeconds(){
		return songLength.getSeconds();
	}
	
	/**
	*Get the hours of the song/playlist<br>
	*<b>pre: </b> The object length must be already created <br>
	*<b>post: </b> Gives the hours of the song/playlist <br>
	*@return the hours of the song/playlist
	*/
	public int getHours(){
		return songLength.getHours();
	}
}