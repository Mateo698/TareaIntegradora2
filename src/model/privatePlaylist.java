package model;
public class privatePlaylist extends Playlist{
	
	private User accesUser;
	
	public privatePlaylist(String name,User accesUser){
		super(name);
		this.accesUser = accesUser;
	}
	
	@Override
	public String showInfo(){
		String msg = super.showInfo() + "Playlist privada" + "\nUsuario con acceso: " + accesUser.getName() + "\n";
		return msg;
	}
	
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