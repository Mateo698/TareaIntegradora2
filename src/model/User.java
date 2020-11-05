package model;

public class User{
	private String nickname;
	private String password;
	private int age;
	private int sharedSongs;
	private Category userCategory;
	
	public User(String nickname, String password, int age){
		this.nickname = nickname;
		this.password = password;
		this.age = age;
		userCategory = Category.newbie;
		sharedSongs = 0;
	}
	
	/**
	*Gets the nickname of the user<br>
	*<b>pre: </b> The user must already be created <br>
	*<b>post: </b> Gives the user's nickname <br>
	*@return The nickname of the user
	*/
	public String getName(){
		return nickname;
	}
	
	/**
	*Gets the pass of the user to let it log in<br>
	*<b>pre: </b> The user must already be created <br>
	*<b>post: </b> Gives the users password  <br>
	*@return The users password
	*/
	public String getPass(){
		return password;
	}
	
	/**
	*returns a String with the user category<br>
	*<b>pre: </b> The user must already be created <br>
	*<b>post: </b> Returns a string with the user's category <br>
	*@return The users category as a String
	*/
	public String getCategory(){
		String userCategoryS = " ";
		switch(userCategory){
			case newbie:
				userCategoryS = "NEWBIE";
			break;
			
			case little_contributor:
				userCategoryS = "LITTLE CONTRIBUTOR";
			break;
			
			case mild_contributor:
				userCategoryS = "MILD CONTRIBUTOR";
			break;
		
			case star_contributor:
				userCategoryS = "STAR CONTRIBUTOR";
			break;
			default:
				userCategoryS = "NEWBIE";
		}
		return userCategoryS;
	}
	
	/**
	*Gives the user's age<br>
	*<b>pre: </b> The user must already be created <br>
	*<b>post: </b> Gives the users age <br>
	*@return The users age
	*/
	public int getAge(){
		return age;
	}
	
	/**
	*Updates the user's category when it shares a song<br>
	*<b>pre: </b> The song must be shared and added to the app's pool <br>
	*<b>post: </b> The user's shared songs amount will be updated and if it's the case the category as well <br> 
	*/
	public void setSharedSongs(){
		sharedSongs ++;
		if(sharedSongs == 3){
			userCategory = Category.little_contributor;
		}
		else if(sharedSongs == 10){
			userCategory = Category.mild_contributor;
		}
		else if(sharedSongs == 30){
			userCategory = Category.star_contributor;
		}
	}
	
	/**
	*Returns a String with all the user's data<br>
	*<b>pre: </b> The user must be already be created <br>
	*<b>post: </b> Gives the user's information <br>
	*@return The user's data
	*/
	public String seeUserData(){
		String msg;
		msg = "*************  User **************\n"+
		"**  UserName: "+nickname+"\n"+
		"**  Age: "+age+"\n"+
		"**  Category: "+getCategory()+"\n"+
		"***********************************\n";
		return msg;
		
	}
}