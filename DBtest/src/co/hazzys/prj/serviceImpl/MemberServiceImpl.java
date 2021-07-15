package co.hazzys.prj.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.hazzys.prj.DAO;
import co.hazzys.prj.service.MemberService;
import co.hazzys.prj.vo.MemberVO;

public class MemberServiceImpl extends DAO implements MemberService {
	private PreparedStatement psmt; // sql명령을 보내고 실행하기 위한 객체
	private ResultSet rs; // select 결과를 받을 수 있는 객체

	@Override
	public List<MemberVO> memberSelectList() {
		// 전체리스트 가져오기
		List<MemberVO> members = new ArrayList<MemberVO>(); // MemberVO타입의 List 모습을 배열처럼 쓰겠다.
		MemberVO vo;
		String sql = "select * from member";
		try {
			psmt = conn.prepareStatement(sql); // psmt 객체 초기화
			rs = psmt.executeQuery(); // select 일때만 executeQuery(), 다른 경우는 excuteUpdate();
			while (rs.next()) { // 한 행씩 데이터 읽기, 행의 데이터가 없을 때 -1(purse)을 리턴해주고 빠져나옴
				vo = new MemberVO(); // 초기화
				vo.setId(rs.getString("id")); // vo에 rs의 String타입 id를 setId로 받음
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setAge(rs.getInt("age"));
				members.add(vo); // 리스트 추가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;
	}// end of MSL

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// 데이터 조회(검색)
		String sql = "select * from member where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setId(rs.getString("id")); // rs에 String타입 id를 setId에 입력
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setAge(rs.getInt("age"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}// end of MS

	@Override
	public int memberInsert(MemberVO vo) {
		// 데이터 삽입
		int n = 0;
		String sql = "insert into member values(?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId()); // psmt에 첫번째 인자에 String 타입 getId를 반환
			psmt.setString(2, vo.getPassword());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getAddress());
			psmt.setString(5, vo.getTel());
			psmt.setInt(6, vo.getAge());
			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;// n 초기값 0으로 두고 n을 반환
	}// end of MI

	@Override
	public int memberUpdate(MemberVO vo) {
		// 데이터 수정
		int n = 0;
		String sql = "update member set address = ?, tel = ?,name = ? where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getAddress()); //
			psmt.setString(2, vo.getTel());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}// end of MU

	@Override
	public int memberDelete(MemberVO vo) {
		// 데이터 삭제
		int n = 0;
		String sql = "delete from member where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}// end of MD
}// end of class
