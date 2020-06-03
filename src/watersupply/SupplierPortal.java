package watersupply;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class SupplierPortal extends JFrame {
	
	static SupplierPortal frame;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SupplierPortal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public SupplierPortal() 
    {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lb = new JLabel("SUPPLIER PORTAL");
		lb.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lb.setForeground(Color.BLACK);
		
		JButton b = new JButton("Add Location");
		b.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			LocForm.main(new String[]{});
			frame.dispose();
			}
		});
		b.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
		JButton b1 = new JButton("View Location");
		b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ViewLoc.main(new String[]{});
			}
		});
		b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton b2 = new JButton("Update Location");
		b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			UpdateLoc.main(new String[]{});
			frame.dispose();
			}
		});
		b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton b3 = new JButton("Delete Location");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DeleteLoc.main(new String[]{});
			frame.dispose();
			}
		});
		b3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton b4 = new JButton("Add Feedback");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			FeedsForm.main(new String[]{});
			frame.dispose();
			}
		});
		b4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton b5 = new JButton("Analysis");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ChartView.main(new String[]{});
			frame.dispose();
			}
		});
		b5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton b6 = new JButton("Logout");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Manipulatews.main(new String[]{});
				frame.dispose();
			}
		});
		b6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(83)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(b6, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(b5, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(b4, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(b3, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(b2, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(b1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(b, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(76, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addComponent(lb, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(92))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lb, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(b, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(b1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(b2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(b3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(b4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(b5, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(b6, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
