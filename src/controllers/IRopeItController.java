package controllers;

import java.awt.Dimension;
import models.ScreenEnum;
import models.User;

public interface IRopeItController {
	User getCurrentUser();
	void setCurrentUser(User user);
	void logout();
	void showScreen(ScreenEnum screen);
	Dimension getWindowSize();
}
