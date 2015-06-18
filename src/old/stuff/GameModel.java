package old.stuff;

import java.util.ArrayList;

import models.Ball;
import models.Cloud;
import models.Tee;

public class GameModel extends PlayModel {

	private ArrayList<Tree> trees;
	private ArrayList<Trap> traps;
	private Green green;
	private Hole hole;
	private int score;
	
	//gameModel constructor
	public GameModel(int x, int y, int z, Ball ball, Tee tee, String club, ArrayList<Cloud> clouds, 
					ArrayList<Tree> trees, ArrayList<Trap> traps, Green green, Hole hole, int score) {}
	
	public Green getGreen() {
		return green;
	}
	
	public void setGreen(Green green) {
		this.green = green;
	}
	
	public Hole getHole() {
		return hole;
	}
	
	public void setHole(Hole hole) {
		this.hole = hole;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public ArrayList<Tree> getTrees() {
		return trees;
	}
	
	public void setClouds(ArrayList<Cloud> clouds) {
		
	}
	
	public ArrayList<Trap> getTraps() {
		return traps;
	}
	
	public void setTrap(ArrayList<Trap> traps) {}
}
