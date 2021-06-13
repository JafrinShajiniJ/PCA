package dao;

import java.util.List;
import model.Empjob;

public interface IEmpjobdao {
	List<Empjob> getAllEmpJobs();
	void addEmpJob(Empjob empj);
	Empjob getEmpJobById(int id);
	void updateEmpJob(Empjob empj);
	void deleteEmpJob(int id);
	
}
