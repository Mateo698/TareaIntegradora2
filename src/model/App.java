package model;


public class App{
	
	private User[] users;
	private Playlist[] playlist;
	private Song[] pool;
	
	public App(){
		users = new User[10];
	}
	
	public String addPoolSong(Song newSong){
		boolean added = false;
		for(int i=0; i<pool.length && !added; i++){
			if(pool[i] == null){
				pool[i] = newSong;
				added = true;
			}
		}
		if(added){
			return "La cancion fue agregada correctamente";
		}
		else{
			return "No se pudo agregar la cancion";
		}
	}
	
	public void newPrivatePlaylist(String name, User localUser){
		boolean leave = false;
		privatePlaylist newPL = new privatePlaylist(name,localUser);
		for(int i=0; i==i && !false; i++){
			if(playlist[i] == null){
				playlist[i] = newPL;
				leave = true;
			}
		}
		
	}
	
	public void newLimitedPlaylist(){
		boolean leave = false;
		limitedPlaylist newPL = new limitedPlaylist(name, );
		for(int i=0; i==i && !false; i++){
			if(playlist[i] == null){
				playlist[i] = newPL;
				leave = true;
			}
		}
	}
	
	
	public void newPublicPlaylist(){
		boolean leave = false;
		publicPlaylist newPL = new publicPlaylist(name, );
		for(int i=0; i==i && !false; i++){
			if(playlist[i] == null){
				playlist[i] = newPL;
				leave = true;
			}
		}
		
	}
	
	public String seePool(){
		String songGenre = " ";
		String msg = "Estas son las canciones compartidas hasta el momento:\n";
		for(int i=0; i<pool.length; i++){
			if(pool[i] != null){
				msg +=  "\n**************  Song **************\n"+
				"**  Title: "+pool[i].getName()+"\n"+
				"**  Artist: "+pool[i].getArtist()+"\n"+
				"**  Duration: "+pool[i].getMinutes()+":"+pool[i].getSeconds()+"\n"+
				"**  Genre: "+ pool[i].getGenre()+"\n"+
				"***********************************"+"\n";
			}
		}
		if(msg.equals("Estas son las canciones compartidas hasta el momento:\n")){
			return "Todavia no hay canciones compartidas";
		}
		else{
			return msg;
		}
	}
	
	public int getUsersLength(){
		return users.length;
	}

	public User getUser(int index){
		return user[index];
	}

}

	