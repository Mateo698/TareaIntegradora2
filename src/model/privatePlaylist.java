package model;
public class privatePlaylist extends Playlist{
	
	private boolean openAcces;
	private User accesUser;
	
	public privatePlaylist(String name,User aUser){
		super(name);
		accesUser = aUser;
		openAcces = false;
	}
	
	
	
}