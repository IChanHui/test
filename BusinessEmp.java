public class BusinessEmp extends Employee
{
	private double totalSales;		//총판매량
	private double commissionRate;  //수수료율
	
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
	
	public BusinessEmp() {}//default
	
	public BusinessEmp(String name, String telNumber, String address,
			double totalSales, double commissionRate) 
	{
		super(name, telNumber, address);
		this.totalSales = totalSales;
		this.commissionRate = commissionRate;
	}//BusinessEmp(name, telNumber, address, totalSales, commissionRate) 생성자
	
	//영업사원 총금여액 = 총판매량 * 수수료율
	public double salary()
	{
		return (getTotalSales() * getCommissionRate());
	}//salary()
	
	public String toString()
	{
		return String.format("%s\n%s\n%s : %,.2f\n%s : %,.2f",
				"@@@ 영업사원 @@@", super.toString(),
				"총판매량", totalSales, "판매 수수료율", commissionRate);
	}//toString()
}//end of class
