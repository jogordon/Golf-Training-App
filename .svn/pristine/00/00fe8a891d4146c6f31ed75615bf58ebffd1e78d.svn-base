package models;

public class Orc extends AAnimatedElement {

	

	/****************** attributes ***********************/
	// To do: Code here
	/****************** attributes ends ******************/

	/****************** constructors *********************/
	public Orc(int totalFrames, Position position, double width, double height) {
		super(totalFrames);
		super.position=position;
		super.width=width;
		super.height=height;
	}
	/****************** constructors ends ****************/

	/****************** private methods ******************/
	// To do: Code here
	/****************** private methods ends *************/

	/****************** properties ***********************/
	// To do: setters and getters code here
	/****************** properties ends ******************/

	/****************** public methods *******************/
	public void tickAction(){
		super.tickAction();
		if(this.position.getX()<16){
			this.position.setX(this.position.getX()+0.02);
		}
		else{
			this.position.setX(-16);
		}
	}
	/****************** public methods ends **************/

}
