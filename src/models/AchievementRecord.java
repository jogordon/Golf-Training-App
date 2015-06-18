package models;

public class AchievementRecord {
	
	User user;
	boolean twoHundred;
	boolean powerShot;
	boolean inOrbit;
	boolean steadyForm;
	boolean sharpShooter;
	boolean theRobot;
	boolean amateurChamp;
	boolean tourPro;
	boolean majorChamp;

	public AchievementRecord(User user, boolean twoHundred, boolean powerShot,
			boolean inOrbit, boolean steadyForm, boolean sharpShooter, boolean theRobot,
			boolean amateurChamp, boolean tourPro, boolean majorChamp) {
		this.user = user;
		this.twoHundred = twoHundred;
		this.powerShot = powerShot;
		this.inOrbit = inOrbit;
		this.steadyForm = steadyForm;
		this.sharpShooter = sharpShooter;
		this.theRobot = theRobot;
		this.amateurChamp = amateurChamp;
		this.tourPro = tourPro;
		this.majorChamp = majorChamp;
	}
	
	public User getUser() {
		return this.user;
	}
		
	public boolean getTwoHundred() {
		return this.twoHundred;
	}
	
	public boolean getPowerShot() {
		return this.powerShot;
	}
	
	public boolean getInOrbit() {
		return this.inOrbit;
	}
	
	public boolean getSteadyForm() {
		return this.steadyForm;
	}
	
	public boolean getSharpShooter() {
		return this.sharpShooter;
	}
	
	public boolean getTheRobot() {
		return this.theRobot;
	}
	
	public boolean getAmateurChamp() {
		return this.amateurChamp;
	}
	
	public boolean getTourPro() {
		return this.tourPro;
	}
	
	public boolean getMajorChamp() {
		return this.majorChamp;
	}
}
