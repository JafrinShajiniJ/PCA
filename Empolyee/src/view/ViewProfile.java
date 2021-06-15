package view;

import java.awt.Container;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import config.Jdbcconnection;

public class ViewProfile extends JFrame{
	
	JFrame frame;
	Container container;
	JLabel lblNewLabel_1;
	JLabel lEmpId,lFirstname,lLastname,lEmail,lGender,lRole,lActive;
	JTextField tEmpId,tFirstname,tLastname,tEmail,tGender,tRole,tActive;
	
	public ViewProfile (int s) throws ClassNotFoundException, SQLException {
		
		Connection conn=Jdbcconnection.getDBConnection();
		container=getContentPane();
		frame=new JFrame();   
		lblNewLabel_1= new JLabel("Profile Page");
		lEmpId=new JLabel("EmpID");
		lFirstname=new JLabel("First Name");
		lLastname=new JLabel("Last Name");
		lEmail=new JLabel("Email");
		lGender=new JLabel("Gender");
		lRole=new JLabel("Role");
		lActive=new JLabel("Active");
		tEmpId=new JTextField();
		tFirstname=new JTextField();
		tLastname=new JTextField();
		tEmail=new JTextField();
		tGender=new JTextField();
		tRole=new JTextField();
		tActive=new JTextField();
		PreparedStatement pst=conn.prepareStatement("select * from Employee where EMPID=?");
		pst.setInt(1,s);
		ResultSet rst=pst.executeQuery();
		while(rst.next())
		{
		    int a = rst.getInt("EmpId");
		    String b = rst.getString("FirstName");
		    String c = rst.getString("LastName");
		    String d = rst.getString("Email");
		    String e = rst.getString("Gender");
		    String f = rst.getString("Role");
	
		    String g = rst.getString("Active");
		    tEmpId.setText(String.valueOf(a));
		    tFirstname.setText(b);
		    tLastname.setText(c);
		    tEmail.setText(d);
		    tGender.setText(e);
		    tRole.setText(f);
		    tActive.setText(g);
		    container.setLayout(null);
		    setLocationAndSize();
		    addComponentsToContainer();
		    this.setVisible(true);
		    this.setBounds(10,10,500,500);
		    this.setResizable(true);
		    //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setTitle("Your Profile");
		    lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 19));
		}
	}
	private void addComponentsToContainer() {
		container.add(lEmpId);
		container.add(tEmpId);
		container.add(lFirstname);
		container.add(tFirstname);
		container.add(lLastname);
		container.add(tLastname);
		container.add(lEmail);
		container.add(tEmail);
		
		container.add(lGender);
		container.add(tGender);
		container.add(lRole);
		container.add(tRole);
		container.add(lActive);
		container.add(tActive);
	}
	private void setLocationAndSize() {
		lblNewLabel_1.setBounds(196, 40, 107, 29);
		lEmpId.setBounds(30, 100, 100, 30);
		lFirstname.setBounds(30, 150, 100, 30);
		lLastname.setBounds(30, 200, 100, 30);
		lEmail.setBounds(30, 250, 100, 30);
		lGender.setBounds(30, 300, 100, 30);
		lRole.setBounds(30,350,200,30);
		lActive.setBounds(30, 400, 100, 30);
		
		tEmpId.setBounds(300, 100, 150, 30);
		tFirstname.setBounds(300,150,150,30);
		tLastname.setBounds(300, 200, 150, 30);
		tEmail.setBounds(300, 250, 100, 30);
		tGender.setBounds(300,300,150,30);
		tRole.setBounds(300,350,150,30);
		tActive.setBounds(300, 400, 150, 30);
	}
}
