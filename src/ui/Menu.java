package ui;
import model.*;
import java.util.Scanner;
public class Menu{
	
	//Initial menu
	private final int LOG_IN = 1;
	private final int SIGN_IN = 2;
	
	//User menu
	private final int SEE_DATA = 1;
	private final int ADD_SONG = 2;
	private final int SEE_POOL = 3;
	private final int NEW_PLAYLIST = 4;
	private final int SEE_PLAYLIST = 5;
	
	//Playlist menu
	private final int ADD_PLAYLISTSONG = 1;
	private final int REMOVE_PLAYLISTSONG = 2;
	private final int ADD_USER = 3;
	
	private final int EXIT = 0;
	
	private App app;
	
	private static Scanner in = new Scanner(System.in);
	
	public Menu(){
		app = new App();
	}
	
	public boolean initialMenu(){
		int option;
		printLogo();
		System.out.println("Bienvenido a Music Collect & Share\n"+
		"Ingrese 1 para iniciar sesion\n"+
		"Ingrese 2 para crear una cuenta"+
		"Ingrese 3 para salir");
		boolean leave = false;
		for(int i=0; i==i && !false; i++){
			int selection = readOption();
			if(selection<0 || selection>3){
				System.out.println("Ingrese un valor valido");
			}
			else{
				leave = true;
			}
		}
		boolean leaveUserMenu = false;
		option = readOption();
		switch(option){
			case 1:
				String user = logInMenu();
				if(user.equals("notFound"){
					return false;
				}
				else{
					for(int i=0; i==i && !leaveUserMenu; i++){
						leaveUserMenu = userMenu(user);
					}
				}
			break;
			
			case 2:
				String user = singInMenu();
				for(int i=0; i==i && !leaveUserMenu; i++){
					leaveUserMenu = userMenu(user);
				}
			break;
			
			case 3:
				return true;
			break;
			
			default:
		}
	}
	
	public String logInMenu(){
		System.out.println("Ingrese el nombre de usuario");
		String nickname = in.nextLine();
		String password;
		boolean found;
		boolean leave = false;
		for(int i=0; i<App.getUsersLength(); i++){
			if(App.getUser(i) != null){
				if(App.getUser(i).getName().equals(nickname)){
					System.out.println("Ingrese la contrasena");
					password = in.nextLine();
					if(App.getUser(i).getPass().equals(password)){
						return App.getUsers()[i].getName();
						found = true;
					}	
					else{
						System.out.println("Contrasena incorrecta");
						return "notFound";
					}
				}
			}
		}
		if(!found){
			System.out.println("Ese usuario no existe");
			return "notFound";
		}
	}
	
	public boolean userMenu(String nickname){
		User localUser;
		String userCategory;
		int userAge;
		int userIndex;
		boolean found = false;
		for(int i=0; i<App.getUsersLength() && !found; i++){
			if(App.getUser(i).getName().equals(nickname)){
				localUser = App.getUser(i);
				userAge = App.getUser(i).getAge();
				userCategory = App.getUser(i).getCategory();
				userIndex = i;
			}
		}
		boolean leave = false;
		for(int i=0; i==0 && !leave; i++){
			System.out.println("Bienvenido "+nickname+", ¿que deseas hacer?\n"+
			"1 para ver tu informacion\n"+
			"2 para compartir una cancion\n"+
			"3 para ver las canciones compartidas\n"+
			"4 para crear una playlist\n"+
			"5 para ver tus playlist\n"+
			"0 para salir\n");
			int option = readOption();
			if(option<0 || option>5){
				System.out.println("Ingrese una opcion valida");
			}
			else if(option == EXIT){
				leave = true;
				return true;
			}
			else{
				switch(option){
					case SEE_DATA:
						System.out.println(seeUserData(nickname, userAge, userCategoryS));
					break;
					
					case ADD_SONG:
						Song newSong = readSong();
						System.out.println(App.addPoolSong(newSong));
					break;
					
					case SEE_POOl:
						System.out.println(App.seePool());
					break;
					
					case NEW_PLAYLIST:
						System.out.println(readPlaylist(localUser));
					break;
					
					case SEE_PLAYLIST:
					
					break;
					
					default:
				}
			}
		}
	}
	
	public String seeUserData(String nickname,int age, String category){
		String msg = " ";
		msg = "*************  User **************\n"+
		"**  UserName: "+nickname+"\n"+
		"**  Age: "+age+"\n"+
		"**  Category: "+category	+"\n"+
		"***********************************";
		return msg;
	}
	
	
	
	
	public Song readSong(){
		System.out.println("Ingrese el nombre de la cancion");
		String title = in.nextLine();
		System.out.println("Ingrese el nombre del artista");
		String artist = in.nextLine();
		System.out.println("Ingrese \n1 si el genero es rock\n2 si es Hip Hop\n3 si es clasica\n4 si es reggae\n5 si es salsa\n6 si es metal");
		int genre = in.nextInt();
		in.nextLine();
		System.out.println("Ingrese la duracion de la cancion en el formato MINUTOS/SEGUNDOS");
		String sSongLength = in.nextLine();
		String[] lengths = sSongLength.split("/");
		int minutes = Integer.parseInt(lengths[0]);
		int seconds = Integer.parseInt(lengths[1]);
		Length songLength = new Length(0, minutes, seconds);
		Song newSong = new Song(title, artist, genre, songLength);
		return newSong;
	}
	
	public String readPlaylist(User localUser){
		System.out.println("Ingrese el nombre de la playlist");
		String name = in.nextLine();
		System.out.println("Ingrese 1 si desea que sea privada\n2 si desea que sea restringida\n3 si desea que sea publica");
		int type = in.nextInt();
		in.nextLine();
		switch(type){
			case 1:
				App.newPrivatePlaylist(name, localUser);
			break;
			
			case 2
				readLimitedPlaylist(name, localUser);
			break;
			
			case 3
				App.newPublicPlaylist();
			break;
			
			default:
			
		}
	}
	
	public readLimitedPlaylist(String name, User localUser){
		System.out.println("Ingrese 
		
		
	}
	
	
	public void startProgram(){
		boolean leaveInitialMenu = false;
		for(int i=0; i==0 && !leaveInitialMenu){
			leaveInitialMenu = intialMenu();
		}
		
		
	}
	
	
	
	public int readOption(){
		int selection;
		selection = in.nextInt();
		return selection;
	}
	
	public void printLogo(){
		System.out.println("(((((((((((((((((((((((((((((((((((((((((((((((((\n"+
"((((((((((((((((/((((((((((((((((((((((((((((((((\n"+
"(((/  .(((((((*  .((((((*        (((((/      /(((\n"+
"(((/   .((((((.  .(((((   ,((((((((((*  .((((((((\n"+
"(((/    /((((/   .((((/  ,(((((((((((.  /((((((((\n"+
"(((/     ((((*   .((((*  ,(((((((((((/   ((((((((\n"+
"(((/  *  *(((     ((((*  ,((((((((((((,  .(((((((\n"+
"(((/  /.  ((*     ((((*  *(((((((((((((,   ((((((\n"+
"(((/  //  ,(  .   ((((*  *((((((((((((((/   /((((\n"+
"(((/  *(*  ,  (   ((((*  *((((((((((((((((   /(((\n"+
"(((/  ,(/    ,(   /(((*  ,(((((((((((((((((   (((\n"+
"(((/  .((    ((   /((((  .(((((((((((((((((.  /((\n"+
"(((/  .((.  .((.  *((((,  *((((((((((((((((   /((\n"+
"(((/  .((((((((.  *(((((   *((((/,/(((((((/   (((\n"+
"(((/  .((((((((.  *((((((.        *((   .   .((((\n"+
"(((((((((((((((/*/((((((((((///(((((((////(((((((\n"+
"(((((((((((((((((((((((((((((((((((((((((((((((((\n"+
"               ./(###((///((###(*                \n"+
"           *#(,                   *((,           \n"+
"        ,#/                           ((         \n"+
"      .#*          .**/////*,.          ((       \n"+
"     *(.      .//////////////////*       *#      \n"+
"    .#,     *///////////////////////,     /(     \n"+
"    /(    *///////////////////////////    .#.    \n"+
"  ,/////,*/////////////////////////////,*////*.  \n"+
"  /////////////////////////*,...,/////////////,  \n"+
"  //////*,,,********,,.............,,,,,//////,  \n"+
"  //////*.........//*........//*.......,//////,  \n"+
"  //////*.........,,.........,,........,//////,  \n"+
"  //////*..............................,//////,  \n"+
"   *///*  ........,/.........**.......  .*///,   \n"+
"            .......,/*.....,/*.......            \n"+
"               ........,,,,.......               \n"+
"                    .........                    \n"+
"                                                 \n"+
"*************************************************\n");
	}
	
	
}