package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Employeecontroller;

public class ApplyJobFrame extends JFrame {
	
	Container container;
	JLabel lRecruited,lEmployeeId,lJobId;
	JTextField tRecruited,tEmpId,tJobId;
	JButton bSubmit;
	Employeecontroller empController=null;
	JFrame f;
	public ApplyJobFrame() throws ClassNotFoundException, SQLException {
		container=getContentPane();
		empController=new Employeecontroller();
		lRecruited=new JLabel("Recruited(yes/no)");
		lEmployeeId=new JLabel("Employee ID");
		lJobId=new JLabel("Job ID");
		tRecruited=new JTextField();
		tEmpId=new JTextField();
		tJobId=new JTextField();
		
		bSubmit=new JButton("SUBMIT");
		//Event handling for Register button
		bSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int s1,s2;
				String s3;
				s3=tRecruited.getText();
				s1=Integer.parseInt(tEmpId.getText());
				s2=Integer.parseInt(tJobId.getText());
				empController.addEmpJob(s1, s2,s3);
			}
			
		});
		
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("Apply Job");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}


	private void setLayoutManager() {
		container.setLayout(null);
		
	}


	public void setLocationAndSize() {
		lEmployeeId.setBounds(50, 150, 100, 30);
		lJobId.setBounds(50, 250, 100, 30);
		lRecruited.setBounds(50, 350, 100, 30);
		
		tEmpId.setBounds(200, 150, 150, 30);
		tJobId.setBounds(200, 250, 150, 30);
		tRecruited.setBounds(200, 350, 150, 30);
		
		bSubmit.setBounds(100, 500, 100, 30);
	}
	
	public void addComponentsToContainer() {
		container.add(lEmployeeId);
		container.add(tEmpId);
		container.add(tJobId);
		container.add(lJobId);
		container.add(lRecruited);
		container.add(lJobId);
		container.add(tRecruited);
		container.add(bSubmit);
		
	}

}
