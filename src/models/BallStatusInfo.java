package models;

public class BallStatusInfo extends APlotElement {

	/****************** attributes ***********************/
	private double ballHeight;
	private double ballDistance;
	/****************** attributes ends ******************/

	/****************** constructors *********************/
	public BallStatusInfo(Position position, double width, double height){
		super(position, width, height);
	}
	/****************** constructors ends ****************/

	/****************** private methods ******************/
	// To do: Code here
	/****************** private methods ends *************/

	/****************** properties ***********************/
	
	/****************** properties ends ******************/

	/****************** public methods *******************/
	/*
	 *  display ball information
	 *  if no ball, will remain last value.
	 */
	public void updateInfo(Ball ball){
		if(ball!=null){
			this.ballHeight=ball.getPosition().getY();
			this.ballDistance=ball.getPosition().getZ();
		}
	}
	
	public double getBallHeight(){
		return this.ballHeight;
	}
	
	public double getBallDistance(){
		return this.ballDistance;
	}
	
	@Override
	public String toString(){
		String strBallDistance = String.format("%1$,.1f",  Math.max(this.ballDistance - 0.7, 0));
		String strBallHeight = String.format("%1$,.1f",  Math.max(this.ballHeight - 0.2, 0));
		return "Distance: " + strBallDistance +"\r\n" +
				"Height: " + strBallHeight ;
	}
	public void reset(){
		this.ballDistance=0;
		this.ballHeight=0;
	}
	/****************** public methods ends **************/

}
