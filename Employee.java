public class Employee
{
	private String name; 	//�̸�
	private String address; //�ּ�
	private String telNo;	//��ȭ��ȣ
	
	public Employee() {} //default ������

	public Employee(String name, String address, String telNo) 
	{
		this.name = name;
		this.address = address;
		this.telNo = telNo;
	}// Employee(name, address, telNo) ������

	//g,s name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//g,s getAddress
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	//g,s getTelNo
	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	
	public String toString()
	{
		return String.format("�̸� : %s, �ּ� : %s, ��ȭ��ȣ : %s",
				name, address, telNo);
	}//toString()
	
	//�ݿ��� ��� �޼ҵ� : ��� ���� Ŭ�������� �����ε�
	public double salary()
	{
		System.out.println("�Ѽ��Ծ�");
		return 0;
	}//salary()
}// end of class
