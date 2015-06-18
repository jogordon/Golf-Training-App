package models;

import java.util.Comparator;

/*
 * Sort AplotElement so they could shows up in order.
 * eg: object on Z = 90 will be blocked by object z = 80
 */
public class DistanceComparator implements Comparator<APlotElement> {
    @Override
    public int compare(APlotElement o1, APlotElement o2) {
    	 if (o1.getPosition().z < o2.getPosition().z) return 1;
         if (o1.getPosition().z > o2.getPosition().z) return -1;
         return 0;
    }
}