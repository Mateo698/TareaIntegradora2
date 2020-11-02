package model;

public class App{
	
	private User[] users;
	private Playlist[] playlist;
	private Song[] pool;
	
	public App(){
		users = new User[10];
		playlist = new Playlist[20];
		pool = new Song[30];
	}
	
	public String addPoolSong(Song newSong, int userIndex){
		boolean added = false;
		for(int i=0; i<pool.length && !added; i++){
			if(pool[i] == null){
				pool[i] = newSong;
				added = true;
				users[userIndex].setSharedSongs();
			}
		}
		if(added){
			return "La cancion fue agregada correctamente";
		}
		else{
			return "No se pudo agregar la cancion";
		}
	}
	
	public void addPlaylistSong(int selectedPlaylist, int selectedSong){
		selectedPlaylist--;
		selectedSong--;
		playlist[selectedPlaylist].addSong(pool[selectedSong]);
	}
	
	public void newUser(String nickname, String password, int age){
		boolean added = false;
		User newUser = new User(nickname, password, age);
		for(int i=0; i<users.length && !added; i++){
			if(users[i] == null){
				users[i] = newUser;
				added = true;
			}
		}
	}
	
	//private
	public String newPlaylist(String name, User localUser){
		String msg = "No se pudo agregar la playlist";
		boolean leave = false;
		privatePlaylist newPL = new privatePlaylist(name,localUser);
		for(int i=0; i<playlist.length && !leave; i++){
			if(playlist[i] == null){
				playlist[i] = newPL;
				leave = true;
			}
		}
		if(leave){
			msg = "La playlist fue agregada correctamente";
		}
		return msg;
	}
	
	//limited
	public String newPlaylist(String name,String[] accesUsers){
		String msg = "No se pudo agregar la palylist";
		boolean leave = false;
		limitedPlaylist newPL = new limitedPlaylist(name,accesUsers);
		for(int i=0; i<playlist.length && !leave; i++){
			if(playlist[i] == null){
				playlist[i] = newPL;
				leave = true;
			}
		}
		if(leave){
			msg = "La playlist fue agregada correctamente";
		}
		return msg;
	}
	
	//public
	public String newPlaylist(String name){
		String msg = "No se pudo agregar la palylist";
		boolean leave = false;
		publicPlaylist newPL = new publicPlaylist(name);
		for(int i=0; i<playlist.length && !leave; i++){
			if(playlist[i] == null){
				playlist[i] = newPL;
				leave = true;
			}
		}
		if(leave){
			msg = "La playlist fue agregada correctamente";
		}
		return msg;
	}
	
	public String seePool(){
		int number = 1;
		String songGenre = " ";
		String msg = "Estas son las canciones compartidas hasta el momento:\n";
		for(int i=0; i<pool.length; i++){
			if(pool[i] != null){
				msg +=  "\n" + number  + ". **************  Song **************\n"+
				"**  Title: "+pool[i].getName()+"\n"+
				"**  Artist: "+pool[i].getArtist()+"\n"+
				"**  Duration: "+pool[i].getMinutes()+":"+pool[i].getSeconds()+"\n"+
				"**  Genre: "+ pool[i].getGenre()+"\n"+
				"***********************************"+"\n";
				number++;
			}
		}
		if(msg.equals("Estas son las canciones compartidas hasta el momento:\n")){
			return "Todavia no hay canciones compartidas";
		}
		else{
			return msg;
		}
	}
	
	public String seeUsers(){
		String usersS = "Usuarios de la aplicacion: \n";
		boolean found = false;
		for(int i=0; i<users.length;i++){
			if(users[i] != null){
				usersS += users[i].getName() + "\n";
				found = true;
			}
		}
		if(!found){
			return "Aun no hay usuarios en la aplicacion, cualquier nombre de usuario es valido";
		}
		return usersS;
	}
	
	public String seePlaylist(){
		String msg = "Playlist creadas en la aplicacion : \n";
		boolean found = false;
		int number = 1;
		for(int i = 0; i<playlist.length; i++){
			if(playlist[i] != null){
				msg += number + ". " + playlist[i].showInfo() + "\n";
				found = true;
				number++;
			}
		}
		if(!found){
			return msg = "Aun no hay playlist en la aplicacion";
		}
		else{
			return msg;
		}
	}
	
	public boolean isPublic(int selectedPlaylist){
		if(playlist[selectedPlaylist] instanceof publicPlaylist){
			System.out.println("SI");
			return true;
		}
		else{
			return false;
		}
	}
	
	public void setGrade(double grade, int selectedPlaylist){
		playlist[selectedPlaylist].addGrade(grade);
	}
	
	public String seePlaylistSongs(int selected){
		selected--;
		String msg = playlist[selected].showSongs();
		return msg;
	}
	
	public boolean haveAccesToPlaylist(int selected,String nickname){
		selected--;
		boolean have = playlist[selected].haveAcces(nickname);
		return have;
	}
	
	public int getUsersLength(){
		return users.length;
	}

	public User getUser(int index){
		return users[index];
	}

}

	