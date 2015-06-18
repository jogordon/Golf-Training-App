package views;

import java.awt.BorderLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import controllers.AAnimationScreenController;

public abstract class AAnimationScreen extends AScreen implements ComponentListener {

	
	/****************** attributes ******************/
	private static final long serialVersionUID = 2862959940521267903L;
	AnimationView animationView;
	
	JPanel backPanel = new JPanel();
	JPanel frontPanel = new JPanel();
	/****************** attributes ends *************/

	/****************** constructors ******************/
	public AAnimationScreen(AAnimationScreenController controller) {
		this.animationView=new AnimationView(controller);
		
		this.setLayout(new BorderLayout());
		JLayeredPane layeredPane = new JLayeredPane();
		this.add(layeredPane, BorderLayout.CENTER);
		//backPanel.setLayout(new BorderLayout());

		this.addComponentListener(this); // listen to size changed.
		//frontPanel.setLayout(new BorderLayout());
		frontPanel.setOpaque(false); // Set to true to see it
		layeredPane.add(backPanel, Integer.valueOf(1));
		layeredPane.add(frontPanel, Integer.valueOf(2));
	}

	/****************** constructors ends *************/

	/****************** private methods ******************/
	// To do: Code here
	/****************** private methods ends *************/

	/****************** properties ******************/
	public JButton getReplayButton(){
		return this.animationView.btnReplay;
	}
	public AAnimationScreenController getController(){
		return this.animationView.controller;
	}
	/****************** properties ends *************/

	/****************** public methods ******************/
	public void start(String msg) {
		this.animationView.setMessage(""); // without this set message, it cannot show welcome screen, why?
		// resize back and front panel.
		this.backPanel.setBounds(0,0,this.getWidth(),this.getHeight());
		this.frontPanel.setBounds(0,0,this.getWidth(),this.getHeight());
		this.animationView.start();
	}

	public void stop() {
		this.animationView.stop();
	}
	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {

	}

	@Override
	public void componentResized(ComponentEvent e) {
//		Dimension size = e.
		this.backPanel.setBounds(0,0,this.getWidth(),this.getHeight());
		this.frontPanel.setBounds(0,0,this.getWidth(),this.getHeight());
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	/****************** public methods ends *************/

}
