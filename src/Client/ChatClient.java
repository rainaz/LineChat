package Client;

import java.net.*;
import java.io.*;

import Message.Message;

public class ChatClient implements Runnable{
	private Socket socket = null;
	private Thread thread = null;
	private DataInputStream console = null;
	private DataOutputStream streamOut = null;
	private ChatClientThread client = null;
	private User user = null;

	public ChatClient(String serverName, int serverPort) {
		System.out.println("Establishing connection. Please wait ...");
		try {
			socket = new Socket(serverName, serverPort);
			System.out.println("Connected: " + socket);
			start();
		} catch (UnknownHostException uhe) {
			System.out.println("Host unknown: " + uhe.getMessage());
		} catch (IOException ioe) {
			System.out.println("Unexpected exception: " + ioe.getMessage());
		}
	}

	public void run() {
		while (thread != null) {
			try {
				streamOut.writeUTF(console.readLine());
				streamOut.flush();
			} catch (IOException ioe) {
				System.out.println("Sending error: " + ioe.getMessage());
				stop();
			}
		}
	}

	public void handle(String msg) {
		if (msg.equals(".bye")) {
			System.out.println("Good bye. Press RETURN to exit ...");
			stop();
		} if (msg.equals(".login")) {
			System.out.println("Login Success.");
		} if (msg.equals(".listGroup")) {
			System.out.print("Your group list : ");
		} if (msg.equals(".enterGroup")) {
			System.out.print("Enter group : ");
		} if (msg.equals(".exitGroup")) {
			System.out.print("Exit group : ");
		} if (msg.equals(".createGroup")) {
			System.out.print("Create group success.");
		} if (msg.equals(".leaveGroup")) {
			System.out.print("Leave group : ");
		} else
			System.out.println(msg);
	}

	public void start() throws IOException {
		console = new DataInputStream(System.in);
		streamOut = new DataOutputStream(socket.getOutputStream());
		if (thread == null) {
			client = new ChatClientThread(this, socket);
			thread = new Thread(this);
			thread.start();
		}
	}

	public void stop() {
		if (thread != null) {
			thread.stop();
			thread = null;
		}
		try {
			if (console != null)
				console.close();
			if (streamOut != null)
				streamOut.close();
			if (socket != null)
				socket.close();
		} catch (IOException ioe) {
			System.out.println("Error closing ...");
		}
		client.close();
		client.stop();
	}

	public static void main(String args[]) {
		ChatClient client = null;
//		if (args.length != 2)
//			System.out.println("Usage: java ChatClient host port");
//		else
//			client = new ChatClient(args[0], Integer.parseInt(args[1]));
		client = new ChatClient("161.200.212.192", Integer.parseInt("5555"));
//		++++
	}
}