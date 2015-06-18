package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.Database;
import views.WelcomeScreen;
import models.Ball;
import models.ClubEnum;
import models.MainMenuCommand;
import models.ScreenEnum;
import models.User;
import models.WelcomeScenario;

public class WelcomeScreenController extends AAnimationScreenController {

	/****************** attributes ******************/

	/****************** attributes ends *************/

	/****************** constructors ******************/
	public WelcomeScreenController(IRopeItController ropeitController) {
		super(ropeitController);
		this.scenario=new WelcomeScenario();
		screen = new WelcomeScreen(this);	
		setupLoginListener();
		setupMenuListeners();
		setupCreateUserListener();
	}
	/****************** constructors ends *************/

	/****************** private methods ******************/
	
	private void performMainMenuCommands(MainMenuCommand cmd){
		switch (cmd) {
		case GAME:
			ropeitController.showScreen(ScreenEnum.GAMING);
			break;
		case TRAIN:
			ropeitController.showScreen(ScreenEnum.TRAINING);
			break;
		case HISTORY:
			ropeitController.showScreen(ScreenEnum.HISTORY);
			break;
		case HIGHSCORE:
			ropeitController.showScreen(ScreenEnum.HIGHSCORE);
			break;
		case ACHIEVEMENT:
			ropeitController.showScreen(ScreenEnum.ACHIEVEMENT);
			break;
		case LOGOUT: 
			ropeitController.logout();
			((WelcomeScreen)screen).switchToLogin();
			break;
		default:
			break;
		}
	}
	
	private void setupLoginListener() {
		((WelcomeScreen)screen).addLoginListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				WelcomeScreen welcomeScreen = (WelcomeScreen)screen;
				String userName = welcomeScreen.getUserName();
				String pw  = welcomeScreen.getPassword();
				if(Database.getInstance().login(userName, pw)) {
					//create user and uncomment following line to set user.
					User user = new User(userName);
					ropeitController.setCurrentUser(user);
					//ropeitController.showScreen(ScreenEnum.MAIN_MENU);
					welcomeScreen.switchToMenu(userName);
					welcomeScreen.eraseTextFields();
				}
				else {
					welcomeScreen.setLoginMessageLabel("Your login info is incorrect");
				}
			}
		});
	}
	
	private void setupMenuListeners() {
		((WelcomeScreen)this.screen).addMenuListeners(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				// convert string to enum and pass to this value.
				performMainMenuCommands(MainMenuCommand.valueOf(cmd));
			}
		});
	}
	private void setupCreateUserListener() {
		((WelcomeScreen)screen).addCreateUserListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				WelcomeScreen welcomeScreen = (WelcomeScreen) screen;
				String userName = welcomeScreen.getUserName();
				String pw = welcomeScreen.getPassword();
				if(Database.getInstance().createNewUser(userName, pw)) {
					User user = new User(userName);
					ropeitController.setCurrentUser(user);
					welcomeScreen.switchToMenu(userName);
					welcomeScreen.eraseTextFields();
				}
				else {
					welcomeScreen.setLoginMessageLabel("Sorry, username already exists");
				}
			}
		});
	}

	/****************** private methods ends *************/

	/****************** properties ******************/
	
	/****************** properties ends *************/

	/****************** public methods ******************/
	@Override
	public void ballLanded(Ball ball) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void hitBall(){
		// Do nothing.
	}
	@Override
	public void replay(){
		// Do nothing.
	}
	/****************** public methods ends *************/

	@Override
	public ClubEnum switchClub() {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	

	
}
