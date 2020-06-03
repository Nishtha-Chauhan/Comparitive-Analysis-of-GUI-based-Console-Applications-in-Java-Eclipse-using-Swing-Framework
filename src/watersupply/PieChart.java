package watersupply;
import java.sql.*; 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

 public class PieChart {
	
    public static void main( String[ ] args )throws Exception {
	   
	   Connection connect = DriverManager.getConnection( 
         "jdbc:mysql://localhost:3306/wm" ,     
         "root",     
         "Yashpal@18");
      
      Statement statement = connect.createStatement( );
      ResultSet resultSet = statement.executeQuery("select city,tankers from loc" );
      DefaultPieDataset dataset = new DefaultPieDataset( );
      
      while( resultSet.next( ) ) {
         dataset.setValue( 
         resultSet.getString( "city" ) ,
         Double.parseDouble( resultSet.getString( "tankers" )));
      }
      
		JFreeChart chart = ChartFactory.createPieChart("", dataset, true,
				true, false);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(900, 600));
		ApplicationFrame f = new ApplicationFrame("Water Supply across the Cities");
		f.setContentPane(chartPanel);
		
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