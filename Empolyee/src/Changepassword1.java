package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import controller.Employeecontroller;
import daoimp.Employeedao;
import java.sql.*;

import config.Jdbcconnection;
public class Changepassword1 extends JFrame {

	private JPanel contentPane;
	private JPasswordField tPassword;
	private JPasswordField tConfirmPassword;
	JLabel lEmpId;
	JTextField tEmpId;
	private static JFrame f;
	private static Employeecontroller employeecontroller=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Changepassword1 frame = new Changepassword1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Changepassword1() throws ClassNotFoundException, SQLException {
		
		f=new JFrame();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 727);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		//contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new LineBorder(null, 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lEmpId=new JLabel("EmpID");
		tEmpId=new JTextField();
		contentPane.add(lEmpId);
		contentPane.add(tEmpId);
		lEmpId.setBounds(30, 100, 100, 30);
		tEmpId.setBounds(300, 100, 150, 30);
		JLabel lblNewLabel = new JLabel("Change Password");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(283, 31, 340, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lPassword = new JLabel(" Create Password");
		lPassword.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lPassword.setBounds(46, 154, 268, 16);
		contentPane.add(lPassword);
		
		JLabel lConfirmPassword = new JLabel("Confirm Password");
		lConfirmPassword.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lConfirmPassword.setBounds(46, 230, 268, 16);
		contentPane.add(lConfirmPassword);
		
		
		JButton bSubmit = new JButton("Submit");
		employeecontroller=new Employeecontroller();
		bSubmit.addActionListener(new ActionListener() {
			@Override
			public  void actionPerformed(ActionEvent arg0) {
				String UP,UCP;
				UP=new String(tPassword.getPassword());
				UCP=new String(tConfirmPassword.getPassword());
				//tEmpId.setText(String.valueOf(a));
				 String jdbcUrl = "jdbc:h2:tcp://localhost/~/test";
				  String username = "sa";
				    String password = "";
				    String sql = "update employee set Password=? where (select * from Employee where EMPID=?)";

				    try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password); 
				    	PreparedStatement stmt = conn.prepareStatement(sql);) {
				    	 int a = ((ResultSet) stmt).getInt("EmpId");
						 tEmpId.setText(String.valueOf(a));
				    	stmt.setString(1, UP);
				        stmt.setInt(2, a);
				        stmt.executeQuery();
				    	JFrame g=new JFrame();
				    	if(UP.equals(UCP)) {
							
							JOptionPane.showMessageDialog(f, "Update Successfully...");
								

						}
						else {
							JOptionPane.showMessageDialog(f, "Check your Password and Retry...");
						}}
				      
				    catch (SQLException ex) {
				      ex.printStackTrace();
				    }
				    
			}
		});
		bSubmit.setBackground(Color.LIGHT_GRAY);
		bSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		bSubmit.setBounds(236, 350, 142, 40);
		contentPane.add(bSubmit);
		
		tPassword = new JPasswordField();
		tPassword.setBounds(330, 137, 268, 33);
		contentPane.add(tPassword);
		
		tConfirmPassword = new JPasswordField();
		tConfirmPassword.setBounds(330, 224, 268, 33);
		contentPane.add(tConfirmPassword);
		
		
	}

	
}
