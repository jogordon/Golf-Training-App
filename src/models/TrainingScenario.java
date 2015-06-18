package models;

public class TrainingScenario extends Scenario {

	/****************** attributes ***********************/
	
	/****************** attributes ends ******************/

	/****************** constructors *********************/
	// To do: Code here
	/****************** constructors ends ****************/

	/****************** private methods ******************/
	@Override
	protected void setup() {

		// draw BallStatusInfor board
		ballInfoBoard = new BallStatusInfo(new Position(2, 0, 2), 1.2, 1);
		this.plotElements.add(ballInfoBoard);

		// draw trajectory board
		trajectoryBoard = new PlotableTrajectory(new Position(-2, 0, 2), 1.2, 1);
		this.plotElements.add(trajectoryBoard);

		this.hitMeBubble=new HitMeBubble(new Position(0,1,1), 1.26, 0.37);
		this.plotElements.add(this.hitMeBubble);
		super.setup();
	}

	/****************** private methods ends *************/

	/****************** properties ***********************/
	// To do: setters and getters code here
	/****************** properties ends ******************/

	/****************** public methods *******************/
	@Override
	public void tickAction() {
		// track activated ball status
		if (this.activatedBall != null) {
			if (this.activatedBall.getLanded()) { // landed, create a new one
				// randomly generate trajectory for the ball
				this.addNewBall();
			}
		} else {
			this.addNewBall();
		}

		// assign ball to ballInfoBoard
		this.ballInfoBoard.updateInfo(this.activatedBall);
		//
		this.trajectoryBoard.updateTrajectory(this.activatedBall);
		super.tickAction();
	}
	
	/****************** public methods ends **************/

}
