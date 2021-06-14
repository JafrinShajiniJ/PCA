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
import java.sql.SQLException;
import config.Jdbcconnection;

public class UpdateProfile extends JFrame {

	private JPanel contentPane;
	private JTextField tFirstName;
	private JTextField tLastName;
	private JTextField tUserId;
	private JPasswordField tPassword;
	private JPasswordField tConfirmPassword;
	private JTextField tEmail;
	private JTextField tRole;
	private JTextField tGender;
	
	private static JFrame f;
	private static Employeecontroller employeecontroller=null;

	/**
	 * Launch the application.
	 */
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
		
		f=new JFrame();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 727);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		//contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new LineBorder(null, 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(283, 31, 340, 33);
		contentPane.add(lblNewLabel);
		
				
		tFirstName = new JTextField();
		tFirstName.setBounds(16, 140, 268, 33);
		contentPane.add(tFirstName);
		tFirstName.setColumns(10);
		
		tLastName = new JTextField();
		tLastName.setColumns(10);
		tLastName.setBounds(355, 140, 268, 33);
		contentPane.add(tLastName);
		
		tUserId = new JTextField();
		tUserId.setColumns(10);
		tUserId.setBounds(16, 234, 268, 33);
		contentPane.add(tUserId);
		
		tEmail = new JTextField();
		tEmail.setBounds(355,234,268,33);
      	tEmail.setColumns(10);
		contentPane.add(tEmail);
		
		
		JLabel LFirstName = new JLabel("First Name");
		LFirstName.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		LFirstName.setBounds(16, 119, 109, 16);
		contentPane.add(LFirstName);
		
		JLabel lLastName = new JLabel("Last Name");
		lLastName.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lLastName.setBounds(355, 119, 109, 16);
		contentPane.add(lLastName);
		
		JLabel lUserId = new JLabel("User ID");
		lUserId.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lUserId.setBounds(16, 213, 109, 16);
		contentPane.add(lUserId);
		
		// label: emailLabel
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		emailLabel.setBounds(355, 213, 109, 16);
		contentPane.add(emailLabel);
		
		JLabel lPassword = new JLabel(" Create Password");
		lPassword.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lPassword.setBounds(16, 310, 268, 16);
		contentPane.add(lPassword);
		
		JLabel lConfirmPassword = new JLabel("Confirm Password");
		lConfirmPassword.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lConfirmPassword.setBounds(355, 310, 268, 16);
		contentPane.add(lConfirmPassword);
		
		JLabel lRole = new JLabel("Gender");
		lRole.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lRole.setBounds(355, 413, 109, 16);
		contentPane.add(lRole);
		
 		
		
		JLabel lGender = new JLabel("Role");
		lGender.setFont(new Font("Apple Braille", Font.PLAIN, 15));
		lGender.setBounds(16, 413, 109, 16);
		contentPane.add(lGender);
		
		
		JButton bSubmit = new JButton("Submit");
		employeecontroller=new Employeecontroller();
		bSubmit.addActionListener(new ActionListener() {
			@Override
			public  void actionPerformed(ActionEvent arg0) {
				String UFN, ULN, UID, UE,UP,UR,UG, UCP;
				UFN=tFirstName.getText();
				ULN=tLastName.getText();
				UID=tUserId.getText();
				UE=tEmail.getText();
				UP=new String(tPassword.getPassword());
				UR=tRole.getText();
				UG=tGender.getText();
				UCP=new String(tConfirmPassword.getPassword());
				if(UP.equals(UCP)) {
					
					employeecontroller.addEmployee(UFN, ULN, UID,UE, UP,UR, UG);
					JOptionPane.showMessageDialog(f, "Registered Successfully...");
						

				}
				else {
					JOptionPane.showMessageDialog(f, "Check your Password and Retry...");
				}
			}
		});
		bSubmit.setBackground(Color.LIGHT_GRAY);
		bSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		bSubmit.setBounds(280, 622, 142, 40);
		contentPane.add(bSubmit);
		
		tPassword = new JPasswordField();
		tPassword.setBounds(16, 331, 268, 33);
		contentPane.add(tPassword);
		
		tConfirmPassword = new JPasswordField();
		tConfirmPassword.setBounds(355, 331, 268, 33);
		contentPane.add(tConfirmPassword);
		
		tRole = new JTextField();
		tRole.setColumns(10);
		tRole.setBounds(355, 441, 268, 33);
		contentPane.add(tRole);
		
		tGender = new JTextField();
		tGender.setColumns(10);
		tGender.setBounds(16, 441, 268, 33);
		contentPane.add(tGender);
		
		
	}
}
