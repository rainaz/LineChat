package Client;

import java.util.ArrayList;

public class User {
	private String userID;
	private ArrayList<String> groups;
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public User(String userID) {
		super();
		this.userID = userID;
		this.groups = new ArrayList<>();
	}

	
}
