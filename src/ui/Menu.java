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
	private final int ADD_SONGTOPLAYLIST = 5;
	private final int SEE_PLAYLIST = 6;
	private final int SEE_USERS = 7;
	
	
	private final int EXIT = 0;
	
	private App app;
	
	private Scanner in = new Scanner(System.in);
	
	public Menu(){
		app = new App();
	}
	
	public boolean initialMenu(){
		boolean leaveApp = false;
		String user;
		int selection = 0;
		printLogo();
		System.out.println("Bienvenido a Music Collect & Share\n"+
		"Ingrese 1 para iniciar sesion\n"+
		"Ingrese 2 para crear una cuenta\n"+
		"Ingrese 3 para salir\n");
		boolean leave = false;
		for(int i=0; i==i && !leave; i++){
			selection = readOption();
			if(selection<0 || selection>3){
				System.out.println("Ingrese un valor valido");
			}
			else{
				leave = true;
			}
		}
		boolean leaveUserMenu = false;
		switch(selection){
			case 1:
				user = logInMenu();
				if(user.equals("notFound")){
					leaveApp = false;
				}
				else{
					for(int i=0; i==i && !leaveUserMenu; i++){
						leaveUserMenu = userMenu(user);
					}
					leaveApp = false;
				}
			break;
			
			case 2:
				user = signInMenu();
				for(int i=0; i==i && !leaveUserMenu; i++){
					leaveUserMenu = userMenu(user);
				}
				leaveApp = false;
			break;
			
			case 3:
				leaveApp = true;
			break;
			
			default:
			leaveApp = false;
		}
		return leaveApp;
	}
	
	public String logInMenu(){
		System.out.println("Ingrese el nombre de usuario");
		String nickname = in.nextLine();
		String password;
		boolean found = false;
		boolean leave = false;
		for(int i=0; i<app.getUsersLength(); i++){
			if(app.getUser(i) != null){
				if(app.getUser(i).getName().equals(nickname)){
					System.out.println("Ingrese la contrasena");
					password = in.nextLine();
					if(app.getUser(i).getPass().equals(password)){
						found = true;
					}	
					else{
						System.out.println("Contrasena incorrecta");
					}
				}
			}
		}
		if(!found){
			System.out.println("Ese usuario no existe o la contrasenia es incorrecta");
			return "notFound";
		}
		else{
			return nickname;
		}
	}
	
	public boolean userMenu(String nickname){
		boolean leaveUserMenu = false;
		User localUser = null;
		String userCategory;
		int userAge;
		int userIndex = 0;
		boolean found = false;
		for(int i=0; i<app.getUsersLength() && !found; i++){
			if(app.getUser(i)!= null){
				if(app.getUser(i).getName().equals(nickname)){
					localUser = app.getUser(i);
					userAge = app.getUser(i).getAge();
					userCategory = app.getUser(i).getCategory();
					userIndex = i;
					found = true;
				}
			}
			
		}
		boolean leave = false;
		for(int i=0; i==0 && !leave; i++){
			System.out.println("Bienvenido "+nickname+",que deseas hacer?\n"+
			"1 para ver tu informacion\n"+
			"2 para compartir una cancion\n"+
			"3 para ver las canciones compartidas\n"+
			"4 para crear una playlist\n"+
			"5 para acceder a una playlist\n"+
			"6 para ver las playlist\n"+
			"7 para ver los usuarios\n" +
			"0 para salir\n");
			int option = readOption();
			if(option<0 || option>7){
				System.out.println("Ingrese una opcion valida");
				leaveUserMenu = false;
			}
			else if(option == EXIT){
				leave = true;
				leaveUserMenu = true;
			}
			else{
				switch(option){
					case SEE_DATA:
						System.out.println(app.getUser(userIndex).seeUserData());
					break;
					
					case ADD_SONG:
						Song newSong = readSong();
						System.out.println(app.addPoolSong(newSong, userIndex));
					break;
					
					case SEE_POOL:
						System.out.println(app.seePool());
					break;
					
					case NEW_PLAYLIST:
						readPlaylist(localUser);
					break;
					
					case ADD_SONGTOPLAYLIST:
						addSongToPlaylist(localUser.getName());
					break;
					
					case SEE_PLAYLIST:
						showPlaylist();
					break;
					
					case SEE_USERS:
						System.out.println(app.seeUsers());
					break;
					
					default:
				}
				leaveUserMenu = false;
			}
		}
		return leaveUserMenu;
	}
	
	public void addSongToPlaylist(String nickname){
		double grade;
		int selectedPlaylist;
		int operation;
		int selectedSong;
		showPlaylist();
		System.out.println("Seleccione el numero de la playlist a la cual quiere acceder");
		selectedPlaylist = in.nextInt();
		if(app.haveAccesToPlaylist(selectedPlaylist,nickname)){
			if(app.isPublic(selectedPlaylist)){
				System.out.println("Ingrese 1 si quiere agregar una cancion a la playlist, 2 si quiere ver las canciones de la playlist, 3 para calificar la playlist");
				operation = in.nextInt();
				switch(operation){
					case 1:
						System.out.println(app.seePool());
						System.out.println("Digite el numero de la cancion que desea agregar a la playlist");
						selectedSong = in.nextInt();
						in.nextLine();
						app.addPlaylistSong(selectedPlaylist,selectedSong);
					break;
					
					case 2:
						System.out.println(app.seePlaylistSongs(selectedPlaylist));
					break;
					
					case 3:
						System.out.println("Ingrese su calificacion de 0 a 5");
						grade = in.nextDouble();
						in.nextLine();
						app.setGrade(grade, selectedPlaylist);
					break;
					
					default:
						System.out.println("Opcion invalida");
				} 
			}
			else{
				System.out.println("Ingrese 1 si quiere agregar una cancion a la playlist, 2 si quiere ver las canciones de la playlist");
				operation = in.nextInt();
				if(operation == 1){
					System.out.println(app.seePool());
					System.out.println("Digite el numero de la cancion que desea agregar a la playlist");
					selectedSong = in.nextInt();
					in.nextLine();
					app.addPlaylistSong(selectedPlaylist,selectedSong);
				}
				else{
					System.out.println(app.seePlaylistSongs(selectedPlaylist));
				}	
			}
		}
		else{
			System.out.println("Usted no tiende acceso a esta playlist");
		}
		
	}
	
	public void showPlaylist(){
		System.out.println(app.seePlaylist());
	}
	
	public String signInMenu(){
		String nickname;
		String password;
		int age;
		System.out.println("Ingrese un nombre de usuario distinto a los presentados a continuacion");
		System.out.println(app.seeUsers());
		nickname = in.nextLine();
		System.out.println("Ingrese una nueva contrasenia");
		password = in.nextLine();
		System.out.println("Ingrese su edad");
		age = in.nextInt();
		in.nextLine();
		app.newUser(nickname, password, age);
		return nickname;
	}
	
	public Song readSong(){
		System.out.println("Ingrese el nombre de la cancion");
		String title = in.nextLine();
		System.out.println("Ingrese el nombre del artista");
		String artist = in.nextLine();
		System.out.println("Ingrese \n1 si el genero es rock\n2 si es Hip Hop\n3 si es clasica\n4 si es reggae\n5 si es salsa\n6 si es metal");
		int genre = in.nextInt();
		in.nextLine();
		System.out.println("Ingrese la duracion de la cancion en el formato MINUTOS:SEGUNDOS");
		String sSongLength = in.nextLine();
		String[] lengths = sSongLength.split(":");
		int minutes = Integer.parseInt(lengths[0]);
		int seconds = Integer.parseInt(lengths[1]);
		Length songLength = new Length(minutes, seconds);
		Song newSong = new Song(title, artist, genre, songLength);
		return newSong;
	}
	
	public void readPlaylist(User localUser){
		String[] accesUsers; 
		System.out.println("Ingrese el nombre de la playlist");
		String name = in.nextLine();
		System.out.println("Ingrese 1 si desea que sea privada\n2 si desea que sea restringida\n3 si desea que sea publica");
		int type = in.nextInt();
		in.nextLine();
		switch(type){
			case 1:
				System.out.println(app.newPlaylist(name, localUser));
			break;
			
			case 2:
				accesUsers = readLimitedPlaylist(localUser);
				System.out.println(app.newPlaylist(name, accesUsers));
			break;
			
			case 3:
				System.out.println(app.newPlaylist(name));
			break;
			
			default:
			
		}
	}
	
	public String[] readLimitedPlaylist(User localUser){
		String selectedUser;
		boolean leave = false;
		String[] accesUsers = new String[5]; 
		accesUsers[0] = localUser.getName();
		System.out.println("Ingrese los nombres EXACTOS de los usuarios con los que desea comapartir la playlist");
		System.out.println(app.seeUsers());
		for(int i=0; i<accesUsers.length && !leave; i++){
			System.out.println("Ingrese el nickname de un usuario, de lo contrario, escriba SALIR para no agregar mas usuarios");
			selectedUser = in.nextLine();
			if(selectedUser.equalsIgnoreCase("SALIR")){
				leave = true;
			}
			else{
				System.out.println("SI");
				boolean added = false;
				for(int j=0; j<accesUsers.length && !added; j++){
					if(accesUsers[j]==null){
						System.out.println("SI x2");
						accesUsers[j] = selectedUser;
						added = true;
					}
				}
			}
		}
		System.out.println(accesUsers[1]);
		return accesUsers;
		
	}
	
	
	
	
	public void startProgram(){
		boolean leaveInitialMenu = false;
		for(int i=0; i==i && !leaveInitialMenu; i++){
			leaveInitialMenu = initialMenu();
		}
		System.out.println("Gracias por usar MCS c:");
	}
	
	
	
	public int readOption(){
		int selection;
		selection = in.nextInt();
		in.nextLine();
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