package logic;

import javax.swing.JOptionPane;

import data.UserInfo;

public class DealAnswer implements Runnable {
	String messageReceive = null;
	
	public DealAnswer(String message) {
		messageReceive = message;
	}
	
	// TODO: fill the message handler
	@Override
	public void run() {
		String[] context = messageReceive.split(" ");
		if (context[0].equals("Register")){
			if (context[1].equals("Success!")){
				JOptionPane.showConfirmDialog(null, "Register Success!");
			}
			else{
				JOptionPane.showConfirmDialog(null, "Register Failed!");
			}
		}
		else if (context[0].equals("Login")){
			if (context[1].equals("Success!")){
				UserInfo.setLoginStatus(true);
				JOptionPane.showConfirmDialog(null, "Login Success!");
			}
			else{
				JOptionPane.showConfirmDialog(null, "Login Failed!");
			}
		}
		else if (context[0].equals("Logout")) {
			if (context[1].equals("Success!")) {
				UserInfo.setLoginStatus(false);
				JOptionPane.showConfirmDialog(null, "Logout Success!");
			}
			else {
				JOptionPane.showConfirmDialog(null, "Logout Failed!");
			}
		}
		// Maybe Like doesn't need to echo --> will be deleted eventually
		else if (context[0].equals("Like")){
			if (context[1].equals("Success!")){
				JOptionPane.showConfirmDialog(null, "Like Success!");
			}
			else{
				JOptionPane.showConfirmDialog(null, "Like Failed!");
			}
		}
		else if (context[0].equals("Cancel")){
			if (context[1].equals("Success!")){
				JOptionPane.showConfirmDialog(null, "Cancel Success!");
			}
			else{
			}
		}
		else if (context[0].equals("Answer")) {
			GetExplaination.setExplanation(new String(messageReceive.substring(7)));
		}
		else if (context[0].equals("share")) {
			//Show Share 
		}
		else if (context.equals("No such words!")){
			JOptionPane.showConfirmDialog(null, "No such words!");
		}
		else{
			//Set Explaination
		}
	}

}