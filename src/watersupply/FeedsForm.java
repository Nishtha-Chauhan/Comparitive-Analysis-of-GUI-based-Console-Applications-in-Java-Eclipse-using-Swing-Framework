package watersupply;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FeedsForm extends JFrame {
	static FeedsForm frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FeedsForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FeedsForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFeedbackForm = new JLabel("ADD FEEDBACK ");
		lblFeedbackForm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFeedbackForm.setBounds(235, 11, 163, 38);
		contentPane.add(lblFeedbackForm);
		
		JLabel sup_id = new JLabel("Supplier Id:");
		sup_id.setBounds(66, 85, 97, 14);
		contentPane.add(sup_id);
		
		JLabel name = new JLabel("Name:");
		name.setBounds(68, 135, 48, 14);
		contentPane.add(name);
		
		JLabel desc= new JLabel("Description:");
		desc.setBounds(66, 189, 119, 14);
		contentPane.add(desc);
		
		JLabel tanks_inc = new JLabel("No of extra Tankers required:");
		tanks_inc.setBounds(66, 247, 227, 14);
		contentPane.add(tanks_inc);
		
		textField = new JTextField();
		textField.setBounds(345, 82, 174, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(345, 132, 174, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(345, 186, 174, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(345, 244, 174, 20);
		contentPane.add(textField_3);
		
		JButton btnAdd = new JButton("Add Feedback");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    String sup_id = textField.getText();
			String name=textField_1.getText();
			String desc=textField_2.getText();
			String tanks_inc=textField_3.getText();
			
			int i=0;			
			i=FeedDb.save(sup_id,name,desc,tanks_inc);			
			
			if(i>0){
				JOptionPane.showMessageDialog(FeedsForm.this,"Feedback added successfully!");
				SupplierPortal.main(new String[]{});
				frame.dispose();
				
			}else{
				JOptionPane.showMessageDialog(FeedsForm.this,"Sorry, unable to save!");
			}
			}
		});
		btnAdd.setForeground(Color.DARK_GRAY);

		btnAdd.setBounds(217, 293, 125, 23);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			SupplierPortal.main(new String[]{});
			frame.dispose();
			}
		});
		btnBack.setBounds(405, 327, 89, 23);
		contentPane.add(btnBack);
	}
}
