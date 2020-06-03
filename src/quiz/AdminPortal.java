package quiz;
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
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lb = new JLabel("ADMINISTRATIVE PORTAL");
		lb.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lb.setForeground(Color.BLACK);
		
		JButton b = new JButton("Add Coordinator");
		b.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			CoForm.main(new String[]{});
			frame.dispose();
			}
		});
		b.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
		JButton b1 = new JButton("Add Question");
		b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			QueForm.main(new String[]{});
			frame.dispose();
			}
		});
		b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton b2 = new JButton("View Coordinators");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ViewCo.main(new String[]{});
			}
		});
		b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton b3 = new JButton("View Questions");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ViewQue.main(new String[]{});
			}
		});
		b3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton b4 = new JButton("Delete Coordinator");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DeleteCo.main(new String[]{});
			frame.dispose();
			}
		});
		b4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton b5 = new JButton("Logout");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Manipulatequiz.main(new String[]{});
				frame.dispose();
			}
		});
		b5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton button = new JButton("Delete Question");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteQue.main(new String[]{});
				frame.dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(134)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(b4, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(b3, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(b2, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(b1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(b, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(b5, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(84, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(104, Short.MAX_VALUE)
					.addComponent(lb, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
					.addGap(65))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lb, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
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
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(b5, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
