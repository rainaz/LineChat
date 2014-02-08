package Server;

import java.util.ArrayList;
import java.util.Vector;

import Message.Message;

public class GroupUser {
	private String groupID;
	private Vector<UserInfo> userInfos;
	private ArrayList<Message> messages;
	private int totalUser;
	private int lastStoreMsgNo;
	
	public GroupUser(String gID, String uID){
		groupID = gID;
		UserInfo user1 = new UserInfo(uID);
		userInfos.add(user1);
		
	}
	
}
