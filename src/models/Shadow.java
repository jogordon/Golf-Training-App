package models;

public class Shadow extends APlotElement{

	/****************** attributes ***********************/
	// object who owns this shadow
	APlotElement parent;
	/****************** attributes ends ******************/

	/****************** constructors *********************/
	public Shadow(APlotElement parent, double x, double z, double width, double height){
		this.parent=parent;
		this.position=new Position(x,0,z);
		this.width=width;
		this.height=height;
		this.shadow=null; // shadow's shadow is null
	}
	/****************** constructors ends ****************/

	/****************** private methods ******************/
	// To do: Code here
	/****************** private methods ends *************/

	/****************** properties ***********************/
	public void setPosition(double x, double z){
		this.position.setX(x);
		this.position.setZ(z);
		if(this.position.getY()!=0){
			this.position.setY(0.0);
		}
	}
	@Override
	public Shadow getShadow(){
		return null;
	}
	public APlotElement getParent(){
		return this.parent;
	}
	/****************** properties ends ******************/

	/****************** public methods *******************/
	// To do: Code here
	/****************** public methods ends **************/

}
