import java.awt.Color;
import java.awt.SystemColor;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PercentChartMonth extends ApplicationFrame {
	
	public static void viewPercentChart(String appTitle, double[] data, String title) {
		PercentChartMonth percentChart = new PercentChartMonth(appTitle , data, title);
		      percentChart.pack( );        
		      RefineryUtilities.centerFrameOnScreen(percentChart);        
		      percentChart.setVisible( true ); 
	}

	public PercentChartMonth(String appTitle, double[] data, String title) {
		super(appTitle);
		//Make the chart
		JFreeChart barChart = ChartFactory.createBarChart(
			title,
			"Month",
			"Percentage",
			makeData(data),
			PlotOrientation.VERTICAL,           
		    true, true, false);
		
		
		//Set dimensions
		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(1400 , 800));
		
		//Change plot settings
		
		CategoryPlot plot =  barChart.getCategoryPlot();
		BarRenderer renderer = (BarRenderer) plot.getRenderer();

		//change background color
	    plot.setBackgroundPaint(new Color(211,211,211));   
		
		//Color set
		Color color = new Color(32, 178, 170);
		renderer.setSeriesPaint(0, color);
		
		//Set the panel on
	    setContentPane(chartPanel); 
	     
	
	}

	private CategoryDataset makeData(double[] data) {
		//Process data to add to dataset and make graph
		final String jan = "January";
		final String feb = "February";
		final String mar = "March";
		final String apr = "April";
		final String may = "May";
		final String jun = "June";
		final String jul = "July";
		final String aug = "August";
		final String sep = "September";
		final String oct = "October";
		final String nov = "November";
		final String dec = "December";
		final DefaultCategoryDataset dataset = 
		new DefaultCategoryDataset( );  
		
		dataset.addValue(data[0], "Percentage", jan);
		dataset.addValue(data[1], "Percentage", feb);
		dataset.addValue(data[2], "Percentage", mar);
		dataset.addValue(data[3], "Percentage", apr);
		dataset.addValue(data[4], "Percentage", may);
		dataset.addValue(data[5], "Percentage", jun);
		dataset.addValue(data[6], "Percentage", jul);
		dataset.addValue(data[7], "Percentage", aug);
		dataset.addValue(data[8], "Percentage", sep);
		dataset.addValue(data[9], "Percentage", oct);
		dataset.addValue(data[10], "Percentage", nov);
		dataset.addValue(data[11], "Percentage", dec);
		
		return dataset;
	}

}
