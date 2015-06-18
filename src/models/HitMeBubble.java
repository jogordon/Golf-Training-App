package models;

public class HitMeBubble extends APlotElement {

	/****************** attributes ***********************/
	final int  TOTAL_MOVE_STEPS=6;
	double step ; // yard
	int currentStep;
	double originalY;
	double distanceToMove;
	boolean isDownWard; // false = upward
	int slowDownCounter;
	/****************** attributes ends ******************/

	/****************** constructors *********************/
	public HitMeBubble(Position position, double width, double height){
		super(position, width, height);
		this.originalY=position.y;
		this.distanceToMove=height/4; // move half of its height.
		this.step=this.distanceToMove/ TOTAL_MOVE_STEPS;
		this.isDownWard=true;
	}
	/****************** constructors ends ****************/

	/****************** private methods ******************/
	// To do: Code here
	/****************** private methods ends *************/

	/****************** properties ***********************/
	// To do: setters and getters code here
	/****************** properties ends ******************/

	/****************** public methods *******************/
	@Override
	public void tickAction(){
		slowDownCounter++;
		if(slowDownCounter<5){
			return;
		}
		slowDownCounter=0;
		if(this.isDownWard){
			this.position.y-=this.step;
			this.currentStep++;
			if(this.currentStep>=TOTAL_MOVE_STEPS){
				this.isDownWard=false;
				this.currentStep=0;
			}
		}
		else{
			this.position.y+=this.step;
			this.currentStep++;
			if(this.currentStep>=TOTAL_MOVE_STEPS){
				this.isDownWard=true;
				this.currentStep=0;
			}
		}
		
		
	}
	/****************** public methods ends **************/

}
