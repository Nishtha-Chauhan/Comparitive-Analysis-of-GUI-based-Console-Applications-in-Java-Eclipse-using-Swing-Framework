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
//import org.jfree.data.jdbc.JDBCCategoryDataset;
import java.awt.Font;

@SuppressWarnings("serial")
class Answers extends JFrame
{
	private JPanel contentPane; 
	int j=0;
	String[][] NumberStorage;
	String[][] ans;
	public static String results;
	static Answers frame;
	
	
	public static void main(String[] args) 
	{		

		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try  
				{
					frame = new Answers();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	

	public Answers() throws ClassNotFoundException, SQLException {
		setTitle("Answers for QUIZ");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Question qusobj = new Question();
		String[][] qusarray = qusobj.qarray();
		Question ansobj = new Question();
		String[][] ansarray = ansobj.ansarray();
		System.out.println(qusarray[1][0]);
		
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
	    
		for(int i=0,j=0;i<=y-1;i++) {
		
		JLabel quest = new JLabel((i+1)+") "+qusarray[i][0]);
		quest.setBounds(185, 10+j, 200, 200);
		contentPane.add(quest);
		
		JLabel ans = new JLabel("Ans) "+ansarray[i][1]);
		ans.setBounds(190, 30+j, 200, 200);
		contentPane.add(ans);
		j=j+40;
		
		}
		
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CoPortal.main(new String[]{});
				frame.dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(214, 614, 89, 23);
		contentPane.add(button);
		
		JLabel lblAnswersForThe = new JLabel("ANSWERS FOR THE QUIZ");
		lblAnswersForThe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAnswersForThe.setBounds(195, 36, 171, 23);
		contentPane.add(lblAnswersForThe);

}
}