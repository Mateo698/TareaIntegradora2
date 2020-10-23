package model;

public class User{
	private String nickname;
	private String password;
	private int age;
	private Category userCategory;
	private Song[] pool;
	
	public User(String nickname, String password, int age){
		this.nickname = nickname;
		this.password = password;
		this.age = age;
		userCategory = Category.newbie;
		pool = new Song[30];
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
	
	public void addPoolSong(Song newSong){
		boolean added = false;
		for(int i=0; i<pool.length && !added; i++){
			if(pool[i] == null){
				pool[i] = newSong
				added = true;
			}
		}
	}
}