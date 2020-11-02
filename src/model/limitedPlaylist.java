package model;
public class limitedPlaylist extends Playlist{
	
	private String[] accesUsers;
	private final int MAX_USERS = 5;
	
	public limitedPlaylist(String pname,String[] accesUsers){
		super(pname);
		this.accesUsers = accesUsers; 
	}
	
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