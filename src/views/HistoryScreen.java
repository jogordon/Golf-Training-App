package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import models.ClubEnum;
import models.TrainingRecord;
import net.miginfocom.swing.MigLayout;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import controllers.AAnimationScreenController;
import controllers.HistoryController;

public class HistoryScreen extends AAnimationScreen {

	private static final long serialVersionUID = 8430117659869471731L;

	/****************** attributes ***********************/
	JPanel HeaderPanel; // header panel includes title label and a button to
						// return to main menu
	JTabbedPane chartTabbedPane;
	JLabel title;
	
	final String IRON_ALL = "All";
	final String IRON_5 = "IRON5";
	final String IRON_9 = "IRON9";
	JComboBox<String> cbIron;
//	JComboBox<String> cbStartDate;
//	JComboBox<String> cbEndDate;
	JComboBox<Date> cbStartDate;
	JComboBox<Date> cbEndDate;
	
	ClubEnum cIron=null;
	Date startDate=new Date(100, 1, 1);
	Date endDate=new Date(999, 99, 99);
	String chosenIron="All";

	JFreeChart chart;
	
	static final String ROW_KEY = "Values";

	Format formatter = new SimpleDateFormat("YYYY-MM-dd");
	
	DefaultCategoryDataset distanceBarChartModel = new DefaultCategoryDataset();
	XYSeriesCollection distributionChartModel = new XYSeriesCollection();

	HistoryController controller;

	/****************** attributes ends ******************/

	/****************** constructors *********************/
	// To do: Code here
	public HistoryScreen(AAnimationScreenController controller) {
		super(controller);
		this.controller=(HistoryController)controller;
		backPanel.setLayout(new BorderLayout());
		backPanel.add(this.animationView, BorderLayout.CENTER);
		
		this.frontPanel.setLayout(new MigLayout("", "8%[grow][grow]8%","5%[][][grow][]8%"));
		JLabel lblTitle = new JLabel("History");
		lblTitle.setFont(new Font("Arial Black", Font.BOLD, 60));
		lblTitle.setForeground(new Color(11, 104, 47));
		this.frontPanel.add(lblTitle,"center,span,wrap");
		this.frontPanel.add(createOptionPanel(), "center, span, wrap");
		this.frontPanel.add(createDistributionChart(), "growy");
		this.frontPanel.add(createDistanceBarChart(), "growy,wrap");
		this.frontPanel.add(btnMainMenu, "align left");
		
	}

	/****************** constructors ends ****************/

	/****************** private methods ******************/
	
