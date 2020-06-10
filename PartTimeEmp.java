public class PartTimeEmp extends Employee
{
	private int wage;	//시간당임금
	private int hours;	//근무시간
	
	//g,s
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	public PartTimeEmp() {} //default
	
	public PartTimeEmp(String name, String telNumber, String address,
			int wage, int hours) 
	{
		super(name, telNumber, address);
		this.wage = wage;
		this.hours = hours;
	}//partTimeEmp(name, telNumber, address, wage, hours) 생성자
	
	//총급여액 = 시간당임금 * 근무시간
	//근무시간이 40시간 이상 근무 시 40시간을 초과하는 부분에는 시간당 1.6배 임금 지급
	public double salary()
	{
		double totalWagePerHours;
		if(hours < 40)
			totalWagePerHours = hours * wage;
		else
			totalWagePerHours = 
			(40*wage) + (hours - 40) * wage*1.6;
		return totalWagePerHours;
	}//salary()
	
	public String toString()
	{
		return String.format("\n%s\n%s\n%s : %d\n%s : %d",
				"@@@@ 아르바이트 @@@@", super.toString(),
				"시간당 임금", wage, "근무시간", hours);
	}//toString()
}//end of class
