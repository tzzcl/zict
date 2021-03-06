package logic;

import android.annotation.SuppressLint;
import android.widget.Toast;
import com.example.dictionaryandroid.MainActivity;
import network.Network;
import data.Explanation;
import data.UserInfo;
import data.WordEntry;

public class ServiceProvider {
	@SuppressLint("ShowToast")
	public static void clickLike(String word, String source) {
		if (!UserInfo.isLogged()) {
			Toast.makeText(MainActivity.getContext(),"Please Login First!",Toast.LENGTH_LONG);
			return;
		}
		String message = "Like" + " " + UserInfo.getName() + " " + word + " " + source;
		Network.sendToServer(message);
	}
	
	@SuppressLint("ShowToast")
	public static void cancelLike(String word, String source) {
		if (!UserInfo.isLogged()) {
			Toast.makeText(MainActivity.getContext(),"Please Login First!",Toast.LENGTH_LONG);
			return;
		}
		String message = "Cancel" + " " + UserInfo.getName() + " " + word + " " + source;
		Network.sendToServer(message);
	}
	
	public static void getUserList() {
		Network.sendToServer("User");
	}
	
	public static void getLikedList() {
		String message = "Word" + " " + UserInfo.getName();
		Network.sendToServer(message);
	}
	
	public static void shareWordCard(String toUser,int rating){
		String message = "Share" + " " + toUser + " ###" + WordEntry.getWord() + "###" + WordEntry.getExplanation(rating).getExplanation();
		System.out.println(message);
		Network.sendToServer(message);
	}
	
	public static void getExplanation(String word) {
		WordEntry.setWord(word);
		String queryName = null;
		if (UserInfo.isLogged()) {
			queryName = UserInfo.getName();
		}
		else {
			queryName = "_NULL_";
		}
		String message = "Query" + " " + queryName + " " + word;
		Network.sendToServer(message);
		return;
	}
}
