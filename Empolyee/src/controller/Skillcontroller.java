package controller;

import java.io.*;
import java.sql.*;
import java.util.*;
import dao.Iskilldao;
import model.Employee;
import model.Skill;
import daoimp.Skilldao;
import model.Empskill;

public class Skillcontroller {

	Iskilldao skDao=null;
	public Skillcontroller() throws ClassNotFoundException,SQLException
	{
		skDao=(Iskilldao) new Skilldao();
	}
	
	public void addSkill(String SN, String SD)  throws IOException {
		Skill ski=new Skill();
		ski.setSkillName(SN);	
		ski.setSkillDescription(SD);
		if(SN.equals("Leadership")) {
			ski.setActive("Active");
		}
		else {
			ski.setActive("Deactive");
		}
		//Calling dao method for insert record
		skDao.addSkill(ski);
	}
	
	public void getAllSkills() {
		List<Skill> allSkillList=skDao.getAllSkills();
		for (Skill ski:allSkillList) {
			System.out.println(ski);
		}
	}
	
	public void getSkillById() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			//System.out.println("Enter SkillId whose record you want to access: ");
			id=Integer.parseInt(reader.readLine());
			Skill ski=skDao.getSkillById(id);
			//System.out.println(sk);
			}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
			}
	}
	public void updateSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			String skill, skilldescription;
			System.out.println("Enter SkillId of the record you want to update:");
			id=Integer.parseInt(reader.readLine());
			Skill ski=skDao.getSkillById(id);
			System.out.println("Add your new Skill:");
			skill=reader.readLine();
			System.out.println("Enter your new Skill description:");
			skilldescription=reader.readLine();
			ski.setSkillName(skill);
			ski.setSkillDescription(skilldescription);
			skDao.updateSkill(ski);
			System.out.println(ski);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deactivateSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			//System.out.println("Enter SkillId whose record you want to deactivate:");
			id=Integer.parseInt(reader.readLine());
			Skill sk=skDao.getSkillById(id);
			skDao.deactivateSkill(sk);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void DeleteSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			//System.out.println("Enter SkillId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			skDao.deleteSkill(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void activateSkill(int s) {
		Skill sk=skDao.getSkillById(s);
		skDao.activateSkill(sk);
		
	}
	
}