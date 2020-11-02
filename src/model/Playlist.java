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
	
	
	public String showInfo(){
		String info;
		info = "**************  Playlist **************" + "\n" +
		"**  Title: " + getName() + "\n" +
		"**  Duration: " + getLength() + "\n" +
		"**  Genre: " + getGenres() + "\n";
		return info;
	}
	
	public abstract boolean haveAcces(String nickname);
	
	public void addGrade(double g){}
	
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
	
	public boolean thereSongs(){
		if(playlistSongs.isEmpty()){
			return false;
		}
		else{
			return true;
		}
	}
	
	public String getName(){
		return name;
	}
	
	public String getLength(){
		String length = playlistLength.getHours() +":"+ playlistLength.getMinutes() +":"+ playlistLength.getSeconds();
		return length;
	}
	
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
		return genres;
	}
	
}