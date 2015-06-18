package models;

//User Model
public class User {
	String name;
//	String password;
	
	//constructor
	public User(String name) {
		this.name = name;
//		this.password = password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	//create user 
	public static User createUser(String name) {
		return null;
	}
	
	public String toString() {
		return "";
	}
	
}
