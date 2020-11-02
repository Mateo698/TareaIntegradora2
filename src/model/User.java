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
	
	public String getName(){
		return nickname;
	}
	
	public String getPass(){
		return password;
	}
	
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
	
	public int getAge(){
		return age;
	}
	
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