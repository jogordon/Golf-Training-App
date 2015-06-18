package models;

import java.util.ArrayList;

public class Trajectory {

	/****************** attributes ***********************/
	ArrayList<Position> trajectoryPositions = new ArrayList<Position>();
	int currentPositionIndex;

	/****************** attributes ends ******************/

	/****************** constructors *********************/
	public Trajectory(ArrayList<Position> trajectoryPoints) {
		this.trajectoryPositions = trajectoryPoints;
		this.currentPositionIndex = 0;
	}

	/****************** constructors ends ****************/

	/****************** private methods ******************/
	// To do: Code here
	/****************** private methods ends *************/

	/****************** properties ***********************/
	public Boolean isLanded() {
		return this.currentPositionIndex >= (this.trajectoryPositions.size() - 1);
	}

	public int getCurrentPositionIndex() {
		return this.currentPositionIndex;
	}
	
	/**
	 * get how many points.
	 * 
	 * @return
	 */
	public int getSize() {
		return this.trajectoryPositions.size();
	}

	public ArrayList<Position> getPositions() {
		return this.trajectoryPositions;
	}
	public Position getLastPosition(){
		return this.trajectoryPositions.get(getSize()-1);
	}
	public double getMaxHeight() {
		return Trajectory.getMaxHeight(trajectoryPositions);
	}
	public static double getMaxHeight(ArrayList<Position> trajectoryPositions){
		double max = Integer.MIN_VALUE;
		for (Position p : trajectoryPositions) {
			if (p.y > max)
				max = p.y;
		}
		return max;
	}
	public double getMaxDistance(){
		return this.trajectoryPositions.get(this.trajectoryPositions.size()-1).getZ();
	}
	
	/****************** properties ends ******************/

	/****************** public methods *******************/
	public Position getNext() {
		if (this.trajectoryPositions == null
				|| this.trajectoryPositions.size() == 0) {
			return null;
		}
		if (this.currentPositionIndex < this.trajectoryPositions.size()) {
			return this.trajectoryPositions.get(this.currentPositionIndex++);
		} else {
			return null;
		}
	}

	public void resetToStartPoint() {
		this.currentPositionIndex = 0;
	}

	/*
	 * make a copy of trajectory ball already passed,
	 */
	public Trajectory getPassedTrajectory() {
		ArrayList<Position> points = new ArrayList<Position>();
		for (int i = 0; i < this.currentPositionIndex; i++) {
			points.add(this.trajectoryPositions.get(i));
		}
		return new Trajectory(points);
	}
	/****************** public methods ends **************/

}
