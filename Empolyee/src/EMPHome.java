package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import view.ViewProfile;
import view.UpdateProfile;
import javax.swing.*;

import controller.Employeecontroller;
import model.Employee;

public class EMPHome extends JFrame{
	
	Container container=null;
	JLabel lTitle;
	JButton bViewprofile,bUpdateProfile,bApplyJob,bLogout;
	private Employeecontroller empController;
	
	public EMPHome(Employee emp) {
		
		container=getContentPane();
		try {
			empController = new Employeecontroller();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lTitle=new JLabel("Welcome to your Dashboard"+" " + emp.getFirstName()+".");
		bViewprofile=new JButton("View Profile");
		bViewprofile.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
					try {
						int s=emp.getEmpId();
						new ViewProfile(s);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		);
		bUpdateProfile=new JButton("Update your profile");
		bUpdateProfile.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new UpdateProfile().setVisible(true);;
				} catch (ClassNotFoundException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}	
		});
		bApplyJob=new JButton("Apply for a Job");
		bApplyJob.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					new ApplyJobFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}	
		
		});
		bLogout=new JButton("Logout");
		bLogout.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Logout();
            }
        });
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Employee Home Screen");
		this.setVisible(true);
		this.setBounds(10,10,500,450);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	public void setLayoutManager() {
		container.setLayout(null);
	}
	public void Logout() {
		this.dispose();
	}
	public void setLocationAndSize() {
		lTitle.setBounds(180,50,300,30);
		bViewprofile.setBounds(100, 100, 300, 30);
		bUpdateProfile.setBounds(100, 150, 300, 30);
		bApplyJob.setBounds(100, 262, 300, 30);
		bLogout.setBounds(100, 323, 300, 30);
		
	}
	public void addComponentsToContainer() {
		container.add(lTitle);
		container.add(bViewprofile);
		container.add(bUpdateProfile);
		container.add(bApplyJob);
		container.add(bLogout);
		
		JButton btnNewButton = new JButton("Add skill");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				new AddSkillFrame();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		btnNewButton.setBounds(100, 211, 300, 21);
		getContentPane().add(btnNewButton);
		
		
	}
	 private void bLogoutActionPerformed(ActionEvent evt) {
         System.exit(0);
     }
}
