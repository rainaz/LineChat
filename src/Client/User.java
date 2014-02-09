package Client;

public class User {
	private String userID;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public User(String userID) {
		super();
		this.userID = userID;
	}
	
}
