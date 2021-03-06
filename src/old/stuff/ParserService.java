package old.stuff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import models.Position;

public class ParserService {
	private static ParserService instance = null;
	
	public static ParserService getInstance() {
        if (instance == null) {
            instance = new ParserService();
        }
        return instance;
    }
	
    public ArrayList<Position> parse(int xCol) throws IOException {
    	double x, y, z;
    	ArrayList<Position> positions = new ArrayList<Position>();
    	String file = "./resources/ShotData.csv";
    	String line;
    	BufferedReader br = new BufferedReader(new FileReader(file));
    	br.readLine(); //Skip first line
    	while ((line = br.readLine()) != null) {
    	    // use comma as separator
    	    String[] cols = line.split(",");
    	    x = Double.parseDouble(cols[xCol]);
    	    y = Double.parseDouble(cols[xCol+1]);
    	    z = Double.parseDouble(cols[xCol+2]);
    	    positions.add(new Position(x, y, z));
    	}
    	br.close();
    	return positions;
    }
}
