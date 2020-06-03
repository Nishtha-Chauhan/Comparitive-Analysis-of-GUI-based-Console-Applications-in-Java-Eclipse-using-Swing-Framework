package watersupply;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class BarChart {
   
   public static void main( String[ ] args )throws Exception {      
      
      String query="SELECT name,tankers from sup";
      JDBCCategoryDataset dataset1=new JDBCCategoryDataset("jdbc:mysql://localhost:3306/wm",
      "com.mysql.cj.jdbc.Driver","root","Yashpal@18");

      dataset1.executeQuery(query);
      
      JFreeChart chart = ChartFactory.createBarChart3D("", "Names", "Tankers",
	        dataset1, PlotOrientation.VERTICAL, true, true, false);
	       
	  ChartPanel chartPanel = new ChartPanel(chart);
      chartPanel.setPreferredSize(new java.awt.Dimension(900, 600));
	  ApplicationFrame f = new ApplicationFrame("Supplier and Tankers");
	  f.setContentPane(chartPanel);
	  f.pack();
	  f.setVisible(true);
	  
	  JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChartView.main(new String[]{});
			}
		});
		chartPanel.add(btnNewButton);
		f.pack();
		f.setVisible(true);
	             
	   }
}