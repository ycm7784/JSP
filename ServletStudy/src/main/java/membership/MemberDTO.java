package membership;

public class MemberDTO {
	//멤버 변수 선언
	private String id;
	private String pass;
	private String name;
	private String regldate;
	
	// 멤버 변수별 게터와 세터
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegldate() {
		return regldate;
	}
	public void setRegldate(String regldate) {
		this.regldate = regldate;
	}
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", regldate=" + regldate + "]";
	}

}
