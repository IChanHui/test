public class ProbEmp extends Employee
{
	private double probatSalary; //수습기간의 급여
	
	//g,s
	public double getProbatSalary() {
		return probatSalary;
	}
	public void setProbatSalary(double probatSalary) {
		this.probatSalary = probatSalary;
	}
	
	public ProbEmp() {} //default
	
	public ProbEmp(String name, String telNumber, String address,
			double probatSalary) 
	{
		super(name, telNumber, address);
		this.probatSalary = probatSalary;
	}//ProbEmp(name, telNumber, address, probatSalary) 생성자
	
	public double salary()
	{
		return getProbatSalary();
	}//salary()
	
	public String toString()
	{
		return String.format("\n%s\n%s\n%s : %,.2f",
				"@@@@ 수습사원 @@@@", super.toString(),
				"수습기간 월급", probatSalary);
	}//toString()	
}//end of class
