package member;

import java.util.List;
import java.util.Scanner;

public class MemberConsoleUtil {

	public MemberConsoleUtil() {
	}

	public Member getNewmamber(Scanner sc) {
		System.out.println("등록할 회원 정보를 입력하세요");

		System.out.print("아이디 : ");
		int id = sc.nextInt();

		System.out.print("이름 : ");
		String name = sc.next();

		System.out.print("주소 : ");
		String addr = sc.next();

		System.out.print("이메일 : ");
		String email = sc.next();

		System.out.print("국가 : ");
		String nation = sc.next();

		System.out.print("나이 : ");
		int age = sc.nextInt();

		return new Member(id, name, addr, email, nation, age);
	}

	public void printAddSuccessMessage(Member member) {
		System.out.println(member.getName() + "회원 정보 추가 성공");
	}

	public void printeModifySuccessMessage(Member member) {
		System.out.println(member.getName() + "회원 정보 추가 성공");
	}

	public void printModifyFailMessage() {
		System.out.printf("회원 정보 수정 실패");
	}

	public void printRemoveFailMessage() {
		System.out.printf("회원 정보 삭제 실패");
	}

	public void printRemovSuccessMessage(Member member) {
		System.out.printf(member.getName() + "회원 정보 삭제 성공");
	}

	public void printMemberList(List<Member> list) {
		System.out.println("멤버 리스트 출력");
		System.out.println("아이디\t이름\t주소\t이메일\t국가\t나이");
		for (Member member : list) {
			System.out.print(member.getId() + "\t");
			System.out.print(member.getName() + "\t");
			System.out.print(member.getAddr() + "\t");
			System.out.print(member.getEmail() + "\t");
			System.out.print(member.getNation() + "\t");
			System.out.print(member.getAge() + "\n");
		}
	}

	public Member getUpdateMember(Scanner sc, List<Member> list) {
		System.out.println("수정할 정보 입력");
		System.out.print("아이디 : ");
		int id = sc.nextInt();

		// 아이디가 있을경우 수정
		Member member = null;
		for (int i = 0; i < list.size(); i++) {
			member = list.get(i);
			if (member.getId() == id) {
				System.out.println("주소 : ");
				String addr = sc.next();
				System.out.println("이메일 : ");
				String email = sc.next();

				member.setAddr(addr);
				member.setEmail(email);
				return member;
			}
		}
		return null;
	}

	public Member removeMember(Scanner sc, List<Member> list) {
		System.out.print("삭제할 회원 아이디 입력 : ");
		int id = sc.nextInt();

		Member member = null;
		for (int i = 0; i < list.size(); i++) {
			member = list.get(i);
			if (member.getId() == id) {
				System.out.print("정말 삭제하시겠습니까? 예(1) 아니오(2) : ");
				int sel = sc.nextInt();
				if (sel == 1) {
					list.remove(i);
					return member;
				}

			}

		}
		return null;
	}

}
