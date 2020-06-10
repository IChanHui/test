import java.util.Scanner;
import javax.naming.PartialResultException;

public class SalaryTestCalculate
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 자료수 : ");
		int n = sc.nextInt();
		
		//Employee 배열
		Employee [] employee = new Employee[n];
		
		BusinessEmp businessEmp;	//영업직
		PartTimeEmp partEmp;		//아르바이트
		//****ProbEmp cannot be resolved to a variable****
		//****managerEmp cannot be resolved to a variable****
		ProbEmp = probEmp;			//수습사원
		ManagerEmp = managerEmp; 	//관리직
		
		
		String name, telNumber, address;	//이름, 전화번호, 주소
		double totalSales, commissionRate;  //총판매향, 수수료율
		
		//기본임금, 관리자수당, 수습기간임금
		double baseSalary, managerFee, probatSalary;
		int wage, hours;		// 시간당 임금, 근무시간
		
		for (int i=0; i<n; i++)
		{
			System.out.print("이름 : ");
			name = sc.next();
			System.out.print("전화번호 : ");
			telNumber = sc.next();
			System.out.print("주소 : ");
			address = sc.next();
			System.out.print("사원의 형태 : (1: 영업직, 2: 관리직, 3: 수습사원, 4: 아르바이트) : ");
			int job = sc.nextInt(); //사원 형태 선택
			
			switch(job)
			{
			case 1: //영업사원
				System.out.print("총판매량 : ");
				totalSales = sc.nextDouble();
				System.out.print("수수료율 : ");
				commissionRate = sc.nextDouble();
				businessEmp = new BusinessEmp(name, telNumber, address,
						totalSales, commissionRate);
				employee[i] = businessEmp;
				break;
			case 2: //관리사원
				System.out.print("총판매량 : ");
				totalSales = sc.nextDouble();
				System.out.print("수수료율 : ");
				commissionRate = sc.nextDouble();
				System.out.print("기본임금 : ");
				baseSalary = sc.nextDouble();
				System.out.print("관리자 수당");
				managerFee = sc.nextDouble();
				managerEmp = new ManagerEmp(name, telNumber, address,
						 totalSales, commissionRate, 
						 baseSalary, managerFee);
				employee[i] = managerFee;
				break;
			case 3: //수습사원
				System.out.print("수습기간 급여 : ");
				probatSalary = sc.nextDouble();
				probEmp = new ProbEmp(name, telNumber, address, probatSalary);
				employee[i] = probEmp;
				break;
			case 4: //아르바이트
				System.out.print("시간당 임금 : ");
				wage = sc.nextInt();
				System.out.print("근무시간 : ");
				hours = sc.nextInt();
				partEmp = new PartTimeEmp(name, telNumber, address, wage, hours);
				employee[i] = partEmp;
				break;
				default : System.out.println("사원 입력 오류 : 다시 입력하세요.");
			}// switch(job)
			System.out.println();
		}// for i
		System.out.println("\n\t총수입");
		for(Employee e : employee)
		{
			System.out.printf("%s %s %,.2f\n",e,"총급여액 : ",e.salary());
		}//for employee
	}//end of main
}//end of class
 