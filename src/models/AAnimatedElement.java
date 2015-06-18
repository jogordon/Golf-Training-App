package models;

/**
 * 20 frames / second
 * @author tonghua
 *
 */
public abstract class AAnimatedElement extends APlotElement {

	/****************** attributes ***********************/
	private int tickCount=0;
	int totalFrames=0;
	int currentFrame=0;
	/****************** attributes ends ******************/

	/****************** constructors *********************/
	public AAnimatedElement(int totalFrames){
		this.totalFrames=totalFrames;
	}
	/****************** constructors ends ****************/

	/****************** private methods ******************/
	// To do: Code here
	/****************** private methods ends *************/

	/****************** properties ***********************/
	public int getCurrentFrameIndex(){
		return this.currentFrame;
	}
	/****************** properties ends ******************/

	/****************** public methods *******************/
	public void tickAction(){
		// monitor current frame.
		if(tickCount<5){
			tickCount++;
		}
		else{
			tickCount=0;
			if(this.currentFrame<this.totalFrames-1){
				this.currentFrame++;
			}
			else{
				this.currentFrame=0;
			}
			
			
		}
		// do other actions.
		
		
		
		
	}
	/****************** public methods ends **************/

}
