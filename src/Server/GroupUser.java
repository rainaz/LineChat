package Server;

import java.util.ArrayList;
import java.util.Vector;

import Message.Message;

public class GroupUser {
	private String groupID;
	private Vector<UserInfo> userInfos;
	private ArrayList<Message> messages;
	private int totalUser;
	private int lastMessageNumber;
}
