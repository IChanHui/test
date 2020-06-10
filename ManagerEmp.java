public class ManagerEmp extends Employee
{
	private double totalSales;		//총판매량
	private double commissionRate;  //수수료율
	private double baseSalary;		//기본임금
	private double managerFee;		//관리자수당
	
	//g,s
	public double getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(double totalSales) {
		this.totalSales = totalSales;
	}
	public double getCommissionRate() {
		return commissionRate;
	}
	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}
	public double getBaesSalary() {
		return baseSalary;
	}
	public void setBaesSalary(double baesSalary) {
		this.baseSalary = baesSalary;
	}
	public double getManagerFee() {
		return managerFee;
	}
	public void setManagerFee(double managerFee) {
		this.managerFee = managerFee;
	}
	
	public ManagerEmp() {} //default
	
	public ManagerEmp(String name, String telNumber, String address,
			double totalSales, double commissionRate, 
			double baseSalary, double managerFee) 
	{
		super(name, telNumber, address);
		this.totalSales = totalSales;
		this.commissionRate = commissionRate;
		this.baseSalary = baseSalary;
		this.managerFee = managerFee;
	}//ManagerEmp(~7~) 생성자
	
	//총금여액 = (총판매량 * 수수료율) + 기보님금 + 관리자수당
	public double salary()
	{
		double totalGrosssales = 
				(getTotalSales() * getCommissionRate()) +
				getBaesSalary() + getManagerFee();
		return totalGrosssales;
	}//salary()
	
	public String toString()
	{
		return String.format("\n%s\n%s : %,.2f\n%s : %,.2f\n%s : %,.2f\n%s : %,.2f"
				,"@@@ 관리사원 @@@",
				"총판매량", totalSales, "판매 수수료율", commissionRate
				,"기본임금", baseSalary, "관리자수당", managerFee);
	}
}// end of calss
