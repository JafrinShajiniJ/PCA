package view;

import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.EmpIdFrame;

import config.Jdbcconnection;

public class SelectEmpDataFrame extends JFrame {
	JFrame frame;
	Container container;
	public SelectEmpDataFrame() throws ClassNotFoundException, SQLException {
		Connection conn=Jdbcconnection.getDBConnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		EmpIdFrame empId=new EmpIdFrame();
		DefaultTableModel model = new DefaultTableModel(new String[]{"EmpId", "FirstName", "LastName","Email", "Role","Gender", "Active"}, 0);
		PreparedStatement pst=conn.prepareStatement("select * from Employee where EmpId=?");
		pst.setInt(1,Integer.parseInt(empId.tEmpId.getText()));
		ResultSet rst=pst.executeQuery();
		if(rst!=null) {
			if(rst.next()) {
			    int a = rst.getInt("EmpId");
			    String b = rst.getString("FirstName");
			    String c = rst.getString("LastName");
			    String d = rst.getString("Email");
			    String e = rst.getString("Role");
			    String f = rst.getString("Gender");
			    String g = rst.getString("Active");
			    model.addRow(new Object[]{a,b,c,d,e,f,g});
			}
		}
		
		table.setModel(model);
	    container=getContentPane();
	    setLayoutManger();
	    JScrollPane sp=new JScrollPane(table);  
	    
	    container.add(sp);
	    container.add(table);
	    
	    table.setBounds(10,10,800,900);
	    this.setVisible(true);
	    this.setBounds(10,10,800,900);	    
		this.setTitle("Selected Employee Data");
	}
	private void setLayoutManger() {
		container.setLayout(null);
		
	}

}
