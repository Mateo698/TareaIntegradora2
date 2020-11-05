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
	
	/**
	*Adds a new song to the app's pool (shared songs)<br>
	*<b>pre: </b> The pool must have a size and be declared <br>
	*<b>post: </b> A new song is in the pool <br>
	*@param newSong is the new song that will be added. newSong != null
	*@param userIndex its the user's index in the array of users, its used to update its category. userIndex>= 0
	*@return A message if the song was added or not
	*/
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
	
	/**
	*Adds a new song to a selected playlist<br>
	*<b>pre: </b> There must be a playlist already delcared, the user must have acces and there must be songs in the pool<br>
	*<b>post: </b> A song of the pool is added to the playlisy <br>
	*@param selectedPlaylist its the position of the playlist in the array. selectedPlaylist>= 0 
	*@param selectedSong its the position of the song in the pool. selectedSong>= 0
	*/
	public void addPlaylistSong(int selectedPlaylist, int selectedSong){
		selectedPlaylist--;
		selectedSong--;
		playlist[selectedPlaylist].addSong(pool[selectedSong]);
	}
	
	/**
	*Adds a new user to the users array<br>
	*<b>pre: </b> The users array must be declared with its size <br>
	*<b>post: </b> Adds a new user to the array <br>
	*@param nickname its the user's nickname. nickname != null
	*@param password its the user's password. password != null
	*@param age its the user's age. age>= 0
	*/
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
	
	/**
	*Adds a new private playlist to the playlist array<br>
	*<b>pre: </b> The playlist array must be already declared <br>
	*<b>post: </b> Adds a new playlist to the array <br>
	*@param name its the playlist name. name != null
	*@param localUser its the user that created the playlist. localUser != null
	*@return A message to let the user know that the playlist was created
	*/
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
	
	/**
	*Adds a new limited playlist to the playlist array<br>
	*<b>pre: </b> The playlist array must be already declared <br>
	*<b>post: </b> Adds a new playlist to the array <br>
	*@param name its the playlist name. name != null
	*@param accesUsers its a array of tye nicknames with acces to the playlist. accesUsers != null && accesUsers.length <= 5
	*@return A message to let the user know that the playlist was created
	*/
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
	
	/**
	*Adds a new public playlist to the playlist array<br>
	*<b>pre: </b> The playlist array must be already declared <br>
	*<b>post: </b> Adds a new playlist to the array <br>
	*@param name its the playlist name. name != null
	*@return A message to let the user know that the playlist was created
	*/
	public String newPlaylist(String name){
		String msg = "No se pudo agregar la playlist";
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
	
	/**
	*Generates a String with all the information of the songs in the pool<br>
	*<b>pre: </b> The pool array must be already declared <br>
	*<b>post: </b> Shows the songs in the pool <br>
	*@return The information of all the songs
	*/
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
	
	/**
	*Generates a String with all the information of all the users<br>
	*<b>pre: </b> There must be at least one user and must be logged In <br>
	*<b>post: </b> Shows the users information <br>
	*@return The users information
	*/
	public String seeUsers(){
		String usersS = "Usuarios de la aplicacion: \n";
		boolean found = false;
		for(int i=0; i<users.length;i++){
			if(users[i] != null){
				usersS += users[i].seeUserData() + "\n";
				found = true;
			}
		}
		if(!found){
			return "Aun no hay usuarios en la aplicacion, cualquier nombre de usuario es valido";
		}
		return usersS;
	}
	
	/**
	*Generates a String with all the playlist information<br>
	*<b>pre: </b> There must be at least one user and must be logged in <br>
	*<b>post: </b> Shows the playlist information <br>
	*@return The playlist information
	*/
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
	
	/**
	*Evaluates a selected playlist if its public (this is used to display an special menu por that kind of playlist)<br>
	*<b>pre: </b> There must be at least one playlist in the array of playlist <br>
	*<b>post: </b> Evaluates if the playlist is public or not <br>
	*@param selectedPlaylist its the selected playlist of the user. selectedPlaylist>=0
	*@return  A boolean that determinates if its whether a public playlist or not
	*/
	public boolean isPublic(int selectedPlaylist){
		selectedPlaylist--;
		if(playlist[selectedPlaylist] instanceof publicPlaylist){
			System.out.println("SI");
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	*Updates the grade of a public playlist<br>
	*<b>pre: </b> There must be a grade made by a user <br>
	*<b>post: </b> Updates the playlist calification <br>
	*@param grade its the user's grade. grade>=0 || grade <= 5
	*@param selectedPlaylist its the selected playlist to rate. selectedPlaylist >= 0 && selectedPlaylist <= 30
	*@return 
	*/
	public void setGrade(double grade, int selectedPlaylist){
		selectedPlaylist--;
		playlist[selectedPlaylist].addGrade(grade);
	}
	
	/**
	*Generates a String with the songs inside a selected playlist<br>
	*<b>pre: </b> A playlist must already be created <br>
	*<b>post: </b> Shows the songs in the playlist <br>
	*@param selected its the playlist selected by the user. selected >= 0
	*@return The songs in the playlist
	*/
	public String seePlaylistSongs(int selected){
		selected--;
		String msg = playlist[selected].showSongs();
		return msg;
	}
	
	/**
	*Determinates if a user have acces to the selected playlist<br>
	*<b>pre: </b> A user must alreadybe created and logged in and there must be a playlist created <br>
	*<b>post: </b> Determinates if the user have acces or not <br>
	*@param selected its the playlist selected by the user. selected >= 0
	*@param nickname its the user's nickname. nickname !+ null
	*@return If the user have acces or not (boolean)
	*/
	public boolean haveAccesToPlaylist(int selected,String nickname){
		selected--;
		boolean have = playlist[selected].haveAcces(nickname);
		return have;
	}
	
	/**
	*Gets the length of users array<br>
	*<b>pre: </b> The array must already be declared <br>
	*<b>post: </b> Gives the size of the array <br>
	*@return The size of the array
	*/
	public int getUsersLength(){
		return users.length;
	}
	
	/**
	*Get all the information of an specific user<br>
	*<b>pre: </b> There must be atleast one user created and logged in <br>
	*<b>post: </b> Gives the user's information <br>
	*@return the users information
	*/
	public User getUser(int index){
		return users[index];
	}
	
	/**
	*Calculates the amount of playlist created<br>
	*<b>pre: </b> The array must already be declared <br>
	*<b>post: </b> Gives the amount of playlist created in the array of playlist <br>
	*@return the amount of created playlist
	*/
	public int getPlaylistAmount(){
		int amount = 0;
		for(int i = 0; i<playlist.length; i++){
			if(playlist[i] != null){
				amount++;
			}
		}
		return amount;
	}
}

	