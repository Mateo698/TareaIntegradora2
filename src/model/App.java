package ui;
import model.*;
import java.util.Scanner;

public class App{
	//Initial menu
	private final int LOG_IN = 1;
	private final int SIGN_IN = 2;
	
	//User menu
	private final int SEE_DATA = 1;
	private final int ADD_SONG = 2;
	private final int REMOVE_SONG = 3;
	private final int SEE_POOL = 4;
	private final int NEW_PLAYLIST = 5;
	private final int SEE_PLAYLIST = 6;
	
	//Playlist menu
	private final int ADD_PLAYLISTSONG = 1;
	private final int REMOVE_PLAYLISTSONG = 2;
	private final int ADD_USER = 3;
	
	private final int EXIT = 0;
	
	
	private static Scanner in = new Scanner(System.in);
	
	private User[] users;
	private User localUser;
	private Playlist[] playlist;
	private Song[] pool;
	
	public Menu(){
		users = new User[10];
	}
	
	public int initialMenu(){
		int option;
		printLogo();
		System.out.println("Bienvenido a Music Collect & Share\n"+
		"Ingrese 1 para iniciar sesion\n"+
		"Ingrese 2 para crear una cuenta");
		boolean leave = false;
		for(int i=0; i=i && !false; i++){
			int selection = readOption();
			if(selection<0 || selection>2){
				System.out.println("Ingrese un valor valido");
			}
			else{
				leave = true;
			}
		}
		option = readOption();
		return option;
	}
	
	public String logInMenu(){
		System.out.println("Ingrese el nombre de usuario");
		String nickname = in.nextLine();
		String password;
		boolean found;
		boolean leave = false;
		for(int i=0; i<users.length; i++){
			if(users[i].getName() == nickname){
				found = true;
				System.out.println("Ingrese la contrasena");
				password = in.nextLine();
				if(users[i].getPass() == password){
					return user[i].getName();;
				}
				else{
					System.out.println("Contrasena incorrecta");
				}
			}
		}
		if(!found){
			System.out.println("Ese usuario no existe");
			return "no";
		}
	}
	
	public void userMenu(String nickname){
		Category userCategory;
		String userCategoryS;
		int userAge;
		int userIndex;
		boolean found = false;
		for(int i=0; i<users.length && !found; i++){
			if(users[i].getName().equals(nickname)){
				userAge = users[i].getAge();
				userCategory = user[i].getCategory();
				userIndex = i;
				switch(userCategory){
					case newbie:
						userCategoryS = "NEWBIE";
					break;
					
					case little_contributor:
						userCategoryS = "LITTLE CONTRIBUTOR";
					break;
					
					case star_contributor:
						userCategoryS = "STAR CONTRIBUTOR";
					break;
					
					default:
						userCategoryS = "NEWBIE";
				}
			}
		}
		boolean leave = false;
		for(int i=0; i=0 && !leave; i++){
			System.out.println("Bienvenido "+nickname+", ¿que deseas hacer?\n");
			int option = readOption();
			if(option<0 || option>6){
				System.out.println("Ingres euna opcion valida")
			}
			else if(option == EXIT){
				leave = true;
			}
			else{
				switch(option){
					case SEE_DATA:
						System.out.println( "*************  User **************\n"+
						"**  UserName: "+nickname+"\n"+
						"**  Age: "+userAge+"\n"+
						"**  Category: "+userCategoryS+"\n"+
						"***********************************");
					break;
					
					case ADD_SONG:
						Song newSong = readSong();
						users[userIndex].addPoolSong(newSong);
					break;
					
					case REMOVE_SONG;
				}
			}
		}
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
		String songLength = in.nextLine();
		String[] lengths = songLength.split("/")
		int minutes = Integer.parseInt(lengths[0]);
		int seconds = Integer.parseInt(lengths[1]);
		Length songLength = new Length(0, minutes, seconds);
		Song newSong = new Song(title, artist, genre, songLength)
		return newSong;
	}
	
	
	public void startProgram(){
		int option;
		String stayInInitialMenu = "no"
		do{
			for(int i=0; i=i && stayInInitialMenu.equals("no");i++){
				option = initialMenu();
				if(option == 1){
					if(users.length == 0){
						System.out.println("No hay usuarios registrados");
					}
					else{
						stayInInitialMenu = logInMenu();
					}
				}
				else{
					stayInInitialMenu = signInMenu();
				}
			}
			for(int i=0; i=i &&  ;i++){
				userMenu();
			
		}while(option != 0);
	}
	
	
	
	public int readOption(){
		int selection = in.nextInt();
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