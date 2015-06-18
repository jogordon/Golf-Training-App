package models;

import java.awt.Color;
import java.util.ArrayList;

public class Ball extends APlotElement {

	/****************** attributes ***********************/
	Color color;
	double radius;
	Trajectory trajectory;

	int tickCounter;
	BallStatus status = BallStatus.LANDED;

	public enum BallStatus {
		ON_TEE,HIT, FLYING, LANDED
	}

	/****************** attributes ends ******************/

	/****************** constructors *********************/
	// ball constructor
	public Ball(Position position, Color color, double radius) {
		super(position, radius * 2, radius * 2);
		this.color = color;
		this.radius = radius;
		this.shadow = new Shadow(this, position.getX(), position.getZ()-this.width,
				this.width, this.height);
		this.status=BallStatus.ON_TEE;
	}
	/*
	 * Create default ball with no color.
	 */
	public Ball(Position position){
		this(position,null, 0.1);
	}

	public void ball() {

	}

	/****************** constructors ends ****************/

	/****************** private methods ******************/

	/****************** private methods ends *************/
	private void fly() {
		tickCounter++;
		if (tickCounter >= 3) {
			tickCounter = 0; // reset
			if (this.status != BallStatus.FLYING)
				this.status = BallStatus.FLYING; // set status to flying
			Position p = trajectory.getNext();
			if (p != null) {
				this.position = p;
				this.shadow.setPosition(this.position.getX(),
						this.position.getZ());
			} else {
				// this.trajectory.resetToStartPoint();
				this.status = BallStatus.LANDED;
			}

		}
	}

	/****************** properties ***********************/
	public boolean getLanded() {
		return this.status == BallStatus.LANDED;
	}
	public boolean getOnTee(){
		return this.status== BallStatus.ON_TEE;
	}
	public boolean getFlying(){
		return this.status==BallStatus.FLYING;
	}
	public Trajectory getTrajectory() {
		return this.trajectory;
	}
	public Position getLastPosition(){
		return this.trajectory.getLastPosition();
	}
	public void setTrajectory(ArrayList<Position> positions) {
		if(positions!=null)
			this.trajectory = new Trajectory(positions);
	}
	public boolean hasTrajectory(){
		if( this.trajectory==null){
			return false;
		}
		else{
			return this.trajectory.getSize()>0;
		}
	}
	/****************** properties ends ******************/

	/****************** public methods *******************/

	public void hit() {
		if(this.status==BallStatus.ON_TEE){
			this.status = BallStatus.HIT;
		}
		
	}

	@Override
	public void tickAction() {
		if (this.status == BallStatus.HIT || this.status == BallStatus.FLYING) {
			fly();
		}
	}

	public static ArrayList<Position>  getDemoTrajectory() {

		ArrayList<Position> points = new ArrayList<Position>();
		for (int i = 0; i < demoData1.length; i++) {
			Position p = new Position(demoData1[i][0], demoData1[i][2] / 5,
					demoData1[i][1]);
			points.add(p);
		}
		return points;
	}
	public void setBallOnTee(){
		this.status=BallStatus.ON_TEE;
		this.trajectory.resetToStartPoint();
	}
	/****************** public methods ends **************/

