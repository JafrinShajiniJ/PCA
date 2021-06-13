package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import controller.Employeecontroller;
import controller.Jobcontroller;
import controller.Skillcontroller;
import model.Skill;

public class HRAHome extends JFrame {
	Container container=null;
	 JButton bSetActive,bSetActiveJob,bSetDeactive,bSetDeactiveJob,bViewAllEmp,bViewJob,bAddSkill,bViewSkill,bSetActiveSkill,bSetDeactiveSkill,bLogout;
	 JLabel lTitle,lEmpId;
	 JTextField tEmpId,tData;
	 JFrame f;
	 
	 Employeecontroller empController=null;
	 Jobcontroller jobController=null;
	 Skillcontroller skillController=null;
	 
	 public HRAHome() throws ClassNotFoundException,SQLException {
		 container=getContentPane();
		 empController=new Employeecontroller();
		 jobController=new Jobcontroller();
		 skillController=new Skillcontroller();
		 lTitle=new JLabel("Welcome to HRA Portal");
		 tEmpId=new JTextField();
		 
		 
		 bSetActive=new JButton("Active Users");
		 bSetActive.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 
				 try {
					new ActivateEmpFrame();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			 }
		 });
		 
		 
		 bSetDeactive=new JButton("Deactivate Employee");
			bSetDeactive.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						new DeactivateEmpFrame();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}	
			});
			 
			bViewAllEmp=new JButton("View all Employees");
			bViewAllEmp.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
						try {
							
							new AllEmployeesFrame();
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
					
				}
			});
			
			bViewSkill=new JButton("View all Skills");
			bViewSkill.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					try {
						new AllSkillFrame().setVisible(true);
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}	
			});
			
			bSetDeactiveSkill=new JButton("Deactivate Skill");
			bSetDeactiveSkill.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
						try {
							new DeactivateSkillFrame();
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
				}	
			});
			
			bSetActiveSkill=new JButton("Activate Skill");
			bSetActiveSkill.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
						try {
							new ActivateSkillFrame();
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
					
				}	
			});
			
			bViewJob=new JButton("View all Jobs");
			bViewJob.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					skillController.getAllSkills();
					
				}	
			});
			
			bSetDeactiveJob=new JButton("Deactivate Job");
			bSetDeactiveJob.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
							try {
								new DeactivateJobFrame();
							} catch (ClassNotFoundException | SQLException e1) {
								e1.printStackTrace();
							}
				}	
			});
			
			
			bSetActiveJob=new JButton("Activate Job");
			bSetActiveJob.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
						try {
							new ActivateJobFrame();
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}	
				}	
			});
			
			
			bLogout=new JButton("Logout");
			bLogout.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
				}	
			});
			
			
		 
		 setLayoutManager();
		 setLocationAndSize();
		 addComponentsToContainer();
		 
		 this.setTitle("HRA Frame");
		 this.setVisible(true);
		 this.setBounds(10, 10, 500, 600);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setResizable(false);
	 }
	 
	 public void setLayoutManager() {
		    container.setLayout(null);
	 }
	 public void setLocationAndSize() {
		    lTitle.setBounds(46, 0, 500, 58);
			lTitle.setFont(getFont());
			bViewAllEmp.setBounds(139,38,200,30);
			bSetActive.setBounds(139,131,200,30);
			bSetDeactive.setBounds(139,91,200,30);
			bViewSkill.setBounds(139,171,200,30);
			bSetDeactiveSkill.setBounds(139,218,200,30);
			bSetActiveSkill.setBounds(139,270,200,30);
			bViewJob.setBounds(139,322,200,30);
			bSetDeactiveJob.setBounds(139,373,200,30);
			bSetActiveJob.setBounds(139,425,200,30);
			bLogout.setBounds(150,600,200,30);
	 }
	 public void addComponentsToContainer() {
		    container.add(lTitle);
		    container.add(bSetActive);
		    container.add(bSetDeactive);	
			container.add(bViewAllEmp);
			container.add(bViewSkill);	
			container.add(bSetDeactiveSkill);
			container.add(bSetActiveSkill);
			container.add(bViewJob);	
			container.add(bSetDeactiveJob);
			container.add(bSetActiveJob);
			container.add(bLogout);
			
			JButton btnNewButton = new JButton("Logout");
			btnNewButton.setBounds(139, 494, 200, 30);
			getContentPane().add(btnNewButton);
	 }
}
