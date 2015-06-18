package models;

public class PlotMessenger {

	/****************** attributes ***********************/
	PlotInfo plotElementInfo;
	PlotInfo shadowInfo;
	
	/****************** attributes ends ******************/

	/****************** constructors *********************/
	public PlotMessenger(PlotInfo plotElementInfo,PlotInfo shadowInfo){
		this.plotElementInfo=plotElementInfo;
		this.shadowInfo=shadowInfo;
	}
	/****************** constructors ends ****************/

	/****************** private methods ******************/
	// To do: Code here
	/****************** private methods ends *************/

	/****************** properties ***********************/
	public PlotInfo getPlotElementInfo(){
		return this.plotElementInfo;
	}
	public PlotInfo getShadowInfo(){
		return this.shadowInfo;
	}
	/****************** properties ends ******************/

	/****************** public methods *******************/
	// To do: Code here
	/****************** public methods ends **************/

}
