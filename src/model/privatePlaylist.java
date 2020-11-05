package model;
public class privatePlaylist extends Playlist{
	
	private User accesUser;
	
	public privatePlaylist(String name,User accesUser){
		super(name);
		this.accesUser = accesUser;
	}
	
	/**
	*Generates a String with the information of the playlist<br>
	*<b>pre: </b> A sub class object of Playlist must already be created. <br>
	*<b>post: </b> Gives a String with all the info of the playlist. <br>
	*@return The informationof the playlist.
	*/
	@Override
	public String showInfo(){
		String msg = super.showInfo() + "Playlist privada" + "\nUsuario con acceso: " + accesUser.getName() + "\n";
		return msg;
	}
	
	/**
	*Determinate if an user have acces to the playlist.<br>
	*<b>pre: </b> The user must already be created and logged In. <br>
	*<b>post: </b> Indicates if the can acces or not to the playlist <br>
	*@param nickname is the nickname of the user that ask for acces to the playlist. nickname != null
	*@return A boolean that indcate sif the user acn acces or not to the playlist
	*/
	@Override
	public boolean haveAcces(String nickname){
		if(accesUser.getName().equals(nickname)){
			return true;
		}
		else{
			return false;
		}
	}
}