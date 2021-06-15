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
//import view.Changepassword;
import java.sql.SQLException;
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
import model.Employee;
import config.Jdbcconnection;
public class UpdateProfile extends JFrame {

	private JPanel contentPane;
	private JTextField tEmpId;
	private JTextField tRole;	
	private static JFrame f;
	private static Employeecontroller employeecontroller=null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateProfile frame = new UpdateProfile();
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
	public UpdateProfile() throws ClassNotFoundException, SQLException {
		Connection conn=Jdbcconnection.getDBConnection();	
		f=new JFrame();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 727);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		//contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new LineBorder(null, 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Update Data");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(283, 31, 340, 33);
		contentPane.add(lblNewLabel);
		
				
		tEmpId = new JTextField();
		tEmpId.setBounds(336, 113, 268, 33);
		contentPane.add(tEmpId);
		tEmpId.setColumns(10);
		
		tRole = new JTextField();
		tRole.setColumns(10);
		tRole.setBounds(336, 199, 268, 33);
		contentPane.add(tRole);
	
		
		JLabel lEmpId = new JLabel("Employee Id");
		lEmpId.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lEmpId.setBounds(16, 130, 109, 16);
		contentPane.add(lEmpId);
		
		JLabel lRole = new JLabel("Role");
		lRole.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lRole.setBounds(38, 216, 109, 16);
		contentPane.add(lRole);
		
		JButton bSubmit = new JButton("Submit");
		employeecontroller=new Employeecontroller();
		bSubmit.addActionListener(new ActionListener() {
			@Override
			public  void actionPerformed(ActionEvent arg0) {
				int s;
				s=Integer.parseInt(tEmpId.getText());
				String UR=tRole.getText();
				//empController.activateEmployee(s);
				 String jdbcUrl = "jdbc:h2:tcp://localhost/~/test";
				    String username = "sa";
				    String password = "";
				    String sql = "update employee set Role=? where empId=?";

				    try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password); 
				    	PreparedStatement stmt = conn.prepareStatement(sql);) {
				    	stmt.setString(1, UR);
				        stmt.setInt(2, s);
				    	JFrame g=new JFrame();
						if( stmt.executeUpdate()==1){
							//System.out.println("1 record inserted...");
							JOptionPane.showConfirmDialog(g, "You have successfully Update the employee..");
						}
						else {
							//System.out.println("insertion failed...");
							JOptionPane.showConfirmDialog(g, "Oh no.. Insertion Failed..");
						}
					}
				      
				    catch (SQLException ex) {
				      ex.printStackTrace();
				    }
			}
		});
		bSubmit.setBackground(Color.LIGHT_GRAY);
		bSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		bSubmit.setBounds(236, 282, 142, 40);
		contentPane.add(bSubmit);
		
		//JButton bChangepassword = new JButton("Change Password");
		//bChangepassword.addActionListener(new ActionListener() {
			//@Override
			//public  void actionPerformed(ActionEvent arg0) {
				
			//}	
		 //});

		//bChangepassword.setBackground(Color.LIGHT_GRAY);
		//bChangepassword.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		//bChangepassword.setBounds(361, 319, 147, 40);
		//contentPane.add(bChangepassword);	
		
	}
}
