package models;

import java.util.ArrayList;

public class GreenView extends APlotElement {
	/****************** attributes ***********************/
	Position center; // target position.
	ArrayList<Position> landedBallPositions;
	Position flyingBallPosition;//=new Position(15, 0, 215);
	double viewSize; // what area the green will covert in yards
	/****************** attributes ends ******************/

	/****************** constructors *********************/
	public GreenView(Position position, double width, double height, 
			Position center,
			double viewSize){
		super(position, width, height);
		this.center=center;
		this.landedBallPositions=new ArrayList<Position>();
		
		this.viewSize=viewSize;
	}
	/****************** constructors ends ****************/

	/****************** private methods ******************/
	private double getYardsToCenterX(double x){
		return x-this.center.x;
	}
	private double getYardsToCenterZ(double z){
		return z-this.center.z;
	}
	private double calculateAbsoluteX(double x){
		System.out.println("abs X " + getYardsToCenterX(x));
		return this.viewSize/2+getYardsToCenterX(x);
	}
	private double calculateAbsoluteZ(double z){
		System.out.println("abs Z " +getYardsToCenterZ(z));
		return this.viewSize/2+getYardsToCenterZ(z);
	}
	/****************** private methods ends *************/

	/****************** properties ***********************/
	public ArrayList<Position> getLandedPositions(){
		return this.landedBallPositions;
	}
	public Position getFlyingPosition(){
		return this.flyingBallPosition;
	}
	public double getFlyBallToCenterDistanceX(){
		return this.flyingBallPosition.x-this.center.x;
	}
	public double getFlyBallToCenterDistanceZ(){
		return this.flyingBallPosition.z-this.center.z;
	}
	public double getViewSize(){
		return this.viewSize;
	}
	/*
	 *  Top left point would be (0,0)
	 */
	public double getFlyBallAbsoluteX(){
		return calculateAbsoluteX(this.flyingBallPosition.x);
	}
	public double getFlyBallAbsoluteZ(){
		return calculateAbsoluteZ(this.flyingBallPosition.z);
	}
	public ArrayList<Position> getLandedBallsAbsolute(){
		ArrayList<Position> absPositions= new ArrayList<Position>();
		if(this.landedBallPositions.size()>0){
			for(Position p: this.landedBallPositions){
				double absX = calculateAbsoluteX(p.x);
				double absZ = calculateAbsoluteZ(p.z);
				absPositions.add(new Position(absX, 0 , absZ));
			}
			return absPositions;
		}
		else{
			return null;
		}
		
	}
	/****************** properties ends ******************/

	/****************** public methods *******************/
	/*
	 * if ball is flying, display it as flying dot, 
	 * if landed, add to landedBallPositions.
	 */
	public void updateBall(Ball ball){
		if(ball==null){
			return;
		}
		if(ball.getFlying()){
			this.flyingBallPosition=ball.getPosition().Clone();
		}
		else if(ball.getLanded()){
			if(this.flyingBallPosition!=null){
				this.landedBallPositions.add(flyingBallPosition);
			}
		}
	}
	public void reset(){
		this.flyingBallPosition=null;
		this.landedBallPositions.clear();
	}
	/****************** public methods ends **************/
}
