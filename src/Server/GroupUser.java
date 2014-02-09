package Server;

import java.util.ArrayList;
import java.util.Vector;

import Message.Message;

public class GroupUser {
	private String groupID;
	private ArrayList<UserInfo> userInfos;
	private ArrayList<Message> messages;
	private int totalUser;
	private int lastStoreMsgNo;

	public void GroupUser(String gID) {
		groupID = gID;
	}

	public void joinGroup(String uID) {
		UserInfo user1 = new UserInfo(uID);
		userInfos.add(user1);
	}

	public void leaveGroup(String uID) {
		userInfos.remove(new UserInfo(uID));
	}

	public void enterGroup(String uID) {
		UserInfo user = userInfos.get(userInfos.indexOf(new UserInfo(uID)));
		user.setOnline(true);
	}

	public void exitGroup(String uID) {
		UserInfo user = userInfos.get(userInfos.indexOf(new UserInfo(uID)));
		user.setOnline(false);
	}
}
