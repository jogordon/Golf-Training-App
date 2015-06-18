package models;

public class WelcomeScenario extends Scenario {

	/****************** attributes ***********************/
	// To do: Code here
	/****************** attributes ends ******************/

	/****************** constructors *********************/
	// To do: Code here
	/****************** constructors ends ****************/

	/****************** private methods ******************/
	// To do: Code here
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
				this.addNewBall(Ball.getDemoTrajectory());
			}
		} else {
			this.addNewBall(Ball.getDemoTrajectory());
		}
		
		this.hitABall();
		super.tickAction();
		
	}
	/****************** public methods ends **************/

}
