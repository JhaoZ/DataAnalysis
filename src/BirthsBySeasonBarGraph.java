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

public class BirthsBySeasonBarGraph extends ApplicationFrame {
	
	public static void viewBarChart(String appTitle, int[] data, String title) {
		BirthsBySeasonBarGraph percentChart = new BirthsBySeasonBarGraph(appTitle , data, title);
		      percentChart.pack( );        
		      RefineryUtilities.centerFrameOnScreen(percentChart);        
		      percentChart.setVisible( true ); 
	}

	public BirthsBySeasonBarGraph(String appTitle, int[] data, String title) {
		super(appTitle);
		//Make the chart
		JFreeChart barChart = ChartFactory.createBarChart(
			title,
			"Season",
			"Number of babies born",
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

	private CategoryDataset makeData(int[] data) {
		//Process data to add to dataset and make graph
		final String spring = "spring";
		final String summer = "summer";
		final String fall = "fall";
		final String winter = "winter";
		final DefaultCategoryDataset dataset = 
		new DefaultCategoryDataset( );  
		
		dataset.addValue(data[0], "Babies born in this season" , spring);
		dataset.addValue(data[1], "Babies born in this season" , summer);
		dataset.addValue(data[2], "Babies born in this season" , fall);
		dataset.addValue(data[3], "Babies born in this season" , winter);
		
		return dataset;
	}

}
