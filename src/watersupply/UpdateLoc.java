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
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class UpdateLoc extends JFrame {
	static UpdateLoc frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new UpdateLoc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UpdateLoc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lb = new JLabel("Enter Location Id:");
		JLabel lb1 = new JLabel("Enter Supplier Id:");
		JLabel lb2 = new JLabel("Enter Tankers:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JButton b = new JButton("Update");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lid=textField.getText();
				String sid=textField_1.getText();
				String t=textField_2.getText();
				if(sid==null||sid.trim().equals("")){
					JOptionPane.showMessageDialog(UpdateLoc.this,"Id can't be blank");
				}else{
					String sup_id=sid;
					String loc_id=lid;
					String tankers=t;
					int i=LocDb.update(tankers,loc_id,sup_id);
					if(i>0){
						JOptionPane.showMessageDialog(UpdateLoc.this,"Record updated successfully!");
						SupplierPortal.main(new String[]{});
						frame.dispose();
					}else{
						JOptionPane.showMessageDialog(UpdateLoc.this,"Unable to update the details!");
					}
				}
			}
		});
		b.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton b1 = new JButton("Back");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierPortal.main(new String[]{});
				frame.dispose();
			}
		});
		b1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(167)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lb1)
						.addComponent(lb)
						.addComponent(lb2))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(213, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(313, Short.MAX_VALUE)
					.addComponent(b1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(252))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(512, Short.MAX_VALUE)
					.addComponent(b, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(70))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lb))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lb1))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lb2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(b, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(b1)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}