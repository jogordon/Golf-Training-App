package models;

public class Position {

	/****************** attributes ***********************/
	public double x, y, z;

	/****************** attributes ends ******************/

	/****************** constructors *********************/
	public Position() {

	}

	public Position(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Position(Position position) {
		this.x = position.x;
		this.y = position.y;
		this.z = position.z;
	}

	/****************** constructors ends ****************/

	/****************** private methods ******************/
	// To do: Code here
	/****************** private methods ends *************/

	/****************** properties ***********************/
	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getZ() {
		return this.z;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setZ(double z) {
		this.z = z;
	}

	/****************** properties ends ******************/

	/****************** public methods *******************/
	public Position Clone(){
		return new Position(this.x,this.y,this.z);
	}
	/****************** public methods ends **************/

}
