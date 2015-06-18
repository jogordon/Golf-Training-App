package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.ScreenEnum;
import views.*;

public abstract class AScreenController {
	

	/****************** attributes ***********************/
	IRopeItController ropeitController;
	protected AScreen screen;
	/****************** attributes ends ******************/

	/****************** constructors *********************/
	// To do: Code here
	/****************** constructors ends ****************/

	/****************** private methods ******************/
	protected void setupReturnMainMenuListener() {
		this.screen.addReturnMainMenuListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: exit play mode
				// back to main menu.
				ropeitController.showScreen(ScreenEnum.WELCOME_SCREEN);
			}
		});
	}
	/****************** private methods ends *************/

	/****************** properties ***********************/
	// To do: setters and getters code here
	/****************** properties ends ******************/

	/****************** public methods *******************/
	public AScreenController(IRopeItController ropeitController) {
		this.ropeitController = ropeitController;
	}

	public AScreen getScreen() {
		return this.screen;
	}
	/****************** public methods ends **************/

	

	
}
