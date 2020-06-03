package quiz;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

@SuppressWarnings("serial")
public class Results extends JFrame 
{
	private JPanel contentPane;
	public static String results;
	private JLabel lblYourScore;
	static Results frame;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try  
				{
					frame = new Results();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public Results() throws ClassNotFoundException, SQLException
	{	
		setTitle("QUIZ:Results");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int results=Question.score;
		String result=String.valueOf(results);
		
//		JDBCCategoryDataset dataset = new JDBCCategoryDataset("jdbc:mysql://localhost:3306/quiz","com.mysql.cj.jdbc.Driver","root","Yashpal@18");
//	    String query="SELECT count(*) from ques";
//	    dataset.executeQuery(query);
//	    int y = Integer.parseInt(query);
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Yashpal@18");     
        Statement statement = connect.createStatement( );
        ResultSet resultSet = statement.executeQuery("SELECT que,A,B,C,ans from ques");
		 
        int size = 0;
        if(resultSet != null) {
        	resultSet.last();
        	
        	size = resultSet.getRow();
        }
         int y = size;
		
		results=y-results;
		String wrong=String.valueOf(results);
		
		JLabel finalresult = new JLabel("<html>Your FinalScore is:<html>"+result+"<html><br>Total Right Answers: <html>"+result+"<html><br>Total Wrong Answers: <html>"+wrong);
		finalresult.setFont(new Font("Tahoma", Font.PLAIN, 13));
		finalresult.setBounds(190, 70, 200, 200);
		contentPane.add(finalresult);
		
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CoPortal.main(new String[]{});
				frame.dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setBounds(225, 270, 89, 23);
		contentPane.add(button);
		
		lblYourScore = new JLabel("SCORE");
		lblYourScore.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblYourScore.setBounds(243, 31, 123, 14);
		contentPane.add(lblYourScore);
		
		JButton button_1 = new JButton("Answers");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Answers.main(new String[]{});
				frame.dispose();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button_1.setBounds(225, 304, 89, 23);
		contentPane.add(button_1);
}	
}