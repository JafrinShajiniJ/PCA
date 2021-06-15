package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import controller.Employeecontroller;
import java.sql.*;
public class ActivateEmpFrame extends JFrame{
	
	Container container;
	JFrame f;
	JLabel lEmpId;
	JTextField tEmpId;
	JButton bActivate;
	Employeecontroller empController=null;
	
	public ActivateEmpFrame() throws ClassNotFoundException, SQLException{
		container=getContentPane();
		f=new JFrame();
		lEmpId=new JLabel("ENTER Employee ID");
		tEmpId=new JTextField();
		bActivate=new JButton("ACTIVATE");
		empController=new Employeecontroller();
		
		bActivate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int s;
				s=Integer.parseInt(tEmpId.getText());
				//empController.activateEmployee(s);
				 String jdbcUrl = "jdbc:h2:tcp://localhost/~/test";
				    String username = "sa";
				    String password = "";
				    String sql = "update employee set active=? where empId=?";

				    try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password); 
				    	PreparedStatement stmt = conn.prepareStatement(sql);) {
				    	stmt.setString(1, "Active");
				        stmt.setInt(2, s);
				    	JFrame g=new JFrame();
						if( stmt.executeUpdate()==1){
							//System.out.println("1 record inserted...");
							JOptionPane.showConfirmDialog(g, "You have successfully added a Employee..");
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
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Activate Employee");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	

	private void setLayoutManager() {
		container.setLayout(null);
		
	}
	private void setLocationAndSize() {
		lEmpId.setBounds(30, 150, 300, 30);
		tEmpId.setBounds(200, 150, 150, 30);
		bActivate.setBounds(200, 250, 100, 30);
	}

	private void addComponentsToContainer() {
		container.add(lEmpId);
		container.add(tEmpId);
		container.add(bActivate);
	}

}
