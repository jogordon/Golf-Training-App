package old.stuff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.AScreen;
import models.MainMenuCommand;
import models.ScreenEnum;

public class MainMenuController {

//	/****************** attributes ******************/
//	// To do: Code here
//	/****************** attributes ends *************/
//
//	/****************** constructors ******************/
//	public MainMenuController(IRopeItController ropeitController) {
//		super(ropeitController);
//		this.scenarioController=new ScenarioController(ScenarioEnum.WELCOME_SCENARIO);
//		this.screen = new MainMenuScreen(scenarioController);
//		this.setupListener();
//	}
//
//	/****************** constructors ends *************/
//
//	/****************** private methods ******************/
//	private void performMainMenuCommands(MainMenuCommand cmd){
//		switch (cmd) {
//		case GAME:
//			ropeitController.showScreen(ScreenEnum.GAMING);
//			break;
//		case TRAIN:
//			ropeitController.showScreen(ScreenEnum.TRAINING);
//			break;
//		case HISTORY:
//			ropeitController.showScreen(ScreenEnum.HISTORY);
//			break;
//		case HIGHSCORE:
//			ropeitController.showScreen(ScreenEnum.HIGHSCORE);
//			break;
//		case ACHIEVEMENT:
//			ropeitController.showScreen(ScreenEnum.ACHIEVEMENT);
//			break;
//		case LOGOUT: 
//			ropeitController.showScreen(ScreenEnum.WELCOME_SCREEN);
//			break;
//		default:
//			break;
//		}
//	}
//	/****************** private methods ends *************/
//
//	/****************** properties ******************/
//	private void setupListener() {
//		((MainMenuScreen)this.screen).addListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String cmd = e.getActionCommand();
//				// convert string to enum and pass to this value.
//				performMainMenuCommands(MainMenuCommand.valueOf(cmd));
//			}
//		});
//	}
//	/****************** properties ends *************/
//
//	/****************** public methods ******************/
////	public AScreen getScreen(){
////		
////		AScreen screen = super.getScreen();
////		screen.repaint();
////		return screen;
////	}
//	/****************** public methods ends *************/

}
