package models;

import java.util.Date;

public class TrainingRecord extends Record {

	/****************** attributes ***********************/

	String session;
	double velocity;
	double vertAngle;
	double horzAngle;
	double spin;
	double xLanding;
	double zLanding;
	ClubEnum iron;
	/****************** attributes ends ******************/

	/****************** constructors *********************/
	public TrainingRecord(User user, Date date, ClubEnum iron, String session,
			double velocity, double vertAngle, double horzAngle, double spin,
			double xLanding, double zLanding) {
		super(user, date);
		// TODO Auto-generated constructor stub
		this.session = session;
		this.velocity = velocity;
		this.vertAngle = vertAngle;
		this.horzAngle = horzAngle;
		this.spin = spin;
		this.xLanding = xLanding;
		this.zLanding = zLanding;
		this.iron = iron;
	}
	/****************** constructors ends ****************/

	/****************** private methods ******************/
	// To do: Code here
	/****************** private methods ends *************/

	/****************** properties ***********************/
	public void setSession(String session) {
		this.session = session;
	}

	public String getSession() {
		return session;
	}

	// setLanding point on plot
	public void setLanding(double xLanding, double zLanding) {
		this.xLanding = xLanding;
		this.zLanding = zLanding;
	}

	public void setxLanding(double xLanding) {
		this.xLanding = xLanding;
	}

	public void setzLanding(double zLanding) {
		this.zLanding = zLanding;
	}

	public double getxLanding() {
		return this.xLanding;
	}

	public double getzLanding() {
		return this.zLanding;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public double getVelocity() {
		return this.velocity;
	}

	public double getvertAngle() {
		return this.vertAngle;
	}

	public double gethorzAngle() {
		return this.horzAngle;
	}

	public double getSpin() {
		return this.spin;
	}

	public void setSpin(double spin) {
		this.spin = spin;
	}
	public void setIron(ClubEnum iron) {
		this.iron = iron;
	}
	
	public ClubEnum getIron() {
		return this.iron;
	}
	/****************** properties ends ******************/

	/****************** public methods *******************/
	// To do: Code here
	/****************** public methods ends **************/




	

	public String toString() {
		return "User: " + user + " Date: " + date + "xLanding: " + xLanding
				+ " yLanding: " + zLanding;
	}

}
