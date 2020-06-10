public class BusinessEmp extends Employee
{
	private double totalSales;		//���Ǹŷ�
	private double commissionRate;  //��������
	
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
	}//BusinessEmp(name, telNumber, address, totalSales, commissionRate) ������
	
	//������� �ѱݿ��� = ���Ǹŷ� * ��������
	public double salary()
	{
		return (getTotalSales() * getCommissionRate());
	}//salary()
	
	public String toString()
	{
		return String.format("%s\n%s\n%s : %,.2f\n%s : %,.2f",
				"@@@ ������� @@@", super.toString(),
				"���Ǹŷ�", totalSales, "�Ǹ� ��������", commissionRate);
	}//toString()
}//end of class
