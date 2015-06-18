package views;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import service.ImageService;

public abstract class AScreen extends AView {

	/****************** attributes ***********************/
	private static final long serialVersionUID = 5833938845591375747L;
	JButton btnMainMenu;
	/****************** attributes ends ******************/

	/****************** constructors *********************/
	public AScreen(){
		
		this.btnMainMenu=new JButton(ImageService.scaleIcon(ImageService.getImage("Return"), 50,50));
		this.btnMainMenu.setBorderPainted(false);
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setToolTipText("Return to Main Menu");
	}
	/****************** constructors ends ****************/

	/****************** private methods ******************/
	// To do: Code here
	/****************** private methods ends *************/

	/****************** properties ***********************/
	// To do: setters and getters code here
	/****************** properties ends ******************/

	/****************** public methods *******************/
	public void fitToParentSize() {
		if (this.getParent() != null) {
			this.setSize(this.getParent().getSize());
		}
	}
	public void addReturnMainMenuListener(ActionListener listener){
		if(this.btnMainMenu!=null){
			this.btnMainMenu.addActionListener(listener);
		}
	}
	public synchronized void exitScreen(){
		this.btnMainMenu.doClick();
	}
	/****************** public methods ends **************/


	

	
}
