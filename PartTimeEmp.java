public class PartTimeEmp extends Employee
{
	private int wage;	//�ð����ӱ�
	private int hours;	//�ٹ��ð�
	
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
	}//partTimeEmp(name, telNumber, address, wage, hours) ������
	
	//�ѱ޿��� = �ð����ӱ� * �ٹ��ð�
	//�ٹ��ð��� 40�ð� �̻� �ٹ� �� 40�ð��� �ʰ��ϴ� �κп��� �ð��� 1.6�� �ӱ� ����
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
				"@@@@ �Ƹ�����Ʈ @@@@", super.toString(),
				"�ð��� �ӱ�", wage, "�ٹ��ð�", hours);
	}//toString()
}//end of class
