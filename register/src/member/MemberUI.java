package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberUI {

	public static void main(String[] args) {

		boolean isStop = false;
		Scanner sc = new Scanner(System.in);
		MemberConsoleUtil util = new MemberConsoleUtil();
		List<Member> list = new ArrayList<Member>();

		do {
			System.out.println(" ******* 회원관리 프로그램 ******* ");
			System.out.println("1. 회원등록");
			System.out.println("2. 회원목록 보기");
			System.out.println("3. 회원정보 수정");
			System.out.println("4. 회원정보 삭제");
			System.out.println("5. 프로그램 종료");
			System.out.print("메뉴 번호 : ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				Member member = util.getNewmamber(sc);
				list.add(member);
				util.printAddSuccessMessage(member);
				break;

			case 2:
				util.printMemberList(list);
				break;

			case 3:
				member = util.getUpdateMember(sc, list);
				if (member == null) {
					util.printModifyFailMessage();
				} else {
					util.printeModifySuccessMessage(member);
				}
				break;

			case 4:
				member = util.removeMember(sc, list);
				if (member == null) {
					util.printRemoveFailMessage();
				} else {
					util.printRemovSuccessMessage(member);
				}

				break;
			case 5:
				isStop = true;
				System.out.println("프로그램을 종료합니다");
				break;

			default:

				break;
			}

		} while (!isStop);

	}

}
