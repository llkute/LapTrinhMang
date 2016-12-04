package BEAN;

public class Member {
	private int memberid;
	private String membername;
	private String memberpass;
	private int categorymemberid;
	private String memberdiem;
	public String getMemberdiem() {
		return memberdiem;
	}

	public void setMemberdiem(String memberdiem) {
		this.memberdiem = memberdiem;
	}

	public Member() {
		super();
	}
	
	
	
	public Member(int memberid, String membername, String memberpass, int categorymemberid, String memberdiem) {
		super();
		this.memberid = memberid;
		this.membername = membername;
		this.memberpass = memberpass;
		this.categorymemberid = categorymemberid;
		this.memberdiem = memberdiem;
	}

	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getMemberpass() {
		return memberpass;
	}
	public void setMemberpass(String memberpass) {
		this.memberpass = memberpass;
	}
	public int getCategorymemberid() {
		return categorymemberid;
	}
	public void setCategorymemberid(int categorymemberid) {
		this.categorymemberid = categorymemberid;
	}
	
}
