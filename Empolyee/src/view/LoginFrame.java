package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import controller.Employeecontroller;
import model.Employee;
import config.Jdbcconnection;
public class LoginFrame extends JFrame{
	
	Container container;
	JLabel lblNewLabel_1;
	JLabel lUserId, lPassword, lMessage;
	JLabel createAccountLabel;
	JTextField tUserId;
	JPasswordField tPassword;
	JButton bLogin,bRegister;
	JPanel panel;
	Employeecontroller empController=null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public LoginFrame() throws ClassNotFoundException, SQLException {
		container=getContentPane();
		lblNewLabel_1 = new JLabel("Login Page");
		lUserId=new JLabel("USERNAME");
		lPassword=new JLabel("PASSWORD");
		lMessage=new JLabel();
		tUserId=new JTextField();
		tPassword=new JPasswordField();
		bLogin=new JButton("LOGIN");
		createAccountLabel = new JLabel("Create a New Account");
		empController=new Employeecontroller();
		//Event handling for Login button
		bLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String userId,password;
				Employee emp=new Employee();
				userId=tUserId.getText();
				password=new String(tPassword.getPassword());
				emp=empController.checkLogin(userId, password);
				//new Jdbcconnection();
				if(emp.getUserId()==null || emp.getPassword()==null) {
					JFrame f=new JFrame();
					JOptionPane.showMessageDialog(f,"You are not authorized user! Retry or Register!");
				}
				else {
					if(emp.getActive().equals("Active")) {
						if(emp.getRole().equals("HRA")) {
							//new EMPHome(emp);
							try {
								new HRAHome();
							} catch (ClassNotFoundException | SQLException ex) {
								// TODO Auto-generated catch block
								ex.printStackTrace();
							}
						}
						else if(emp.getRole().equals("PME")) {
							new PMEHome();
						}
						else {
							new EMPHome(emp);
							//try {
							//	new HRAHome();
							//} catch (ClassNotFoundException | SQLException ex) {
								// TODO Auto-generated catch block
								//ex.printStackTrace();
							//}
						}
					}
					else {
						JFrame f=new JFrame();
						JOptionPane.showMessageDialog(f,"User not activated !...");
					}
				}	
			}
		});
		bRegister=new JButton("REGISTER");
		//Event handling for Register button
		bRegister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					new RegistrationFrame().setVisible(true);
				} catch (ClassNotFoundException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
			
		});
		// Label: create a new account
	    //createAccountLabel.setBounds(182, 407, 138, 16);
	    
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("PCS User Login");
		this.setVisible(true);
		this.setBounds(300,300,700,800);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 19));
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void setLocationAndSize() {
		lblNewLabel_1.setBounds(196, 40, 107, 29);
		lUserId.setBounds(50, 150, 100, 30);
		lPassword.setBounds(50, 250, 100, 30);
		tUserId.setBounds(250, 150, 150, 30);
		tPassword.setBounds(250, 250, 150, 30);
		//createAccountLabel.setBounds(200, 400, 100, 30);
		bLogin.setBounds(100, 400, 100, 30);
		bRegister.setBounds(285, 400, 100, 30);
	}
	public void addComponentsToContainer() {
		container.add(lUserId);
		container.add(tUserId);
		container.add(lPassword);
		container.add(tPassword);
		container.add(bLogin);
		container.add(bRegister);
		container.add(lblNewLabel_1);
		// container.add(createAccountLabel);
		 //createAccountLabel.addMouseListener(new MouseAdapter() {
		   //     @Override
		     //   public void mouseClicked(MouseEvent e) {
		            
		       // }
		    //});
	}

}

