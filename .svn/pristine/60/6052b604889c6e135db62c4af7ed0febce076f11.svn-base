package models;

public abstract class APlotElement {

	/****************** attributes ***********************/
	Position position;
	double height;
	double width;
	protected Shadow shadow; 
	/****************** attributes ends ******************/

	/****************** constructors *********************/
	public APlotElement(){}
	public APlotElement(Position position, double width, double height){
		this.position=position;
		this.width=width;
		this.height=height;
	}
	/****************** constructors ends ****************/

	/****************** private methods ******************/
	protected void setCurrentShadow(){
		
	}
	/****************** private methods ends *************/

	/****************** properties ***********************/
	public Position getPosition() {
		return position;
	}

	/**
	 * Height when Z = 0
	 * @return
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * Width when Z = 0
	 * @return
	 */
	public double getWidth() {
		return width;
	}
	public Shadow getShadow(){
		return this.shadow;
	}
	/****************** properties ends ******************/

	/****************** public methods *******************/
	public void tickAction(){
		
	}
	/****************** public methods ends **************/

}
