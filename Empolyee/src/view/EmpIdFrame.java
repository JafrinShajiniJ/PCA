package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import controller.Employeecontroller;

public class EmpIdFrame extends JFrame{
	Container container;
	JFrame f;
	JLabel lEmpId;
	JTextField tEmpId;
	JButton bSubmit;
	Employeecontroller empController=null;

	
	public EmpIdFrame() throws ClassNotFoundException, SQLException{
		container=getContentPane();
		f=new JFrame();
		lEmpId=new JLabel("ENTER EMPLOYEE ID");
		tEmpId=new JTextField();
		bSubmit=new JButton("SUBMIT");
		empController=new Employeecontroller();
		//int s=emp.getEmpId();
		String text = tEmpId.getText();
		int s = Integer.parseInt(text);
		//int number=Integer.parseInt(tEmpId.getText(""));
		bSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new SelectEmpDataFrame();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		this.setTitle("View Employee");
		this.setVisible(true);
		this.setBounds(10,10,500,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	private void setLayoutManager() {
		container.setLayout(null);
		
	}
	private void setLocationAndSize() {
		lEmpId.setBounds(30, 150, 250, 30);
		tEmpId.setBounds(200, 150, 150, 30);
		bSubmit.setBounds(200, 250, 100, 30);
	}

	private void addComponentsToContainer() {
		container.add(lEmpId);
		container.add(tEmpId);
		container.add(bSubmit);
	}


}
