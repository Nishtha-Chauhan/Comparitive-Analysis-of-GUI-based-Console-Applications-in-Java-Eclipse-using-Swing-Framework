package watersupply;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import main_portal.Applications;

@SuppressWarnings("serial")
public class ChartView extends JFrame {
	static ChartView frame;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame= new ChartView();	
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ChartView() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lb = new JLabel("TYPES OF CHARTS AND ANALYSIS");
		lb.setBounds(212, 40, 297, 22);
		lb.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb.setForeground(Color.BLACK);
		
		JButton b = new JButton("Water Supply at various Places");
		b.setBounds(85, 124, 297, 53);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				PieChart.main(new String[]{});
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			}
		});
		b.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton b1 = new JButton("Tankers distributed to various Suppliers");
		b1.setBounds(85, 220, 297, 59);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				BarChart.main(new String[]{});
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			}
		});
		b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lbi = new JLabel("");
		lbi.setBounds(441, 73, 220, 253);
		javax.swing.ImageIcon img=new javax.swing.ImageIcon(this.getClass().getResource("/charts.jpg"));
		contentPane.setLayout(null);
		lbi.setIcon(img);
		contentPane.add(lbi);
		contentPane.add(lbi);
		contentPane.add(b1);
		contentPane.add(b);
		contentPane.add(lb);
		
		JButton button = new JButton("Back");
		button.setBounds(301, 359, 135, 53);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierPortal.main(new String[]{});
				frame.dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(button);
	}
}
