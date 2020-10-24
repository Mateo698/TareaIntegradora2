package model;

public class User{
	private String nickname;
	private String password;
	private int age;
	private Category userCategory;
	
	public User(String nickname, String password, int age){
		this.nickname = nickname;
		this.password = password;
		this.age = age;
		userCategory = Category.newbie;

	}
	
	public String getName(){
		return nickname;
	}
	
	public String getPass(){
		return password;
	}
	
	public Category getCategory(){
		return userCategory;
	}
	
	public int getAge(){
		return age;
	}
	
	
}