package model;

public class Empjob {
	private int EJId;
	private int empId;
	private int JobId;
	private String Recruited;
	
	public Empjob() {
		
	}
	 //parameterized constructor method

	public Empjob(int empId, int jobId, String recruited) {
		super();
		this.empId = empId;
		JobId = jobId;
		Recruited = recruited;
	}

	public int getEJId() {
		return EJId;
	}

	public void setEJId(int eJId) {
		EJId = eJId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getJobId() {
		return JobId;
	}

	public void setJobId(int jobId) {
		JobId = jobId;
	}

	public String getRecruited() {
		return Recruited;
	}

	public void setRecruited(String recruited) {
		Recruited = recruited;
	}

	@Override
	public String toString() {
		return "Empjob [EJId=" + EJId + ", empId=" + empId + ", JobId=" + JobId + ", Recruited=" + Recruited + "]";
	}
}

	
