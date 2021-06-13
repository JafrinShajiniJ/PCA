package entry;

import java.sql.SQLException;
import java.util.Scanner;

import config.Jdbcconnection;
import controller.Employeecontroller;

public class Entryclass {
	public void testConnection() throws ClassNotFoundException, SQLException {
		if(Jdbcconnection.getDBConnection().isClosed()) {
			System.out.println("Connection is Closed");
		}
		else {
			System.out.println("Connection is Opened");
		}
		
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Entryclass entr=new Entryclass();
		//entr.testConnection();
		Employeecontroller empController=new Employeecontroller();
		Scanner sc=new Scanner(System.in);
		int option;
		char ch='y';
		while(ch=='y' || ch=='Y') {
			System.out.println("CRUD Operation Menu: ");
			System.out.println("1. View all Employees records");
			System.out.println("2. View Single Employees record");
			System.out.println("3. Add an Employee");
			System.out.println("4. Update an Employee Record");
			System.out.println("5. Deactive an Employee record");
			System.out.println("6. Delete an Employees record");
			System.out.println("7. Exit");
			System.out.println("What's Your Choice: ");
			option=sc.nextInt();
			switch(option) {
			case 1:
				System.out.println("Following are all Employees Detail: ");
				empController.getAllEmployees();
				break;
			case 2:
				empController.getEmployeeById(option);
				break;
			case 3:
				System.out.println("Enter Employee Detail: ");
				empController.addEmployee(null, null, null, null, null, null, null);
				break;
			case 4:
				empController.updateEmployee();
				break;
			case 5:
				empController.deactivateEmployee(option);
				break;
			case 6:
				empController.deleteEmployee();
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong Input");
			}
		}
		System.out.println("Do you want to continue? (Y/N)");
		ch=sc.next().charAt(0);
		

	}

}
