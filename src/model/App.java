package model;


public class App{
	
	private User[] users;
	private Playlist[] playlist;
	private Song[] pool;
	
	public App(){
		users = new User[10];
	}
	
	public void addPoolSong(Song newSong){
		boolean added = false;
		for(int i=0; i<pool.length && !added; i++){
			if(pool[i] == null){
				pool[i] = newSong;
				added = true;
			}
		}
	}
	
	public void newPlaylist(String name, int type){
		boolean leave = false;
		switch(type){
			case 1:
				privatePlaylist newPL = new privatePlaylist(name, );
				for(int i=0; i==i && !false; i++){
					if(playlist[i] == null){
						playlist[i] = newPL;
						leave = true;
					}
				}
			break;
			
			case 2:
				limitedPlaylist newPL = new privatePlaylist(name, );
				for(int i=0; i==i && !false; i++){
					if(playlist[i] == null){
						playlist[i] = newPL;
						leave = true;
					}
				}
			break;
			
			case 3:
				publicPlaylist newPL = new publicPlaylist(name, );
				for(int i=0; i==i && !false; i++){
					if(playlist[i] == null){
						playlist[i] = newPL;
						leave = true;
					}
				}
			break; 
			
			default:
			
		}
	}
	
	public String seePool(){
		String msg = "Estas son las canciones compartidas hasta el momento:\n";
		for(int i=0; i<pool.length; i++){
			if(pool[i] != null){
				msg +=  "\n**************  Song **************\n"+
				"**  Title: "+pool[i].getName()+"\n"+
				"**  Artist: "+pool[i].getArtist()+"\n"+
				"**  Duration: "+pool[i].getMinutes()+":"+pool[i].getSeconds()+"\n"+
				"**  Genre: "+ 
				***********************************

		
		
		
	}
	
	public int getUsersLength(){
		return users.length;
	}

	public User getUser(int index){
		return user[index];
	}

}

	