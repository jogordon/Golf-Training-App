package old.stuff;

import java.util.ArrayList;

public class TrainingModel extends PlayModel {
	
	ArrayList distances;
	
	//training model constructor
	public TrainingModel(ArrayList distances){
		this.distances = distances;
	}
	 
	 public String getDistances(){
		 return distances.toString();
	 }

}
