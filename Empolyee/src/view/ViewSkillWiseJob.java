package view;

import java.awt.Container;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import config.Jdbcconnection;

public class ViewSkillWiseJob extends JFrame {
	JFrame frame;
	Container container;
	public ViewSkillWiseJob() throws ClassNotFoundException, SQLException {
		Connection conn=Jdbcconnection.getDBConnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"SkillId", "FirstName","LastName","SkillName", "SkillDescription", "Jobid","jobTitle"}, 0);
		ResultSet rst=stmt.executeQuery("SELECT skill.SkillId,skill.SkillName,SkillDescription,job.JobId,job.JobTitle,employee.EmpID,employee.Firstname,employee.LastName FROM((Skill INNER JOIN Job ON skill.SkillName = job.JobTitle ) inner join Employee ON  skill.SkillId=employee.EmpId)");
		while(rst.next())
		{
		   int a = rst.getInt("SkillId");
		   String b = rst.getString("SkillName");
		   String c = rst.getString("SkillDescription");
		   String d = rst.getString("JobId");
		    String e = rst.getString("JobTitle");
		    String f = rst.getString("FirstName");
			   String g = rst.getString("LastName");
		    model.addRow(new Object[]{a,b,c,d,e,f,g});
		    table.setModel(model);
		    container=getContentPane();
		    container.setLayout(null);
		    JScrollPane sp=new JScrollPane(table);    
		    container.add(sp);
		    container.add(table);
		    table.setBounds(10,10,800,900);
		    this.setVisible(true);
		    this.setBounds(10,10,800,900);
		    this.setTitle("Skill Information");
		}

	}


}
