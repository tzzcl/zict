package client;

import javax.swing.JOptionPane;

public class DealAnswer implements Runnable {
	String messageReceive = null;
	
	public DealAnswer(String message) {
		messageReceive = message;
	}
	
	// TODO: fill the message handler
	@Override
	public void run() {
		String[] context=messageReceive.split(" ");
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
				UserManage.setLogined(true);
				UserInfo.setName(UserManage.name);
				JOptionPane.showConfirmDialog(null, "Login Success!");
			}
			else{
				UserManage.setLogined(false);
				JOptionPane.showConfirmDialog(null, "Login Failed!");
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
			System.out.println(GetExplaination.explanation);
			System.out.println("Answered");
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
