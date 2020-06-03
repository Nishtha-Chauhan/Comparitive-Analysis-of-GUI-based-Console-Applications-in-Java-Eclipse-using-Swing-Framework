package quiz;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class Question extends JFrame 
{
	
	private JPanel contentPane; 
	static Question frame;
	private JButton Next;
	private JButton Back;
	private ButtonGroup opg;
	private JRadioButton op1;
	private JRadioButton op2;
	private JRadioButton op3;
	private JLabel question;
	private JSeparator separator;
	 String[][] a;
	 String[][] q;
	static int score=0;
	int count=0;
	int c=0;
	private JLabel label;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				try 
				{
					frame = new Question();
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			
		});
		
	}
	
	public Question() throws SQLException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        score=0;
        
        Game();
        
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Yashpal@18");     
        Statement statement = connect.createStatement( );
        ResultSet resultSet = statement.executeQuery("SELECT que,A,B,C,ans from ques");       
        
      q = new String[100][4];
      a = new String[100][4];
      int i =0;
      while(resultSet.next())      
      {
    	q[i][0]=resultSet.getString("que"); 
    	q[i][1]=resultSet.getString("A"); 
    	q[i][2]=resultSet.getString("B"); 
    	q[i][3]=resultSet.getString("C"); 
    	a[i][1]=resultSet.getString("ans"); 
    	i++;
      }

      start(0);
	}
	 
//	 private int findSize(Statement statement) throws SQLException {
//		 ResultSet resultSet = statement.executeQuery("SELECT que,A,B,C,ans from ques");
//		 int size = 0;
//		 if(resultSet != null) {
//			 resultSet.last();
//			 size = resultSet.getRow();
//		 }
//		return size;
//	}

	public String[][] qarray() {
	        return q.clone();
	    }
	 public String[][] ansarray() {
	        return a.clone();
	    }
	private void Game() throws SQLException
	{	
		setTitle("QUIZ:Questions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		opg=new ButtonGroup();
		op1=new JRadioButton();
		op2=new JRadioButton();
		op3=new JRadioButton();
		question=new JLabel();
		separator=new JSeparator();
		Next=new JButton();
		Back=new JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Yashpal@18");     
        Statement statement = connect.createStatement( );
        ResultSet resultSet = statement.executeQuery("SELECT que,A,B,C,ans from ques");
		 
        int size = 0;
        if(resultSet != null) {
        	resultSet.last();
        	
        	size = resultSet.getRow();
        }
         int y = size;


        final JLabel timer = new JLabel("01:00");
        final Timer t = new Timer(1000, new ActionListener() {
            int time = 60 * y;
            @Override
            public void actionPerformed(ActionEvent e) {
                time--;
                timer.setText(format(time / 60) + ":" + format(time % 60));
                if(c>=y) {
                    final Timer timer = (Timer) e.getSource();
                	timer.stop();
                }else {
                if (time == 0) {
                	if(c>=y) {
                    final Timer timer = (Timer) e.getSource();
                    timer.stop();
                	}else {
                    JOptionPane.showMessageDialog(null,"Time Up Click Ok To Check Your Score","bye..",JOptionPane.ERROR_MESSAGE);
                    System.out.println(score);
        			try {
						new Results().setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
        			dispose();
                	}
                }
            }
            }
            
        });
        t.start();
       
        opg.add(op1);
        op1.setText("option1");
        op1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op1Selected(evt);
            }

		
        });

        opg.add(op2);
        op2.setText("option2");
        op2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op2selected(evt);
            }

		
        });

        opg.add(op3);
        op3.setText("option3");
        op3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op3selected(evt);
            }

        });

        question.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        question.setText("question");

        Next.setText("Next");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					NextClicked(evt);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
            }

        });
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackClicked(evt);
            }

        });
        
        label = new JLabel("WARNING : User is not allowed to attempt the quiz again. So attempt properly!!!!");
        label.setForeground(Color.RED);
        label.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
	
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(21)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(timer)
        					.addGap(18)
        					.addComponent(question, GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
        					.addComponent(label, GroupLayout.PREFERRED_SIZE, 541, GroupLayout.PREFERRED_SIZE)
        					.addGap(40)))
        			.addGap(58))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(56)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(op2)
        					.addContainerGap())
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(op1)
        						.addComponent(op3))
        					.addPreferredGap(ComponentPlacement.RELATED, 676, Short.MAX_VALUE)
        					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(172)
        			.addComponent(Next, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
        			.addComponent(Back, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
        			.addGap(210))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(25))
        				.addComponent(label, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(timer)
        				.addComponent(question, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(18)
        							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addGap(26)
        							.addComponent(op1)
        							.addGap(18)
        							.addComponent(op3)))
        					.addGap(18)
        					.addComponent(op2)
        					.addGap(18)
        					.addComponent(Back, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
        				.addComponent(Next, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(39, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

	pack();
	}    

	

	protected void BackClicked(ActionEvent evt) {
	
		if(c==0) {
			
		}else {
			if(score==c)
			{
		score--;
		c--;
		start(c);
			}
			else {
				c--;
				start(c);
			}
		}
		
	}
	protected void NextClicked(ActionEvent evt) throws ClassNotFoundException, SQLException {
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Yashpal@18");     
        Statement statement = connect.createStatement( );
        ResultSet resultSet = statement.executeQuery("SELECT que,A,B,C,ans from ques");
		 
        int size = 0;
        if(resultSet != null) {
        	resultSet.last();
        	
        	size = resultSet.getRow();
        }
         int y = size;
		
		if(getSelectedButtonText(opg).equals(a[c][1])) {
			score++;
			count++;
			c++;
		}
		else
		{
			c++;
			count++;
		}
			if(c!=y)
		{
			start(c);
		System.out.println(score);
		}
		else {
			System.out.println(score);
			new Results().setVisible(true);
			this.dispose();
		}
	}
	protected void op3selected(ActionEvent evt) {
	
		
	}
	protected void op2selected(ActionEvent evt) {
		
		
	}
	protected void op1Selected(ActionEvent evt) {
	
		
	}
	String getSelectedButtonText(ButtonGroup buttonGroup) {
		    for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
		        AbstractButton button = (AbstractButton) buttons.nextElement();

		        if (button.isSelected()) {
		            return button.getText();
		        }
		    }
		    return null;
	}
	public void start(int i) {
		
		 question.setText(q[i][0]);
	        op1.setText(q[i][1]);
	        op2.setText(q[i][2]);
	        op3.setText(q[i][3]);
	        opg.clearSelection();
		
	}
	private static String format(int i) {
        String result = String.valueOf(i);
        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;
    }
	

		 }
