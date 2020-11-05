package model;
import java.util.ArrayList;

public abstract class Playlist{
	private String name;
	private ArrayList<Song> playlistSongs;
	private Length playlistLength;
	private Genre[] playlistGenres;
	private final int MAX_GENRES = 7;
	
	public Playlist(String name){
		this.name = name;
		playlistGenres = new Genre[MAX_GENRES];
		playlistSongs = new ArrayList<Song>(30);
		playlistLength = new Length(0,0,0);
	}
	
	/**
	*Add a song to the arraylist of songs/ Add a new song to the playlist<br>
	*<b>pre: </b> The song must be already created before calling the method <br>
	*<b>post: </b> There is a new song in the arraylist of songs <br>
	*@param newSong object of type song. newSong != null
	*/
	public void addSong(Song newSong){
		playlistSongs.add(newSong);
		playlistLength.addLength(newSong.getHours(), newSong.getMinutes(), newSong.getSeconds());
		boolean found = false;
		for(int i =0; i<playlistGenres.length; i++){
			if(playlistGenres[i] != null){
				if(playlistGenres[i] == newSong.getOriginalGenre()){
					found = true;
				}
			}
		}
		boolean added = false;
		if(!found){
			for(int i =0;i<playlistGenres.length && !added;i++){
				if(playlistGenres[i] == null){
					playlistGenres[i] = newSong.getOriginalGenre(); 
					added = true;
				}
			}
		}
	}
	
	/**
	*Generates a String with the info of the playlist, including name, length, genres and users that have acces<br>
	*<b>pre: </b> The playlist must already be created <br>
	*<b>post: </b> The whole information has been given <br>
	*@return The information of the playlist
	*/
	public String showInfo(){
		String info;
		info = "**************  Playlist **************" + "\n" +
		"**  Title: " + getName() + "\n" +
		"**  Duration: " + getLength() + "\n" +
		"**  Genre: " + getGenres() + "\n";
		return info;
	}
	
	
	public abstract boolean haveAcces(String nickname);
	
	/**
	*This method is Overrided in publicPlaylist to be able to set grade<br>
	*<b>pre: </b>  <br>
	*<b>post: </b>  <br>
	*@param .Variable  >= 0
	*@return 
	*/
	public void addGrade(double g){}
	
	/**
	*Generates a String with all the songs in the arraylist of songs.<br>
	*<b>pre: </b> A sub class of playlist must already be created. <br>
	*<b>post: </b> Gives all the information of the songs in the arraylist. <br>
	*@return A string with all the song's info.
	*/
	public String showSongs(){
		String msg = "Las canciones de la playlist son:\n";
		if(playlistSongs.isEmpty()){
			return "No hay canciones en esta playlist";
		}
		else{
			for(int i=0; i<playlistSongs.size(); i++){
				msg += playlistSongs.get(i).getName()+"\n";
			}
			return msg;
		}
	}
	

	/**
	*Gives the name of the playlist.<br>
	*<b>pre: </b> A sub class of Playlist must already be created. <br>
	*<b>post: </b> Gives the name of the playlist <br>
	*@return The name of the playlist
	*/
	public String getName(){
		return name;
	}
	
	/**
	*Generates a String with the information of th length of the playlist.<br>
	*<b>pre: </b> The playlist must already have an object of type Length <br>
	*<b>post: </b> Gives the length of the playlist. <br>
	*@return The length of the playlist.
	*/
	public String getLength(){
		String length = playlistLength.getHours() +":"+ playlistLength.getMinutes() +":"+ playlistLength.getSeconds();
		return length;
	}
	
	/**
	*Generates a String with the genres of the playlist. <br>
	*<b>pre: </b> A sub class object of Playlist must already be created <br>
	*<b>post: </b> Gives the genres in the  <br>
	*@return The genres of the songs in the playlist AKA the playlist genres.
	*/
	public String getGenres(){
		int numGenres = 0;
		for(int i=0; i<playlistGenres.length; i++){
			if(playlistGenres[i] != null){
				numGenres++;
			}
		}
		String genres = " ";
		String genre = " ";
		for(int i=0; i<playlistGenres.length; i++){
			if(playlistGenres[i] != null){
				switch(playlistGenres[i]){
					case rock:
						genre = "Rock";
					break;
					
					case hip_hop:
						genre = "Hip hop";
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
				}
				genres += genre;
				numGenres--;
			}
			if(numGenres != 0){
				genres+= ", ";
			}
		}
		if(genres.equals(" ")){
			return "Unknown";
		}
		else{
			return genres;
		}
	}
	
}