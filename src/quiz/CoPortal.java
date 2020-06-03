package quiz;
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


@SuppressWarnings("serial")
public class CoPortal extends JFrame {
	static CoPortal frame;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame= new CoPortal();	
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public CoPortal() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb = new JLabel("COORDINATOR PORTAL");
		lb.setBounds(98, 22, 212, 22);
		lb.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lb.setForeground(Color.BLACK);
		contentPane.add(lb);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manipulatequiz.main(new String[]{});
				frame.dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(123, 159, 139, 58);
		contentPane.add(button);
		
		JButton b = new JButton("Quiz Questions");
		b.setBounds(123, 81, 139, 58);
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					Question.main(new String[]{});
					frame.dispose();
					}
				});
		b.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(b);
	}
}