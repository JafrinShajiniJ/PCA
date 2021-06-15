package controller;

import java.io.*;
import java.sql.*;
import java.util.*;

import dao.Ijobdao;
import daoimp.Jobdao;
import model.Job;
import model.Skill;

public class Jobcontroller {
		Ijobdao Jobdao=null;
		public Jobcontroller() throws ClassNotFoundException, SQLException{
			Jobdao=(Ijobdao) new Jobdao();
		}
		public void addJob(String JBT, String JD, String CN,String LC, String KS, String JS ) {
			Job j=new Job();
				
				j.setJobTitle(JBT);
				j.setJobDescription(JD);
				j.setCompanyName(CN);
				j.setLocation(LC);
				j.setKeySkill(KS);
				j.setSalary(JS);
				if(JBT.equals("HR")) {
					j.setActive("Activated");
				}
				else {
					j.setActive("Deactivated");
				}
				//Calling dao method for insert record
				Jobdao.addJob(j);
			}
			
			public void getAllJobs() {
				
				List<Job> allJobList=Jobdao.getAllJobs();
				for(Job j:allJobList) {
					System.out.println(j);
				}
			}
			public void getJobById() {
				try {
					BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
					int id;
					System.out.println("Enter EmployeeId whose record you want to access: ");
					id=Integer.parseInt(reader.readLine());
					Job j=Jobdao.getJobById(id);
					System.out.println(j);
					}
				catch(IOException ex) {
					System.out.println(ex.getMessage());
					}
				}
			public void updateJob() {
				try {
					BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
					int id;
					String location, confirmlocation;
					System.out.println("Enter JobId whose record you want to update:");
					id=Integer.parseInt(reader.readLine());
					Job j=Jobdao.getJobById(id);
					System.out.println("Enter your new location:");
					location=reader.readLine();
					System.out.println("re-enter same Location to confirm:");
					confirmlocation=reader.readLine();
					if(location.contentEquals(confirmlocation)) {
						j.setLocation(location);
						Jobdao.updateJob(j);
					}
					else {
						System.out.println("Sorry! you have entered different location");
					}
					System.out.println(j);
				}
				catch(IOException ex) {
					System.out.println(ex.getMessage());
				}
			}
			public void deactivateJob(int s) {
				Job job=Jobdao.getJobById(s);
				Jobdao.activateJob(job);
				}
			//public void activateJob(int s) {
				//try {
				//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
				//int id;
				//id=Integer.parseInt(reader.readLine());
				//Job j=Jobdao.getJobById(s);
				//Jobdao.activateJob(j);
			//}
				//catch(IOException ex){
					//System.out.println(ex.getMessage());
				//}
					
				//}
			public void activateJob(int s) {
				Job job=Jobdao.getJobById(s);
				Jobdao.activateJob(job);
				
			}
			public void DeleteJob() {
				try {
					BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
					int id;
					System.out.println("Enter JobId whose record you want to delete: ");
					id=Integer.parseInt(reader.readLine());
					Jobdao.deleteJob(id);
				}
				catch(IOException ex) {
					System.out.println(ex.getMessage());
				}
			}
}
