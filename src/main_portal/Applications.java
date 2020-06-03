package main_portal;
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
import watersupply.Manipulatews;
import shop.Manipulateshop;
import library.Manipulatelib;
import javax.swing.LayoutStyle.ComponentPlacement;
import quiz.Manipulatequiz;

@SuppressWarnings("serial")
public class Applications extends JFrame {
	
	static Applications frame;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Applications();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Applications() 
    {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lb = new JLabel("APPLICATIONS");
		lb.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb.setForeground(Color.BLACK);
		
		JButton b = new JButton("Water Supply Management");
		b.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manipulatews.main(new String[]{});
				frame.dispose();
			}
		});
		b.setFont(new Font("Tahoma", Font.PLAIN, 15));
				
		JButton b1 = new JButton("Gardening Shop");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Manipulateshop.main(new String[]{});
				frame.dispose();
			}
		});
		b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton b2 = new JButton("Library System");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Manipulatelib.main(new String[]{});
			frame.dispose();
			}
		});
		b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton b3 = new JButton("Quiz Portal");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Manipulatequiz.main(new String[]{});
				frame.dispose();
			}
		});
		b3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("");
		javax.swing.ImageIcon img=new javax.swing.ImageIcon(this.getClass().getResource("/pg-ws.jpg"));
		lblNewLabel.setIcon(img);
		
		JLabel label = new JLabel("");
		javax.swing.ImageIcon img1=new javax.swing.ImageIcon(this.getClass().getResource("/pg-gs.jpg"));
		label.setIcon(img1);
		
		JLabel label_1 = new JLabel("");
		javax.swing.ImageIcon img2=new javax.swing.ImageIcon(this.getClass().getResource("/pg-lm.jpg"));
		label_1.setIcon(img2);
		
		JLabel label_2 = new JLabel("");
		javax.swing.ImageIcon img3=new javax.swing.ImageIcon(this.getClass().getResource("/pg-sq.jpg"));
		label_2.setIcon(img3);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(89)
					.addComponent(b, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
					.addComponent(b1, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addGap(94))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
					.addGap(35))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(120)
					.addComponent(b2, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
							.addComponent(lb, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addGap(268))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(110)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
							.addComponent(b3)
							.addGap(136))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(lb, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(b)
						.addComponent(b1))
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(b2)
						.addComponent(b3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(48))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
