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

public class PercentageChart extends ApplicationFrame {
	
	public static void viewPercentChart(String appTitle, double[] data, String title) {
		PercentageChart percentChart = new PercentageChart(appTitle , data, title);
		      percentChart.pack( );        
		      RefineryUtilities.centerFrameOnScreen(percentChart);        
		      percentChart.setVisible( true ); 
	}

	public PercentageChart(String appTitle, double[] data, String title) {
		super(appTitle);
		//Make the chart
		JFreeChart barChart = ChartFactory.createBarChart(
			title,
			"Day of the week",
			"Percentage",
			makeData(data),
			PlotOrientation.VERTICAL,           
		    true, true, false);
		
		
		//Set dimensions
		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new java.awt.Dimension( 700 , 380 ));
		
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
		final String mon = "Monday";
		final String tue = "Tuesday";
		final String wed = "Wednesday";
		final String thu = "Thursday";
		final String fri = "Friday";
		final String sat = "Saturday";
		final String sun = "Sunday";
		final DefaultCategoryDataset dataset = 
		new DefaultCategoryDataset( );  
		
		dataset.addValue(data[0], "Percentage", mon);
		dataset.addValue(data[1], "Percentage", tue);
		dataset.addValue(data[2], "Percentage", wed);
		dataset.addValue(data[3], "Percentage", thu);
		dataset.addValue(data[4], "Percentage", fri);
		dataset.addValue(data[5], "Percentage", sat);
		dataset.addValue(data[6], "Percentage", sun);
		
		return dataset;
	}

}
