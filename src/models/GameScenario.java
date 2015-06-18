package models;


public class GameScenario extends Scenario {

	/****************** attributes ***********************/
	Flag flag;
	GreenView greenView;


	/****************** attributes ends ******************/

	/****************** constructors *********************/
	// To do: Code here
	/****************** constructors ends ****************/

	/****************** private methods ******************/
	@Override
	protected void setup() {
		// add flag
		flag = new Flag(new Position(0, 0, 150), 1, 4);
		this.plotElements.add(flag);
		// add orcs
		Orc orc1 = new Orc(10, new Position(-16, 0, 151), 1, 1);
		this.plotElements.add(orc1);
		Orc orc = new Orc(10, new Position(-10, 0, 89), 1, 1);
		this.plotElements.add(orc);

		// draw BallStatusInfor board
		ballInfoBoard = new BallStatusInfo(new Position(2, 0, 2), 1.2, 1);
		this.plotElements.add(ballInfoBoard);

		// draw trajectory board
		trajectoryBoard = new PlotableTrajectory(new Position(-2, 0, 2), 1.2, 1);
		this.plotElements.add(trajectoryBoard);
		
		// draw green view
		// center of this green is (0,0,150), view range is radius 40 yards
		this.greenView=new GreenView(new Position(-5,0.5,2), 1.5, 1.5, new Position(0,0,150), 40);
		this.plotElements.add(this.greenView);
		
		// hit me 
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
		// update green view
		this.greenView.updateBall(activatedBall);
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

	public double getBallLandedDistanceToFlag() {
		Position p = this.activatedBall.getLastPosition();
		double square = Math.pow(p.x - this.flag.getPosition().x, 2)
				+ Math.pow(p.z - this.flag.getPosition().z, 2);
		return Math.pow(square, 0.5);
	}
	@Override
	public void reset(){
		super.reset();
		this.greenView.reset();
	}
	
	/****************** public methods ends **************/

}
