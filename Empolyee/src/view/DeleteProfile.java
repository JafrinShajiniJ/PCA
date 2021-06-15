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
import view.Changepassword1;

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
public class DeleteProfile extends JFrame {

	private JPanel contentPane;
	private JTextField tEmpId;
	//private JTextField tRole;	
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
	public DeleteProfile() throws ClassNotFoundException, SQLException {
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
		JLabel lblNewLabel = new JLabel("Delete Employee");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(283, 31, 340, 33);
		contentPane.add(lblNewLabel);
		
				
		tEmpId = new JTextField();
		tEmpId.setBounds(336, 113, 268, 33);
		contentPane.add(tEmpId);
		tEmpId.setColumns(10);
		
		JLabel lEmpId = new JLabel("Employee Id");
		lEmpId.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lEmpId.setBounds(16, 130, 109, 16);
		contentPane.add(lEmpId);
		
		JButton bDelete = new JButton("Delete");
		employeecontroller=new Employeecontroller();
		bDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int s;
				s=Integer.parseInt(tEmpId.getText());
				//empController.activateEmployee(s);
				 String jdbcUrl = "jdbc:h2:tcp://localhost/~/test";
				    String username = "sa";
				    String password = "";
				    String sql = "Delete from employee where empId=?";

				    try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password); 
				    	PreparedStatement stmt = conn.prepareStatement(sql);) {
				    	//stmt.setString(1, "Active");
				        stmt.setInt(1, s);
				    	JFrame g=new JFrame();
						if( stmt.executeUpdate()==1){
							//System.out.println("1 record inserted...");
							JOptionPane.showConfirmDialog(g, "You have successfully dele a Skill..");
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
	
		bDelete.setBackground(Color.LIGHT_GRAY);
		bDelete.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		bDelete.setBounds(234, 243, 147, 40);
		contentPane.add(bDelete);	
		
	}
}
