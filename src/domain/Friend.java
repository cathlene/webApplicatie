package domain;

public class Friend {
	
	private String nickName;
	private String status;
	private String password;


	public Friend(){
		
	}
	
	public Friend(String nickName, String status) {
		this.nickName = nickName;
		this.status = status;

	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		if(nickName==null || nickName.isEmpty()){
			throw new IllegalArgumentException();
		}
		this.nickName = nickName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		if(status==null || status.isEmpty()){
			throw new IllegalArgumentException();
		}
		this.status = status;
	}
	
	

}
