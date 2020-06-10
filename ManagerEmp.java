public class ManagerEmp extends Employee
{
	private double totalSales;		//���Ǹŷ�
	private double commissionRate;  //��������
	private double baseSalary;		//�⺻�ӱ�
	private double managerFee;		//�����ڼ���
	
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
	}//ManagerEmp(~7~) ������
	
	//�ѱݿ��� = (���Ǹŷ� * ��������) + �⺸�Ա� + �����ڼ���
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
				,"@@@ ������� @@@",
				"���Ǹŷ�", totalSales, "�Ǹ� ��������", commissionRate
				,"�⺻�ӱ�", baseSalary, "�����ڼ���", managerFee);
	}
}// end of calss
