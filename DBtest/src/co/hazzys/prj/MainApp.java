package co.hazzys.prj;

import co.hazzys.prj.app.Menu;

public class MainApp {
	public static void main(String[] args) {
		// db 연결
	//		MemberService dao = new MemberServiceImpl(); // db연결을 위한 객체를 초기화 (dao에 memberserviceimpl 담기)
	//		List<MemberVO> list = new ArrayList<MemberVO>(); // dao 객체로부터 넘어온 리스트 담기
//
//		// 전체리스트 가져오기
	//		list = dao.memberSelectList(); // 객체 만든 후에 memberselectlist 받음.
	//		MemberVO vo = new MemberVO();
//
//		// 정보 조회(검색)
	//		vo.setId("hazzys");
	//		vo = dao.memberSelect(vo);
//
//		// 정보 입력
////	vo.setId("hazzys");
////	vo.setPassword("4321");
////	vo.setName("오혜지");
////	vo.setAddress("대구광역시 동구");
////	vo.setTel("010-8888-8888");
////	vo.setAge(26);
//
////	int n = dao.memberInsert(vo);
////	if(n != 0) 
////		System.out.println("입력을 성공하였습니다.");
////	else
////		System.out.println("입력을 실패하였습니다.");
//
//		// 정보 삭제
////		vo.setId("hazzys");
////
////		int n = dao.memberDelete(vo); // 삭제할 때는 id만 입력
////		if (n != 0)
////			System.out.println("삭제를 성공하였습니다.");
////		else
////			System.out.println("삭제를 실패하였습니다.");
//
//		// 정보 수정
//		vo.setId("park2");
//		vo.setName("박승리");
//		vo.setAddress("대구광역시 동구");
//		vo.setTel("010-8888-8888");
//
//		int n = dao.memberUpdate(vo);
//		if (n != 0)
//			System.out.println("수정을 성공하였습니다.");
//		else
//			System.out.println("수정을 실패하였습니다.");
//
//		// 출력
////		for (MemberVO vo : list) {
////			System.out.print(vo.getId() +"|");
////			System.out.print(vo.getPassword()+"|");
////			System.out.print(vo.getName()+"|");
////			System.out.print(vo.getAddress()+"|");
////			System.out.print(vo.getTel()+"|");
////			System.out.println(vo.getAge());
////			}
//
////		System.out.println(vo.toString());
		
		
		Menu menu = new Menu();
		menu.run();
		
	}
}