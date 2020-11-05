package model;
public class limitedPlaylist extends Playlist{
	
	private String[] accesUsers;
	private final int MAX_USERS = 5;
	
	public limitedPlaylist(String pname,String[] accesUsers){
		super(pname);
		this.accesUsers = accesUsers; 
	}
	
	/**
	*Generates a String with the information of the playlist<br>
	*<b>pre: </b> A sub class object of Playlist must already be created. <br>
	*<b>post: </b> Gives a String with all the info of the playlist. <br>
	*@return The informationof the playlist.
	*/
	@Override
	public String showInfo(){
		String users = "";
		for(int i=0;i<accesUsers.length; i++){
			if(accesUsers[i] != null){
			users += accesUsers[i] + "   ";
			}
		}
		String msg = super.showInfo() + "Playlist restringida\n" + "Usuarios que tienen acceso a esta playlist: " + users + "\n";
		return msg;
	}
	
	/**
	*Give acces through a boolean to the users that share the playlist.<br>
	*<b>pre: </b> The user must already be created and the playlist as well <br>
	*<b>post: </b> Gives acces(or not) to an user. <br>
	*@param nickname Is the nickname of the user that will be evaluated if it have acces or not. nickname != null
	*@return A boolean that tells if the user has acces to the playlist.
	*/
	@Override
	public boolean haveAcces(String nickname){
		boolean found = false;
		for(int i=0;i<accesUsers.length && !found; i++){
			if(accesUsers[i] != null){
				if(accesUsers[i].equals(nickname)){
					found = true;
				}
			}
		}
		return found;
	}
	
}