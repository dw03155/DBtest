package co.hazzys.prj.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.hazzys.prj.service.MemberService;
import co.hazzys.prj.serviceImpl.MemberServiceImpl;
import co.hazzys.prj.vo.MemberVO;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private MemberService dao = new MemberServiceImpl();

	private void menuTitle() {
		System.out.println("◼◻◼◻◼◻◼◻◼◻◼◻◼");
		System.out.println(" <<회원관리시스템>>");
		System.out.println(" 1.회원 목록 조회");
		System.out.println(" 2.회원 정보 조회");
		System.out.println(" 3.회원 정보 등록");
		System.out.println(" 4.회원 정보 수정");
		System.out.println(" 5.회원 정보 삭제");
		System.out.println("  6.시스템 종료");
		System.out.println("◼◻◼◻◼◻◼◻◼◻◼◻◼");
		System.out.println("원하는 메뉴 번호를 입력하세요.");
	}// end of MT

	private void mainMenu() {
		int jobNo;
		boolean run = false;

		do {
			menuTitle();
			switch (jobNo = sc.nextInt()) {
			case 1:
				memberList();
				break;
			case 2:
				memberSelect();
				break;
			case 3:
				memberInsert();
				break;
			case 4:
				memberUpdate();
				break;
			case 5:
				memberDelete();
				break;
			case 6:
				run = true;
				System.out.println("프로그램을 종료합니다.");
				break;
			}

		} while (!run);
	}// end of MM

	private void memberList() { // 회원 전체 조회
		List<MemberVO> members = new ArrayList<MemberVO>();
		members = dao.memberSelectList();
		for (MemberVO member : members) {
			member.toString();
		}
	}// end of ML

	public void run() {
		mainMenu();
		sc.close();
	}

	private void memberSelect() { // 회원 검색 (한건 조회)
		MemberVO vo = new MemberVO();
		System.out.print("검색할 ID를 입력하세요.");
		vo.setId(sc.next());
		sc.nextLine();

		vo = dao.memberSelect(vo);
		vo.toString();
	}// end of MS

	private void memberInsert() { // 회원 입력
		MemberVO vo = new MemberVO();
		System.out.print("회원의 ID를 입력하세요.");
		vo.setId(sc.next());
		sc.nextLine();
		System.out.print("회원의 Password를 입력하세요.");
		vo.setPassword(sc.next());
		sc.nextLine();
		System.out.print("회원의 이름를 입력하세요.");
		vo.setName(sc.next());
		sc.nextLine();
		System.out.print("회원의 주소를 입력하세요.");
		vo.setAddress(sc.nextLine());
		System.out.print("회원의 전화번호를 입력하세요.");
		vo.setTel(sc.next());
		sc.nextLine();
		System.out.print("회원의 나이를 입력하세요.");
		vo.setAge(sc.nextInt());
		sc.nextLine();

		int n = dao.memberInsert(vo);
		if (n != 0)
			System.out.println("입력을 성공하였습니다.");
		else
			System.out.println("입력을 실패하였습니다.");
		
	}// end of MI

	private void memberUpdate() { // 회원 수정
		MemberVO vo = new MemberVO();
		System.out.print("수정할 ID를 검색하세요.");
		vo.setId(sc.next());
		sc.nextLine();
		System.out.print("수정할 이름을 입력하세요.");
		vo.setName(sc.next());
		sc.nextLine();
		System.out.print("수정할 주소를 입력하세요.");
		vo.setAddress(sc.nextLine());
		System.out.print("수정할 전화번호를 입력하세요.");
		vo.setTel(sc.next());
		sc.nextLine();

		int n = dao.memberUpdate(vo);
		if (n != 0)
			System.out.println("수정을 성공하였습니다.");
		else
			System.out.println("수정을 실패하였습니다.");
		
	}// end of MU

	private void memberDelete() { // 멤버 삭제
		MemberVO vo = new MemberVO();
		System.out.print("삭제할 ID를 입력하세요.");
		vo.setId(sc.next());
		sc.nextLine();
		
		int n = dao.memberDelete(vo); // 삭제할 때는 id만 입력
		if (n != 0)
			System.out.println("삭제를 성공하였습니다.");
		else
			System.out.println("삭제를 실패하였습니다.");

	}// enf of MD

}
