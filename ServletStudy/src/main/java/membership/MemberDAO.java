package membership;

import common.JDBCConnect;

public class MemberDAO extends JDBCConnect{
	//명시한 데이터베이스로의 연결이 완료된 MemberDAO 객체를 생성합니다
	public MemberDAO(String drv, String url, String id, String pw) {
		super(drv,url,id,pw);
	}
	//명시한 아이디/패스워드와 일치하는 회원정보를 반환합니다
	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO();
		String query = "SELECT * FROM member WHERE id = ? AND pass=?";
		
		try {
			//쿼리 실행
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs = psmt.executeQuery();
			
			// 결과 처리
			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegldate(rs.getString(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
