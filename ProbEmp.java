public class ProbEmp extends Employee
{
	private double probatSalary; //�����Ⱓ�� �޿�
	
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
	}//ProbEmp(name, telNumber, address, probatSalary) ������
	
	public double salary()
	{
		return getProbatSalary();
	}//salary()
	
	public String toString()
	{
		return String.format("\n%s\n%s\n%s : %,.2f",
				"@@@@ ������� @@@@", super.toString(),
				"�����Ⱓ ����", probatSalary);
	}//toString()	
}//end of class
