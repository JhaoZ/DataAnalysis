import java.awt.Color;
import java.awt.SystemColor;
import java.util.Arrays;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DownturnLineGraph extends ApplicationFrame {

	public static void viewChart(String appTitle, int[] data, String title) {
		DownturnLineGraph percentChart = new DownturnLineGraph(appTitle, data, title);
		percentChart.pack();
		RefineryUtilities.centerFrameOnScreen(percentChart);
		percentChart.setVisible(true);
	}

	public DownturnLineGraph(String appTitle, int[] data, String title) {
		super(appTitle);
		// Make the chart
		JFreeChart barChart = ChartFactory.createXYLineChart(title, "Month", "Number of Babies", makeData(data),
				PlotOrientation.VERTICAL, true, true, false);

		// Set dimensions
		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(1400, 800));

		barChart.getPlot().setBackgroundPaint(new Color(211, 211, 211));

		// Fixing the y values

		XYPlot plot = barChart.getXYPlot();
		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setRange(300000, 400000);

		// Set the panel on
		setContentPane(chartPanel);

	}

	private XYDataset makeData(int[] data) {
		// Process data to add to dataset and make graph

		final XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series = new XYSeries("Babies born");
		for (int i = 0; i < 36; i++) {
			series.add(i, data[i]);
		}

		dataset.addSeries(series);
		return dataset;
	}

}