	private JPanel createOptionPanel() {
		JPanel settingsPanel = new JPanel();
		this.cbIron= new JComboBox<String>();
		this.cbIron.addItem(IRON_ALL);
		this.cbIron.addItem(IRON_5);
		this.cbIron.addItem(IRON_9);
		cbIron.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chosenIron = (String) cbIron.getSelectedItem();
				controller.testRetrieveData(controller.getUser().getName(), startDate, endDate, chosenIron);
			}
		});
		settingsPanel.add(this.cbIron);
		
		this.cbStartDate=new JComboBox<Date>();
		cbStartDate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				startDate = (Date) cbStartDate.getSelectedItem();
				controller.testRetrieveData(controller.getUser().getName(), startDate, endDate, chosenIron);
			}
		});
		settingsPanel.add(this.cbStartDate);
		
		this.cbEndDate=new JComboBox<Date>();
		cbEndDate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Date e1 = (Date) cbEndDate.getSelectedItem();
				Calendar cal = Calendar.getInstance();
				cal.setTime(e1);
				cal.add(Calendar.DATE, 1);
				endDate = cal.getTime();
				controller.testRetrieveData(controller.getUser().getName(), startDate, endDate, chosenIron);
			}
		});
		settingsPanel.add(this.cbEndDate);
		
		settingsPanel.setOpaque(false);
		return settingsPanel;
	}
	
	private ChartPanel createDistanceBarChart() {
		if (distanceBarChartModel == null) {
			distanceBarChartModel = new DefaultCategoryDataset();
		}
		//default chart data

		//distanceBarChartModel = ChartDataService.generateDistData();
		//create bar chart
		JFreeChart barChart = ChartFactory.createBarChart("Distance", "Shot",
		            "Value", distanceBarChartModel, PlotOrientation.VERTICAL, true, true, false);
		
		barChart.getPlot().setBackgroundPaint(Color.white);
		barChart.setBackgroundPaint(Color.white);
		ChartPanel chpanel = new ChartPanel(barChart);
		chpanel.setPreferredSize(new Dimension(100, 100));
		chpanel.setMaximumSize(new Dimension(100,100));
		return new ChartPanel(barChart);
	}
	
	private ChartPanel createDistributionChart() {
		XYSeries series = new XYSeries("Scatter");
		if (distributionChartModel == null) {
			distributionChartModel = new XYSeriesCollection();
		}
		//default chart data
/*
		ArrayList<TrainingRecord> records = ChartDataService.traindemo;
		
		for (TrainingRecord r : records) {
			series.add(r.getxLanding(), r.getzLanding());
			
		}
		distributionChartModel.addSeries(series);
		*/
		JFreeChart distribChart = ChartFactory.createScatterPlot("Shot Distribution", "Lateral Distance", "Distance", distributionChartModel, PlotOrientation.VERTICAL, true, true, false);
		
		XYPlot xyplot = (XYPlot) distribChart.getPlot();
		xyplot.setDomainCrosshairVisible(true);
		xyplot.setBackgroundPaint(Color.white);
		ChartPanel chpanel = new ChartPanel(distribChart);
		chpanel.setPreferredSize(new Dimension(100,100));
		chpanel.setMaximumSize(new Dimension(100,100));
		return new ChartPanel(distribChart);
	}
	
//	private ChartPanel createPolarAreaChart() {
//		
//	}

	/****************** private methods ends *************/

	/****************** properties ***********************/
	// To do: setters and getters code here
	/****************** properties ends ******************/

	/****************** public methods *******************/

	public void addReturnMainMenuListener(ActionListener listener) {
		this.btnMainMenu.addActionListener(listener);
	}
	
	//updating the model data set
	public void setData(ArrayList<TrainingRecord> records){
		this.distanceBarChartModel.clear();
		this.distributionChartModel.removeAllSeries();
		XYSeries s = new XYSeries("Scatter");
		Integer shotnumber = 1; 
		for(TrainingRecord record: records){
			if (record.getIron() == ClubEnum.IRON5) {
//				distanceBarChartModel.setValue(record.getzLanding(), record.getIron().name(), record.getDate());
				distanceBarChartModel.setValue(record.getzLanding(), record.getIron().name(), shotnumber);
				shotnumber = shotnumber + 1;
				s.add(record.getxLanding(), record.getzLanding());
			}
			else if (record.getIron() == ClubEnum.IRON9) {
//				distanceBarChartModel.setValue(record.getzLanding(), record.getIron().name(), record.getDate());
				distanceBarChartModel.setValue(record.getzLanding(), record.getIron().name(), shotnumber);
				shotnumber = shotnumber + 1;
				s.add(record.getxLanding(), record.getzLanding());
			}
			else {
//				distanceBarChartModel.setValue(record.getzLanding(), record.getIron().name(), record.getDate());
				distanceBarChartModel.setValue(record.getzLanding(), record.getIron().name(), shotnumber);
				shotnumber = shotnumber + 1;
				s.add(record.getxLanding(), record.getzLanding());
			}
			
			}
		distributionChartModel.addSeries(s);
	}
	
	
	public void populateDates(ArrayList<Date> dates) {
//		cbStartDate.removeAllItems();
//		cbEndDate.removeAllItems();
		for (Date d : dates) {
			formatter.format(d);
//			cbStartDate.addItem(formatter.format(d));
//			cbEndDate.addItem(formatter.format(d));
			cbStartDate.addItem(d);
			cbEndDate.addItem(d);

		}
		
	}

	/****************** public methods ends **************/

}