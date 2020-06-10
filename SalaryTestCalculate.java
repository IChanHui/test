import java.util.Scanner;
import javax.naming.PartialResultException;

public class SalaryTestCalculate
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է� �ڷ�� : ");
		int n = sc.nextInt();
		
		//Employee �迭
		Employee [] employee = new Employee[n];
		
		BusinessEmp businessEmp;	//������
		PartTimeEmp partEmp;		//�Ƹ�����Ʈ
		//****ProbEmp cannot be resolved to a variable****
		//****managerEmp cannot be resolved to a variable****
		ProbEmp = probEmp;			//�������
		ManagerEmp = managerEmp; 	//������
		
		
		String name, telNumber, address;	//�̸�, ��ȭ��ȣ, �ּ�
		double totalSales, commissionRate;  //���Ǹ���, ��������
		
		//�⺻�ӱ�, �����ڼ���, �����Ⱓ�ӱ�
		double baseSalary, managerFee, probatSalary;
		int wage, hours;		// �ð��� �ӱ�, �ٹ��ð�
		
		for (int i=0; i<n; i++)
		{
			System.out.print("�̸� : ");
			name = sc.next();
			System.out.print("��ȭ��ȣ : ");
			telNumber = sc.next();
			System.out.print("�ּ� : ");
			address = sc.next();
			System.out.print("����� ���� : (1: ������, 2: ������, 3: �������, 4: �Ƹ�����Ʈ) : ");
			int job = sc.nextInt(); //��� ���� ����
			
			switch(job)
			{
			case 1: //�������
				System.out.print("���Ǹŷ� : ");
				totalSales = sc.nextDouble();
				System.out.print("�������� : ");
				commissionRate = sc.nextDouble();
				businessEmp = new BusinessEmp(name, telNumber, address,
						totalSales, commissionRate);
				employee[i] = businessEmp;
				break;
			case 2: //�������
				System.out.print("���Ǹŷ� : ");
				totalSales = sc.nextDouble();
				System.out.print("�������� : ");
				commissionRate = sc.nextDouble();
				System.out.print("�⺻�ӱ� : ");
				baseSalary = sc.nextDouble();
				System.out.print("������ ����");
				managerFee = sc.nextDouble();
				managerEmp = new ManagerEmp(name, telNumber, address,
						 totalSales, commissionRate, 
						 baseSalary, managerFee);
				employee[i] = managerFee;
				break;
			case 3: //�������
				System.out.print("�����Ⱓ �޿� : ");
				probatSalary = sc.nextDouble();
				probEmp = new ProbEmp(name, telNumber, address, probatSalary);
				employee[i] = probEmp;
				break;
			case 4: //�Ƹ�����Ʈ
				System.out.print("�ð��� �ӱ� : ");
				wage = sc.nextInt();
				System.out.print("�ٹ��ð� : ");
				hours = sc.nextInt();
				partEmp = new PartTimeEmp(name, telNumber, address, wage, hours);
				employee[i] = partEmp;
				break;
				default : System.out.println("��� �Է� ���� : �ٽ� �Է��ϼ���.");
			}// switch(job)
			System.out.println();
		}// for i
		System.out.println("\n\t�Ѽ���");
		for(Employee e : employee)
		{
			System.out.printf("%s %s %,.2f\n",e,"�ѱ޿��� : ",e.salary());
		}//for employee
	}//end of main
}//end of class
 