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

public class SpecialDayBarGraph extends ApplicationFrame {
	
	public static void viewBarChart(String appTitle, double[] data, String title) {
		SpecialDayBarGraph percentChart = new SpecialDayBarGraph(appTitle , data, title);
		      percentChart.pack( );        
		      RefineryUtilities.centerFrameOnScreen(percentChart);        
		      percentChart.setVisible( true ); 
	}

	public SpecialDayBarGraph(String appTitle, double[] data, String title) {
		super(appTitle);
		//Make the chart
		JFreeChart barChart = ChartFactory.createBarChart(
			title,
			"Day",
			"Average number of babies born",
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
		final String christmas = "Christmas";
		final String feb = "February 29";
		final String fri = "Friday 13th";
		final String avg = "Average Day";
		final DefaultCategoryDataset dataset = 
		new DefaultCategoryDataset( );  
		
		dataset.addValue(data[0], "Average Number of Babies born on this day" , avg);
		dataset.addValue(data[1], "Average Number of Babies born on this day" , christmas);
		dataset.addValue(data[2], "Average Number of Babies born on this day" , feb);
		dataset.addValue(data[3], "Average Number of Babies born on this day" , fri);
		
		return dataset;
	}

}
