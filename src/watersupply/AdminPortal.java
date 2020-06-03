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
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class AdminPortal extends JFrame {
	
	static AdminPortal frame;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminPortal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AdminPortal() 
    {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lb = new JLabel("ADMINISTRATIVE PORTAL");
		lb.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lb.setForeground(Color.BLACK);
		
		JButton b = new JButton("Add Supplier");
		b.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			SupplierForm.main(new String[]{});
			frame.dispose();
			}
		});
		b.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
		JButton b1 = new JButton("View Supplier");
		b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ViewSup.main(new String[]{});
			}
		});
		b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton b2 = new JButton("Delete Supplier");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DeleteSup.main(new String[]{});
			frame.dispose();
			}
		});
		b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton b3 = new JButton("Update Supplier");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			UpdateSup.main(new String[]{});
			frame.dispose();
			}
		});
		b3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton b4 = new JButton("View Feedback");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ViewFeed.main(new String[]{});
			}
		});
		b4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton b5 = new JButton("Logout");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Manipulatews.main(new String[]{});
				frame.dispose();
			}
		});
		b5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(108)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(b5, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(b4, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(b3, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(b2, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(b1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(b, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(135, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(72, Short.MAX_VALUE)
					.addComponent(lb, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
					.addGap(67))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lb, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(b, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(b1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(b2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(b3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(b4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(b5, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
