package controllers;

import java.util.ArrayList;
import java.util.Date;
import controllers.IRopeItController;
import views.*;
import models.*;
import service.*;

public class HistoryController extends AAnimationScreenController {

	
	/****************** attributes ***********************/
	// To do: Code here
	public Date startDate;
	public Date endDate;

	/****************** attributes ends ******************/

	/****************** constructors *********************/
	public HistoryController(IRopeItController ropeitController) {
		super(ropeitController);
		this.scenario=new WelcomeScenario();
		this.screen = new HistoryScreen(this);
		setupReturnMainMenuListener();
		//this.setupListener();
	}

	/****************** constructors ends ****************/

	/****************** private methods ******************/
	// To do: Code here
	
	/****************** private methods ends *************/

	/****************** properties ***********************/
	// To do: setters and getters code here
	public User getUser() {
		return this.ropeitController.getCurrentUser();
	}
	
//	@Override
//	public AScreen getScreen(){
//		User u = getUser();
//		ArrayList<Date> dates = Database.getInstance().getRecordDates(u);
//		for (Date d : dates) {
//			Format formatter = new SimpleDateFormat("YYYY-MM-DD");
//			formatter.format(d);
//			System.out.println("UNFORMATTED DATE:" + d.toString());
//			System.out.println("FORMATTED DATE:" + formatter.format(d));
//			((HistoryScreen)screen).sDate.addItem(formatter.format(d));
//			((HistoryScreen)screen).eDate.addItem(formatter.format(d));
//		}
////		((HistoryScreen)screen).populateDates(dates);
//		return super.getScreen();
//	}
	/****************** properties ends ******************/

	/****************** public methods *******************/

	
	public void displayData(String userName, Date startDate, Date 
    	    endDate, String club) {
		//update the model with the new data
		((HistoryScreen)screen).setData(Database.getInstance().getTrainingRecords(userName, startDate, endDate, club));
	}
	
	public void testRetrieveData(String userName, Date startDate, Date endDate, String club) {
		((HistoryScreen)screen).setData(Database.getInstance().getTrainingRecords(userName, startDate, endDate, club));
	}
	
	@Override
	public void start(){
		super.start();
		// TODO: read data from databse and setup comboboxes.
		User u = getUser();
		ArrayList<Date> dates = Database.getInstance().getRecordDates(u);
		((HistoryScreen)screen).populateDates(dates);

	}
	
	@Override
	public void stop() {
		super.stop();
		//need to tell it to switch back to default data
		((HistoryScreen)this.screen).stop();
	}
	
	@Override
	public void ballLanded(Ball ball) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hitBall() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClubEnum switchClub() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/****************** public methods ends **************/
	
}


 