	static double[][] demoData1 = { // first column: x, second: z, third y
	{ 0, 1, 0 }, { 0, 7.0457149047, 1.4367197833 },
			{ 0, 13.7947261166, 2.9392103383 },
			{ 0, 20.2600700782, 4.4946646456 },
			{ 0, 26.4540831787, 6.0913743517 },
			{ 0, 32.3884566212, 7.7186191985 },
			{ 0, 38.0742852905, 9.3665702848 },
			{ 0, 43.5221113881, 11.026205143 },
			{ 0, 48.7419634844, 12.6892329597 },
			{ 0, 53.7433915483, 14.3480285442 },
			{ 0, 58.535498427, 15.9955738777 },
			{ 0, 63.1269681885, 17.6254062651 },
			{ 0, 67.5260916782, 19.2315722635 },
			{ 0, 71.7407895945, 20.8085866924 },
			{ 0, 75.7786333497, 22.3513961401 },
			{ 0, 79.6468639456, 23.8553464694 },
			{ 0, 83.352409067, 25.3161539063 },
			{ 0, 86.9018985735, 26.7298793618 },
			{ 0, 90.3016785471, 28.0929056911 },
			{ 0, 93.5578240436, 29.4019176504 },
			{ 0, 96.6761506801, 30.6538843505 },
			{ 0, 99.6622251868, 31.8460440484 },
			{ 0, 102.5213750468, 32.9758911498 },
			{ 0, 105.2586973517, 34.0411653298 },
			{ 0, 107.8790670044, 35.039842699 },
			{ 0, 110.3871444171, 35.9701289699 },
			{ 0, 112.7873828691, 36.8304545868 },
			{ 0, 115.0840357155, 37.6194717962 },
			{ 0, 117.2811636763, 38.336053625 },
			{ 0, 119.3826424725, 38.9792947192 },
			{ 0, 121.3921711304, 39.5485139521 },
			{ 0, 123.3132813267, 40.0432586469 },
			{ 0, 125.1493481985, 40.4633101501 },
			{ 0, 126.9036030848, 40.8086903444 },
			{ 0, 128.5791486698, 41.079668487 },
			{ 0, 130.1789769607, 41.2767675053 },
			{ 0, 131.7059903927, 41.4007685858 },
			{ 0, 133.1630261061, 41.4527125918 },
			{ 0, 134.5528830277, 41.4338965962 },
			{ 0, 135.87835083, 41.3458637165 },
			{ 0, 137.142239156, 41.1903846066 },
			{ 0, 138.3474048198, 40.9694295073 },
			{ 0, 139.4967741918, 40.6851307279 },
			{ 0, 140.5933578885, 40.3397367613 },
			{ 0, 141.6402553844, 39.9355606807 },
			{ 0, 142.6406482881, 39.4749266711 },
			{ 0, 143.5977825818, 38.9601191279 },
			{ 0, 144.5149417384, 38.3933384935 },
			{ 0, 145.3954138777, 37.7766669376 },
			{ 0, 146.2424566734, 37.1120454285 },
			{ 0, 147.0592635362, 36.4012621209 },
			{ 0, 147.8489338213, 35.6459506874 },
			{ 0, 148.6144487604, 34.8475964423 },
			{ 0, 149.3586537795, 34.007547863 },
			{ 0, 150.0842470334, 33.1270312779 },
			{ 0, 150.7937734464, 32.2071668893 },
			{ 0, 151.4896232765, 31.2489847784 },
			{ 0, 152.1740341595, 30.2534399976 },
			{ 0, 152.8490956595, 29.2214262286 },
			{ 0, 153.5167554927, 28.1537877688 },
			{ 0, 154.1788267594, 27.0513297988 },
			{ 0, 154.836995671, 25.9148270072 },
			{ 0, 155.4928294039, 24.7450307117 },
			{ 0, 156.1477838216, 23.5426746509 },
			{ 0, 156.8032108959, 22.3084796212 },
			{ 0, 157.4603657253, 21.0431571336 },
			{ 0, 158.1204130957, 19.7474122422 },
			{ 0, 158.7844335636, 18.4219456862 },
			{ 0, 159.4534290637, 17.0674554617 },
			{ 0, 160.1283280576, 15.6846379278 },
			{ 0, 160.8099902523, 14.2741885308 },
			{ 0, 161.4992109161, 12.8368022205 },
			{ 0, 162.1967248289, 11.3731736175 },
			{ 0, 162.903209897, 9.8839969817 },
			{ 0, 163.6192904667, 8.3699660225 },
			{ 0, 164.3455403673, 6.8317735861 },
			{ 0, 165.0824857101, 5.2701112468 },
			{ 0, 165.8306074713, 3.6856688256 },
			{ 0, 166.5903438811, 2.0791338562 },
			{ 0, 167.3620926408, 0.4511910132 }, { 0, 167.5764041566, 0 }

	};

}
