package watersupply;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class UpdateSup extends JFrame {
	static UpdateSup frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UpdateSup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UpdateSup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lb = new JLabel("Enter Id:");
		JLabel lb1 = new JLabel("Enter Tankers:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		
		JButton b = new JButton("Update");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid=textField.getText();
				String st=textField_1.getText();
				if(sid==null||sid.trim().equals("")){
					JOptionPane.showMessageDialog(UpdateSup.this,"Id can't be blank");
				}else{
					int id=Integer.parseInt(sid);
					String tankers=st;
					int i=SupplierDb.update(tankers,id);
					if(i>0){
						JOptionPane.showMessageDialog(UpdateSup.this,"Record updated successfully!");
						AdminPortal.main(new String[]{});
						frame.dispose();
					}else{
						JOptionPane.showMessageDialog(UpdateSup.this,"Unable to update the details!");
					}
				}
			}
		});
		b.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton b1 = new JButton("Back");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPortal.main(new String[]{});
				frame.dispose();
			}
		});
		b1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(167)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lb)
								.addComponent(lb1))
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(301)
							.addComponent(b1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(229, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(478, Short.MAX_VALUE)
					.addComponent(b, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(104))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lb)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lb1))
					.addGap(10)
					.addComponent(b, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(b1)
					.addContainerGap(230, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

