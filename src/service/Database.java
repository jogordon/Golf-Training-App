package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.Locale;
import java.text.Format;
import java.text.SimpleDateFormat;
import models.AchievementRecord;
import models.ClubEnum;
import models.GameRecord;
import models.TrainingRecord;
import models.User;

public class Database {
	private static Database instance = null;
    private static Connection con;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public Database(){
        try{
            //MAKE SURE YOU KEEP THE sqlite_connector.jar file in java/lib folder
            //ALSO SET THE CLASSPATH
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:RopeItPro.db"); 
            Statement statement = con.createStatement();
            statement.executeUpdate("PRAGMA foreign_keys = ON");
            statement.close();
            createTables();
           }
        catch (Exception e) 
        {
            System.out.println(e);
        }

    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
    private static void createTables() throws SQLException {
    	Statement statement = con.createStatement();
		String sql = "CREATE TABLE IF NOT EXISTS User(userName VARCHAR(25), "
				     + "password VARCHAR(25), PRIMARY KEY(userName))";
		statement.executeUpdate(sql);
		sql = "CREATE TABLE IF NOT EXISTS TrainingRecord(userName VARCHAR(25), "
				  + "date VARCHAR(35), iron VARCHAR(15), session VARCHAR(20), velocity "
				  + "REAL, vertAngle REAL, horzAngle REAL, spin REAL, xLanding REAL, "
				  + "zLanding REAL, PRIMARY KEY(userName, date), FOREIGN KEY(userName) "
				  + "REFERENCES User(userName) ON DELETE CASCADE ON UPDATE CASCADE)";
		statement.executeUpdate(sql);
		sql = "CREATE TABLE IF NOT EXISTS GameRecord(userName VARCHAR(25), "
			  + "score INTEGER, date VARCHAR(35), PRIMARY KEY(userName, date), "
			  + "FOREIGN KEY(userName) REFERENCES User(userName) ON DELETE "
			  + "CASCADE ON UPDATE CASCADE)";
		statement.executeUpdate(sql);
		sql = "CREATE TABLE IF NOT EXISTS Achievements(userName VARCHAR(25), "
			  + "TwoHundred BOOLEAN NOT NULL CHECK (TwoHundred IN (0, 1)), "
			  + "PowerShot BOOLEAN NOT NULL CHECK (PowerShot IN (0, 1)), "
			  + "InOrbit BOOLEAN NOT NULL CHECK (InOrbit IN (0, 1)), "
			  + "SteadyForm BOOLEAN NOT NULL CHECK (SteadyForm IN (0, 1)), "
			  + "Sharpshooter BOOLEAN NOT NULL CHECK (Sharpshooter IN(0, 1)), "
			  + "TheRobot BOOLEAN NOT NULL CHECK (TheRobot IN (0, 1)), "
			  + "AmateurChamp BOOLEAN NOT NULL CHECK (AmateurChamp IN (0, 1)), "
			  + "TourPro BOOLEAN NOT NULL CHECK (TourPro IN (0, 1)), "
			  + "MajorChamp BOOLEAN NOT NULL CHECK (MajorChamp IN (0, 1)), "
			  + "AccuracyCount INTEGER, PRIMARY KEY(userName), FOREIGN KEY(userName) "
			  + "REFERENCES User(userName) ON DELETE CASCADE ON UPDATE CASCADE)";
		statement.executeUpdate(sql);
		sql = "CREATE TRIGGER IF NOT EXISTS AccuracyTrigger AFTER INSERT ON "
				+ "TrainingRecord FOR EACH ROW WHEN NEW.horzAngle >= -3 AND NEW.horzAngle <= 3 "
				+ "BEGIN UPDATE Achievements SET AccuracyCount = AccuracyCount + 1 "
				+ "WHERE Achievements.userName = NEW.userName; END;";
		statement.executeUpdate(sql);
		sql = "CREATE TRIGGER IF NOT EXISTS InaccurateTrigger AFTER INSERT ON "
				+ "TrainingRecord FOR EACH ROW WHEN NEW.horzAngle < -3 OR NEW.horzAngle > 3 "
				+ "BEGIN UPDATE Achievements SET AccuracyCount = 0 "
				+ "WHERE Achievements.userName = NEW.userName; END;";
		statement.executeUpdate(sql);
		sql = "CREATE TRIGGER IF NOT EXISTS SteadyFormTrigger AFTER UPDATE OF AccuracyCount ON "
			  + "Achievements WHEN (NEW.AccuracyCount >= 5) AND (OLD.AccuracyCount < 5) "
			  + "BEGIN UPDATE Achievements SET SteadyForm = 1 WHERE AccuracyCount >= 5 ; END;";
		statement.executeUpdate(sql);
		sql = "CREATE TRIGGER IF NOT EXISTS SharpshooterTrigger AFTER UPDATE OF AccuracyCount "
			  + "ON Achievements WHEN (NEW.AccuracyCount >= 20) AND (OLD.AccuracyCount < 20) "
			  + "BEGIN UPDATE Achievements SET Sharpshooter = 1 WHERE AccuracyCount >= 20; END;";
		statement.executeUpdate(sql);
		sql = "CREATE TRIGGER IF NOT EXISTS TheRobotTrigger AFTER UPDATE OF AccuracyCount ON "
			  + "Achievements WHEN (NEW.AccuracyCount >= 50) AND (OLD.AccuracyCount < 50) "
			  + "BEGIN UPDATE Achievements SET TheRobot = 1 WHERE AccuracyCount >= 50; END;";
		statement.executeUpdate(sql);
		sql = "CREATE TRIGGER IF NOT EXISTS TwoHundredTrigger AFTER INSERT ON "
			  + "TrainingRecord FOR EACH ROW WHEN NEW.zLanding >= 200 "
			  + "BEGIN UPDATE Achievements SET TwoHundred = 1 "
			  + "WHERE Achievements.userName = NEW.userName; END;";
		statement.executeUpdate(sql);
		sql = "CREATE TRIGGER IF NOT EXISTS PowerShotTrigger AFTER INSERT ON "
			  + "TrainingRecord FOR EACH ROW WHEN NEW.zLanding >= 225 "
			  + "BEGIN UPDATE Achievements SET PowerShot = 1 "
			  + "WHERE Achievements.userName = NEW.userName; END;";
		statement.executeUpdate(sql);
		sql = "CREATE TRIGGER IF NOT EXISTS InOrbitTrigger AFTER INSERT ON "
			  + "TrainingRecord FOR EACH ROW WHEN NEW.zLanding >= 250 "
			  + "BEGIN UPDATE Achievements SET InOrbit = 1 "
			  + "WHERE Achievements.userName = NEW.userName; END;";
		statement.executeUpdate(sql);
		sql = "CREATE TRIGGER IF NOT EXISTS AmateurChampTrigger AFTER INSERT ON "
				  + "GameRecord FOR EACH ROW WHEN NEW.score >= 10000 "
				  + "BEGIN UPDATE Achievements SET AmateurChamp = 1 "
				  + "WHERE Achievements.userName = NEW.userName; END;";
		statement.executeUpdate(sql);
		sql = "CREATE TRIGGER IF NOT EXISTS TourProTrigger AFTER INSERT ON "
				  + "GameRecord FOR EACH ROW WHEN NEW.score >= 15000 "
				  + "BEGIN UPDATE Achievements SET TourPro = 1 "
				  + "WHERE Achievements.userName = NEW.userName; END;";
		statement.executeUpdate(sql);
		sql = "CREATE TRIGGER IF NOT EXISTS MajorChampTrigger AFTER INSERT ON "
				  + "GameRecord FOR EACH ROW WHEN NEW.score >= 20000 "
				  + "BEGIN UPDATE Achievements SET MajorChamp = 1 "
				  + "WHERE Achievements.userName = NEW.userName; END;";
		statement.executeUpdate(sql);
		statement.close();
    }    
    public boolean createNewUser(String userName, String password) {
    	try {
			Statement statement = con.createStatement();
			String sql = "INSERT INTO User (userName, password) VALUES ('"
						 + userName + "', '" + password + "')";
			statement.executeUpdate(sql);
			sql = "INSERT INTO Achievements(userName, TwoHundred, PowerShot, InOrbit, SteadyForm,"
				  + "Sharpshooter, TheRobot, AmateurChamp, TourPro, MajorChamp, AccuracyCount) "
				  + "VALUES ('" + userName + "', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)";
			statement.executeUpdate(sql);
			statement.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
    	//return true;
    }
    
    public boolean login(String userName, String password){
        try {
        	pst=con.prepareStatement("SELECT * FROM User WHERE userName=? AND password=?");
            pst.setString(1, userName); //this replaces the 1st  "?" in the query for username
            pst.setString(2, password);    //this replaces the 2nd  "?" in the query for password
            //executes the prepared statement
            rs=pst.executeQuery();
            if(rs.next())
            {
            	pst.close();
                //TRUE iff the query founds any corresponding data
                return true;
            }
            else
            {
            	pst.close();
                return false;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("error while validating "+e);
            return false;
        }
    }
    
    public boolean insertTrainingRecord(TrainingRecord record) {
    	Format formatter = new SimpleDateFormat("yyyyMMddHHmmss.s");
    	String date = formatter.format(record.getDate());
    	try {
    	Statement statement = con.createStatement();
		String sql = "INSERT INTO TrainingRecord (userName , date, iron, session, "
					+ "velocity, vertAngle, horzAngle, spin, xLanding, zLanding) "
					+ "VALUES ('" + record.getUser().getName() + "', '" + date
					+ "', '" + record.getIron() + "', '" + record.getSession() 
					+ "', '" + record.getVelocity() + "', '" + record.getvertAngle()
					+ "', '" + record.gethorzAngle() + "', '" + record.getSpin()
					+ "', '" + record.getxLanding() + "', '" + record.getzLanding()
					+ "')";
		statement.executeUpdate(sql);
		statement.close();
    	} catch(SQLException e) {
    		System.out.println(e);
    		return false;
    	}
    	return true;
    }
    
    public boolean insertGameRecord(GameRecord record) {
    	Format formatter = new SimpleDateFormat("yyyyMMddHHmmss.s");
    	String date = formatter.format(record.getDate());
    	try {
    	Statement statement = con.createStatement();
		String sql = "INSERT INTO GameRecord (userName, score, date) VALUES ('"
					 + record.getUser().getName() + "', " + record.getScore() + ", '"
					 + date + "')";
		statement.executeUpdate(sql);
		statement.close();
    	} catch(SQLException e) {
    		System.out.println("Test1");
    		System.out.println(e);
    		System.out.println("Test2");
    		return false;
    	}
    	return true;
    }
    
    public ArrayList<TrainingRecord> getTrainingRecords(String userName, Date startDate, Date 
    	    endDate, String club) {
    	Format formatter = new SimpleDateFormat("yyyyMMddHHmmss.s");
    	String start = formatter.format(startDate);
    	String end = formatter.format(endDate);
    	ArrayList<TrainingRecord> records = new ArrayList<TrainingRecord>();
    	String sql = "SELECT * FROM TrainingRecord WHERE userName = '"+ userName + "'";
    	if(startDate != null) {
    		sql += " AND date >= '" + start + "'";
    	}
    	if(endDate != null) {
    		sql += " AND date <= '" + end + "'";
    	}
    	if(club != "All") {
    		sql += " AND iron = '" + club + "'";
    	}
        try {
        	Statement statement = con.createStatement();
        	PreparedStatement stm = con.prepareStatement(sql);
            //executes the prepared statement
            ResultSet rs= stm.executeQuery();
            if (!rs.isBeforeFirst() ) {    
            } 
            while(rs.next()) {
            	User load_user = new User(rs.getString(1));
            	Date load_date = new SimpleDateFormat("yyyyMMddHHmmss.s", 
            			Locale.ENGLISH).parse(rs.getString(2));
            	String string_iron = rs.getString(3);
            	ClubEnum load_iron = null;
            	if(string_iron.equals("IRON5")){
            		load_iron = ClubEnum.IRON5;
            	}
            	else if(string_iron.equals("IRON9")) {
            		load_iron = ClubEnum.IRON9;
            	}
            	String load_session = rs.getString(4);
            	double load_velocity = rs.getDouble(5);
            	double load_vert_angle = rs.getDouble(6);
            	double load_horz_angle = rs.getDouble(7);
            	double load_spin = rs.getDouble(8);
            	double load_xlanding = rs.getDouble(9);
            	double load_zlanding = rs.getDouble(10);
            	records.add(new TrainingRecord(load_user, load_date, load_iron, load_session, load_velocity,
            			load_vert_angle, load_horz_angle, load_spin, load_xlanding, load_zlanding));
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return records;
    }
    public AchievementRecord getAchievements(User user) {
    	String sql = "SELECT * FROM Achievements WHERE userName = '" + user.getName() + "'";
    	try {
    		Statement statement = con.createStatement();
    		rs = statement.executeQuery(sql);
    		User load_user = new User(rs.getString(1));
    		boolean twoHundred = rs.getBoolean(2);
    		boolean powerShot = rs.getBoolean(3);
    		boolean inOrbit = rs.getBoolean(4);
    		boolean steadyForm = rs.getBoolean(5);
    		boolean sharpShooter = rs.getBoolean(6);
    		boolean theRobot = rs.getBoolean(7);
    		boolean amateurChamp = rs.getBoolean(8);
    		boolean tourPro = rs.getBoolean(9);
    		boolean majorChamp = rs.getBoolean(10);
    		statement.close();
        	return new AchievementRecord(load_user, twoHundred, powerShot, inOrbit, 
        			steadyForm, sharpShooter, theRobot, amateurChamp, tourPro, majorChamp);
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    	return null;
    }
    public ArrayList<Date> getRecordDates(User user) {
    	ArrayList<Date> dates = new ArrayList<Date>();
    	String sql = "Select date FROM TrainingRecord WHERE userName = '" + user.getName() + "'";
    	try {
    		Statement statement = con.createStatement();
    		rs = statement.executeQuery(sql);
    		boolean unique;
    		while(rs.next()) {
    			unique = true;
    			Date date = new SimpleDateFormat("yyyyMMddHHmmss.s", Locale.ENGLISH)
    			.parse(rs.getString(1));
    	        Calendar calendar = Calendar.getInstance();
    	        calendar.setTime(date);
    	        calendar.set(Calendar.MILLISECOND, 0);
    	        calendar.set(Calendar.SECOND, 0);
    	        calendar.set(Calendar.MINUTE, 0);
    	        calendar.set(Calendar.HOUR, 0);
    	        date = calendar.getTime();
    	        for(Date d : dates) {
    	        	if(d.equals(date)) {unique = false;}
    	        }
    	        if(unique) {dates.add(date);}
    		}
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    	return dates;
    }
    public ArrayList<GameRecord> getHighScores(int recordLimit) {
    	ArrayList<GameRecord> records = new ArrayList<GameRecord>();
    	String sql = "SELECT * FROM GameRecord ORDER BY Score DESC LIMIT 0, "+ recordLimit;
        try {
        	Statement statement = con.createStatement();
            rs=statement.executeQuery(sql);
            while(rs.next()) {
            	User load_user = new User(rs.getString(1));
            	int load_score = rs.getInt(2);
            	String load_date = rs.getString(3);
            	Date date = new SimpleDateFormat("yyyyMMddHHmmss.s", Locale.ENGLISH).parse(load_date);
            	records.add(new GameRecord(load_user, load_score, date));
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    	return records;
    }
    
    public boolean clearTrainingRecords() {
    	String sql = "DROP TABLE TrainingRecord";
    	try {
    		Statement statement = con.createStatement();
    		statement.executeUpdate(sql);
    		sql = "CREATE TABLE IF NOT EXISTS GameRecord(userName VARCHAR(25),"
    			  + "score INTEGER, date Date, PRIMARY KEY(userName, date), "
			      + "FOREIGN KEY(userName) REFERENCES User(userName) ON DELETE "
			      + "CASCADE ON UPDATE CASCADE)";
    		statement.executeUpdate(sql);
    		statement.close();
    		return true;
    	} catch(SQLException e) {
    		return false;
    	}
    }
    
    public boolean clearGameRecords() {
    	String sql = "DROP TABLE GameRecord";
    	try {
    		Statement statement = con.createStatement();
    		statement.executeUpdate(sql);
    		sql = "CREATE TABLE IF NOT EXISTS GameRecord(userName VARCHAR(25), "
			      + "score INTEGER, date VARCHAR(35), PRIMARY KEY(userName, date), "
			      + "FOREIGN KEY(userName) REFERENCES User(userName) ON DELETE "
			      + "CASCADE ON UPDATE CASCADE)";
    		statement.executeUpdate(sql);
    		statement.close();
    		return true;
    	} catch(SQLException e) {
    		return false;
    	}
    }
    public boolean clearDatabase() {
    	String sql = "DROP TABLE IF EXISTS User";
    	String sql2 = "DROP TABLE IF EXISTS TrainingRecord";
    	String sql3 = "DROP TABLE IF EXISTS GameRecord";
    	String sql4 = "DROP TABLE IF EXISTS Achievements";
    	try {
    		Statement statement = con.createStatement();
    		statement.executeUpdate(sql);
    		statement.executeUpdate(sql2);
    		statement.executeUpdate(sql3);
    		statement.executeUpdate(sql4);
    		statement.close();
    		createTables();
    		return true;
    	} catch(SQLException e) {
    		System.out.println(e);
    		return false;
    	}
    }
    public String toString() {
    	String result = "";
    	try {
    		Statement statement = con.createStatement();
    		String sql = "SELECT * FROM sqlite_master WHERE type = 'table'";
    		rs = statement.executeQuery(sql);
    		while(rs.next()) {
    			result += rs.getString(2) + ", ";
    		}
    		return result;
    	} catch(SQLException e) {
    		return null;
    	}
    }
    
}

