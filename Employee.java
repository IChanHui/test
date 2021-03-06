public class Employee
{
	private String name; 	//이름
	private String address; //주소
	private String telNo;	//전화번호
	
	public Employee() {} //default 생성자

	public Employee(String name, String address, String telNo) 
	{
		this.name = name;
		this.address = address;
		this.telNo = telNo;
	}// Employee(name, address, telNo) 생성자

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
		return String.format("이름 : %s, 주소 : %s, 전화번호 : %s",
				name, address, telNo);
	}//toString()
	
	//금여액 출력 메소드 : 상속 받은 클래스에서 오버로딩
	public double salary()
	{
		System.out.println("총수입액");
		return 0;
	}//salary()
}// end of class
