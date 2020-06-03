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
import main_portal.Applications;

@SuppressWarnings("serial")
public class Manipulatews extends JFrame {
	static Manipulatews frame;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame= new Manipulatews();	
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Manipulatews() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lb = new JLabel("MAIN PORTAL");
		lb.setBounds(154, 11, 115, 22);
		lb.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb.setForeground(Color.BLACK);
		
		JButton b = new JButton("Administrator");
		b.setBounds(105, 54, 135, 52);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdminLogin.main(new String[]{});
			frame.dispose();
			}
		});
		b.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton b1 = new JButton("Supplier");
		b1.setBounds(105, 117, 135, 53);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			SupplierLogin.main(new String[]{});
			frame.dispose();
			}
		});
		b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lbi = new JLabel("");
		lbi.setBounds(297, 54, 135, 142);
		javax.swing.ImageIcon img=new javax.swing.ImageIcon(this.getClass().getResource("/wm.png"));
		contentPane.setLayout(null);
		lbi.setIcon(img);
		contentPane.add(lbi);
		contentPane.add(lbi);
		contentPane.add(b1);
		contentPane.add(b);
		contentPane.add(lb);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Applications.main(new String[]{});
				frame.dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(105, 181, 135, 53);
		contentPane.add(button);
	}
}
