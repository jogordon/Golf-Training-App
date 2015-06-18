package models;

import java.util.ArrayList;
import java.util.Date;

public abstract class ASession {

	/****************** attributes ***********************/
	protected User user;
	protected Date date;
	protected ArrayList<Record> records;
	/****************** attributes ends ******************/

	/****************** constructors *********************/
	public ASession(User user){
		this.user=user;
		this.date=new Date();
		this.records= new ArrayList<Record>();
	}
	/****************** constructors ends ****************/

	/****************** private methods ******************/
	protected void addRecord(Record record){
		this.records.add(record);
	}
	/****************** private methods ends *************/

	/****************** properties ***********************/
	public String getSessionName(){
		return this.date.toString();
	}
	public ArrayList<Record> getRecords(){
		return this.records;
	}
	/****************** properties ends ******************/

	/****************** public methods *******************/
	
	/****************** public methods ends **************/

}
