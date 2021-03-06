package old.stuff;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.text.Format;
import java.text.SimpleDateFormat;

import models.ClubEnum;
import models.TrainingRecord;
import models.User;

import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import models.*;


/*
Service package to convert Training Records to the appropriate data set to feed to charts
*/

public class ChartDataService {
	
	private static final long serialVersionUID = 1654411554916481567L;
	
	/****************** attributes ***********************/

	// To do: Code here
	static User user = new User("John");
	static TrainingRecord t1 = new TrainingRecord(user, new Date(114, 2, 1), ClubEnum.IRON9, "s1", 0, 0, 0, 0, 5, 20);
	static TrainingRecord t2 = new TrainingRecord(user, new Date(114, 2, 2), ClubEnum.IRON9, "s1", 0, 0, 0, 0, 10, 30);
	static TrainingRecord t3 = new TrainingRecord(user, new Date(114, 2, 3), ClubEnum.IRON9, "s1", 0, 0, 0, 0, 5, 40);
	static TrainingRecord t4 = new TrainingRecord(user, new Date(114, 2, 4), ClubEnum.IRON9, "s1", 0, 0, 0, 0, -2, 100);
	static TrainingRecord t5 = new TrainingRecord(user, new Date(114, 2, 5), ClubEnum.IRON9, "s1", 0, 0, 0, 0, 0, 50);
	static TrainingRecord t6 = new TrainingRecord(user, new Date(114, 2, 6), ClubEnum.IRON5, "s1", 0, 0, 0, 0, 0, 120);
	static TrainingRecord t7 = new TrainingRecord(user, new Date(114, 2, 7), ClubEnum.IRON5, "s1", 0, 0, 0, 0, -8, 134);
	static TrainingRecord t8 = new TrainingRecord(user, new Date(114, 2, 8), ClubEnum.IRON5, "s1", 0, 0, 0, 0, 0, 189);
	static TrainingRecord t9 = new TrainingRecord(user, new Date(114, 2, 9), ClubEnum.IRON5, "s1", 0, 0, 0, 0, 0, 150);
	static TrainingRecord t10 = new TrainingRecord(user, new Date(114, 2, 10), ClubEnum.IRON5, "s2", 0, 0, 0, 0, 4, 165);
	static TrainingRecord t11 = new TrainingRecord(user, new Date(114, 2, 11), ClubEnum.IRON5, "s2", 0, 0, 0, 0, 0, 173);
	static TrainingRecord t12 = new TrainingRecord(user, new Date(114, 2, 12), ClubEnum.IRON5, "s2", 0, 0, 0, 0, 3, 210);
	static TrainingRecord t13 = new TrainingRecord(user, new Date(114, 2, 13), ClubEnum.IRON9, "s2", 0, 0, 0, 0, 8, 130);
	static TrainingRecord t14 = new TrainingRecord(user, new Date(114, 2, 14), ClubEnum.IRON9, "s2", 0, 0, 0, 0, 0, 128);
	static TrainingRecord t15 = new TrainingRecord(user, new Date(114, 2, 15), ClubEnum.IRON9, "s2", 0, 0, 0, 0, -6, 148);
	static TrainingRecord t16 = new TrainingRecord(user, new Date(114, 2, 16), ClubEnum.IRON9, "s2", 0, 0, 0, 0, -4, 206);
	
	public static ArrayList<TrainingRecord> traindemo = new ArrayList<TrainingRecord>() {
		{
			add(t1);
			add(t2);
			add(t3);
			add(t4);
			add(t5);
			add(t6);
			add(t6);
			add(t7);
			add(t8);
			add(t9);
			add(t10);
			add(t11);
			add(t12);
			add(t13);
			add(t14);
			add(t15);
			add(t16);
		}};

	
	//data models for the charts
	DefaultCategoryDataset distanceBarChartModel = new DefaultCategoryDataset();
	XYSeriesCollection distributionChartModel = new XYSeriesCollection();
	
//	static Connection c = null;
//    Statement stmt = null;
//    
//    static JDBCCategoryDataset distanceDBModel = new JDBCCategoryDataset(c);
	
	/****************** attributes ends ******************/

	/****************** constructor **********************/
//	
//	ChartDataService() {
//		
//	    try {
//	      Class.forName("org.sqlite.JDBC");
//	      c = DriverManager.getConnection("jdbc:sqlite:RopeItPro.db");
//	      c.setAutoCommit(false);
//	      System.out.println("Opened database successfully");
//	    }
//	    catch ( Exception e ) {
//		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//		      System.exit(0);
//		}
//	}
//	
	/****************** constructor ends ******************/

	/****************** public methods *******************/
	
	/**
	 * sets the data according the club type and dates
	 */
/*
	public static DefaultCategoryDataset generateDistData() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (TrainingRecord r : traindemo) {
			dataset.setValue(r.getzLanding(), r.getIron().name(), r.getDate());
		}
		return dataset;
	}
	*/
//	public static void updateDataModel(String userName, Date startDate, Date 
//    	    endDate, String club) {
//		try {
//			String query = null;
//			distanceDBModel.executeQuery(c, query); //execute query
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//	}
//	
	/*
	public static void main( String args[] )
	  {
	    Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:RopeItPro.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM TrainingRecord;" );
	      while ( rs.next() ) {
	         String  name = rs.getString("userName");
	         System.out.println( "NAME = " + name );
	         String date = rs.getString("date");
	         System.out.println("DATE" + date);
	         int zLanding = rs.getInt("zLanding");
	         System.out.println("ZLANDING" + zLanding);

	         System.out.println();
	      }
	      rs.close();
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Operation done successfully");
	  }*/
	/****************** public methods ends **************/

}
