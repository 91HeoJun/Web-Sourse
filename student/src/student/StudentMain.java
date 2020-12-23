package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean roof = false;
		StudentVO student = null;
		List<StudentVO> list = new ArrayList<StudentVO>();

		do {
			System.out.println("--------- <학생 정보 관리 프로그램 > ---------");
			System.out.println("  1. 학생정보 입력");
			System.out.println("  2. 학생정보 전체조회");
			System.out.println("  3. 학생정보 개별조회");
			System.out.println("  4. 프로그램 종료");
			System.out.print("선택 : ");
			int select = sc.nextInt();

			switch (select) {
			case 1:

				System.out.println("---- 새로운 학생 정보 입력 ----");
				System.out.print("학 번 : ");
				int stuNo = sc.nextInt();

				System.out.print("이 름 : ");
				String name = sc.next();

				System.out.print("학 년 : ");
				int grade = sc.nextInt();

				System.out.print("주 소 : ");
				String addr = sc.next();
				
				System.out.print("생 일(예시 : 05/11) : ");
				String birthday = sc.next();
				
				student = new StudentVO(stuNo, name, grade, addr, birthday);
				
				list.add(student);
				
				System.out.println(student.getName() + "학생 정보가 입력되었습니다.");

				break;

			case 2:
				System.out.println("---- 학생 정보 보기 ----");
				System.out.println("학 번\t이 름\t학 년");
				System.out.println("---------------------");


				for (StudentVO vo : list) {
					System.out.print(vo.getStuNo() + "\t");	
					System.out.print(vo.getName() + "\t");	
					System.out.println(vo.getGrade() + "\t");	
				}
				
				break;

			case 3:
				System.out.print("검색하고자 하는 학생의 학번을 입력하세요 : ");
				int check = sc.nextInt();
				
				System.out.println("---- 학생 개별 정보 보기 ----");
			
				if (check == student.getStuNo()) {
					for (StudentVO vo1 : list) {
						System.out.println("이름 : " + vo1.getName());
						System.out.println("학년 : " + vo1.getGrade());
						System.out.println("주소 : " + vo1.getAddr());
						System.out.println("생일 : " + vo1.getBirthday());
					}


				} else {
					System.out.println("학번을 확인하세요");
				}
				
				break;

			case 4:
				System.out.println("프로그램 종료");
				roof = true;
				break;

			default:
				break;
			}

		} while (!roof);
	}

}
