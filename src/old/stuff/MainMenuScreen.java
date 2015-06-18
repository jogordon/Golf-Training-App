package old.stuff;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;
import service.ImageService;
import models.*;

public class MainMenuScreen {

//	/****************** attributes ******************/
//	// To do: Code here
//	private static final long serialVersionUID = -2251086159611249607L;
//	
//	JButton btnGaming;
//	JButton btnTraining;
//	JButton btnHistory;
//	JButton btnHighScore;
//	JButton btnAchievement;
//	JButton btnLogout;
//	/****************** attributes ends *************/
//
//	/****************** constructors ******************/
//	public MainMenuScreen(ScenarioController scenarioController){
//		super(scenarioController);
//		
//		backPanel.setLayout(new BorderLayout());
//		backPanel.add(this.animationView, BorderLayout.CENTER);
//		frontPanel.setLayout(new BorderLayout());
//		frontPanel.add(getMainButtonsPanel(),BorderLayout.CENTER);
//		
//	}
//	/****************** constructors ends *************/
//	
//	/****************** private methods ******************/
//	private JPanel getMainButtonsPanel(){
//		JPanel panel = new JPanel(new MigLayout("", "push[center]push", "push[][][][][][]push"));
//		panel.setOpaque(false);
//		// add label, can be replaced later.
//		//this.add(new JLabel("Main Menu"));
//		btnGaming=new JButton(new ImageIcon(ImageService.getButtonImage("game")));
//		btnGaming.setBorderPainted(false);
//		btnGaming.setContentAreaFilled(false);
//		btnGaming.setAlignmentX(Component.CENTER_ALIGNMENT);
//		btnGaming.setAlignmentY(Component.CENTER_ALIGNMENT);
//		btnGaming.setActionCommand(MainMenuCommand.GAME.name()); // set actionCommand so controller could distinguish.
//		panel.add(btnGaming,"wrap");
//		
//		btnTraining=new JButton(new ImageIcon(ImageService.getButtonImage("train")));
//		btnTraining.setBorderPainted(false);
//		btnTraining.setContentAreaFilled(false);
//		btnTraining.setAlignmentX(Component.CENTER_ALIGNMENT);
//		btnGaming.setAlignmentY(Component.CENTER_ALIGNMENT);
//		btnTraining.setActionCommand(MainMenuCommand.TRAIN.name());
//		panel.add(btnTraining,"wrap");
//		
//		btnHistory=new JButton(new ImageIcon(ImageService.getButtonImage("history")));
//		btnHistory.setBorderPainted(false);
//		btnHistory.setContentAreaFilled(false);
//		btnHistory.setAlignmentX(Component.CENTER_ALIGNMENT);
//		btnGaming.setAlignmentY(Component.CENTER_ALIGNMENT);
//		btnHistory.setActionCommand(MainMenuCommand.HISTORY.name());
//		panel.add(btnHistory,"wrap");
//		
//		btnHighScore=new JButton(new ImageIcon(ImageService.getButtonImage("highScore")));
//		btnHighScore.setBorderPainted(false);
//		btnHighScore.setContentAreaFilled(false);
//		btnHighScore.setAlignmentX(Component.CENTER_ALIGNMENT);
//		btnGaming.setAlignmentY(Component.CENTER_ALIGNMENT);
//		btnHighScore.setActionCommand(MainMenuCommand.HIGHSCORE.name());
//		panel.add(btnHighScore,"wrap");
//		
//		btnAchievement=new JButton(new ImageIcon(ImageService.getButtonImage("achievements")));
//		btnAchievement.setBorderPainted(false);
//		btnAchievement.setContentAreaFilled(false);
//		btnAchievement.setAlignmentX(Component.CENTER_ALIGNMENT);
//		btnGaming.setAlignmentY(Component.CENTER_ALIGNMENT);
//		btnAchievement.setActionCommand(MainMenuCommand.ACHIEVEMENT.name());
//		panel.add(btnAchievement,"wrap");
//		
//		btnLogout=new JButton(new ImageIcon(ImageService.getButtonImage("logout")));
//		btnLogout.setBorderPainted(false);
//		btnLogout.setContentAreaFilled(false);
//		btnLogout.setAlignmentX(Component.CENTER_ALIGNMENT);
//		btnGaming.setAlignmentY(Component.CENTER_ALIGNMENT);
//		btnLogout.setActionCommand(MainMenuCommand.LOGOUT.name());
//		panel.add(btnLogout,"wrap");
//		return panel;
//	}
//	/****************** private methods ends *************/
//
//	/****************** properties ******************/
//	// To do: setters and getters code here
//	/****************** properties ends *************/
//
//	/****************** public methods ******************/
//	public void addListener(ActionListener listener){
//		this.btnGaming.addActionListener(listener);
//		this.btnTraining.addActionListener(listener);
//		this.btnHistory.addActionListener(listener);
//		this.btnHighScore.addActionListener(listener);
//		this.btnAchievement.addActionListener(listener);
//		this.btnLogout.addActionListener(listener);
//	}
//	
////	@Override
////	protected void paintComponent(Graphics g) {
////		super.paintComponent(g);
////		g.drawImage(ImageService.getBackground(), 0, 0, getWidth(),
////				getHeight(), null);
////	}
//	/****************** public methods ends *************/

}
