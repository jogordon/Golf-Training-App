package controllers;

import java.util.ArrayList;
import service.Database;
import views.*;
import models.*;

public class HighScoreController extends AAnimationScreenController {

	
	/****************** attributes ***********************/
	// To do: Code here
	/****************** attributes ends ******************/

	/****************** constructors *********************/

	public HighScoreController(IRopeItController ropeitController) {
		super(ropeitController);
		this.scenario=new WelcomeScenario();
		this.screen = new HighScoreScreen(this);
		setupReturnMainMenuListener();
//		this.setUpListener();
	}
	/****************** constructors ends ****************/

	/****************** private methods ******************/
	// To do: Code here
	
	/****************** private methods ends *************/

	/****************** properties ***********************/
	// To do: setters and getters code here
	//set up listener to retrieve, sort, and display high scores

	/****************** properties ends ******************/

	/****************** public methods *******************/
	// To do: Code here
	//display the highscore, get and set the high scores in here to display and pass along to the view
	public void displayHighScore(){
		Database db = Database.getInstance();
		ArrayList<GameRecord> records = db.getHighScores(13);
		HighScoreScreen screen = (HighScoreScreen) this.screen;
		screen.setHighScores(records);
	}
	/****************** public methods ends **************/

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

}
