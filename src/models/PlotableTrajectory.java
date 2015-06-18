package models;


public class PlotableTrajectory extends APlotElement {

	/****************** attributes ***********************/
	Trajectory trajectory;
	/****************** attributes ends ******************/

	/****************** constructors *********************/
	public PlotableTrajectory(Position position, double width, double height){
		super(position, width, height);
	}
	/****************** constructors ends ****************/

	/****************** private methods ******************/
	// To do: Code here
	/****************** private methods ends *************/

	/****************** properties ***********************/
	public Trajectory getTrajectory(){
		return this.trajectory;
	}
	/****************** properties ends ******************/

	/****************** public methods *******************/
	/*
	 * make a copy of trajectory ball already passed,
	 * so image service could draw it.
	 * @param t ball's trajectory
	 */
	public void updateTrajectory(Ball ball){
		if(ball == null){
			return;
		}
		if(ball.hasTrajectory()==false){
			return;
		}
		this.trajectory=ball.getTrajectory().getPassedTrajectory();
	}
	public void reset(){
		this.trajectory=null;
	}
	/****************** public methods ends **************/

}
