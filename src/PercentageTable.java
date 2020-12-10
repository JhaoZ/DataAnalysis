import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class PercentageTable {

	JFrame frame;
	JTable table;
	
	PercentageTable(String[][] data, String title) {
		
		frame = new JFrame();
		frame.setTitle(title);
		String[] columnNames = new String[7];
		String[][] percentages = new String[1][7];
		for(int i = 0; i < columnNames.length; i++) {
			columnNames[i] = data[0][i];
			percentages[0][i] = data[1][i];
		}
		//System.out.println(Arrays.toString(columnNames));
		//System.out.println(Arrays.deepToString(columnNames));
		table = new JTable(percentages, columnNames);
		table.setBounds(30, 40, 200, 300);
		table.setVisible(true);
		JScrollPane sp = new JScrollPane(table);
		frame.add(sp);
		frame.setSize(500, 100);
		frame.setVisible(true);
	}
	
	public static void showPercentTable(String[][] data, String title) {
		new PercentageTable(data, title);
	}
	
}
