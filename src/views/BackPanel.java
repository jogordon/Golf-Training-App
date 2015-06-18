package views;

import java.awt.Graphics;
import javax.swing.JPanel;
import service.ImageService;

public class BackPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	@Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	        g.drawImage(ImageService.getBackPanelImage(), 0, 0, getWidth(),getHeight(),null);
	}
	
//	@Override
//	public void paint(Graphics g){
//		paintComponent(g);
//		g.drawImage(ImageService.getBackPanelImage(),0,0,getWidth(),getHeight(),null);
//		
//	}
}
