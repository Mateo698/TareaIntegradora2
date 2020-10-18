package model;
import java.util.ArrayList;

public class Playlist{
	private String name;
	private ArrayList<Song> playlistSongs;
	private Length playlistLength;
	private Genre[] playlistGenres;
	private final int MAX_GENRES;
	
	public Playlist(String name){
		this.name = name;
		playlistGenres = new Genre[MAX_GENRES];
		ArrayList<Song> playlistSongs = new ArrayList<Song>();
		playlistLength = new Length(0,0,0);
	}
	
	public void addSong(Song newSong){
		playlistSongs.add(newSong);
		playlistLength.addLenth(newSong.getHours, newSong.getMinutes, newSong.getSeconds)
	}
	
	public String removeSong(int song){
		song -= 1;
		if(song<=playlistSongs.size()){
			playlistSongs.remove(song);
			return "La cancion fue eliminada exitosamente";
		}
		else{
			return "Valor invalido";
		}
		
	}
	
	public String showSongs(){
		msg = "Las canciones de la playlist son:\n";
		if(playlistSongs.get(0) == null){
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
		if(playlistSongs.get(0) == null){
			return false;
		}
		else{
			return true;
		}
	}