package models;

import java.util.Date;

public abstract class Record {
	User user;
	Date date;
	
	public Record(User user, Date date) {
		this.user = user;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate() {
		this.date = new Date(System.currentTimeMillis());
	}
	
	//set an associated a user with a Record
	public void setUser(User userName) {
		this.user = userName;
	}
	
	public User getUser() {
		return this.user;
	}
}
