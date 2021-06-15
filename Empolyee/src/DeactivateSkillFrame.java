package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import controller.Skillcontroller;


public class DeactivateSkillFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	Container container;
	JFrame f;
	JLabel lSkillId;
	JTextField tSkillId;
	JButton bDeactivate;
	Skillcontroller skiController=null;
	
	
	public DeactivateSkillFrame() throws ClassNotFoundException, SQLException{
		container=getContentPane();
		f=new JFrame();
		lSkillId=new JLabel("ENTER SKILL ID");
		tSkillId=new JTextField();
		bDeactivate=new JButton("DEACTIVATE");
		skiController=new Skillcontroller();
		
		bDeactivate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int s;
				s=Integer.parseInt(tSkillId.getText());
				//skiController.activateSkill(s);
				 String jdbcUrl = "jdbc:h2:tcp://localhost/~/test";
				    String username = "sa";
				    String password = "";
				    String sql = "update skill set active=? where skillId=?";

				    try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password); 
				    	PreparedStatement stmt = conn.prepareStatement(sql);) {
				    	stmt.setString(1, "Deactive");
				        stmt.setInt(2, s);
				    	JFrame g=new JFrame();
						if( stmt.executeUpdate()==1){
							//System.out.println("1 record inserted...");
							JOptionPane.showConfirmDialog(g, "You have successfully added a Skill..");
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
		this.setTitle("Deactivate Skill");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	

	private void setLayoutManager() {
		container.setLayout(null);
		
	}
	private void setLocationAndSize() {
		lSkillId.setBounds(30, 150, 300, 30);
		tSkillId.setBounds(200, 150, 150, 30);
		bDeactivate.setBounds(200, 250, 100, 30);
	}

	private void addComponentsToContainer() {
		container.add(lSkillId);
		container.add(tSkillId);
		container.add(bDeactivate);
	}

}
