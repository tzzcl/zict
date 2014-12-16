package logic;

import javax.swing.JOptionPane;

import network.Network;
import data.Explanation;
import data.UserInfo;
import data.WordEntry;

public class ServiceProvider {
	static String explanation = null;
	
	public static void clickLike(String word, String source) {
		if (!UserInfo.isLogged()) {
			JOptionPane.showConfirmDialog(null, "Please Login First!");
			return;
		}
		String message = "Like" + " " + UserInfo.getName() + " " + word + " " + source;
		Network.sendToServer(message);
	}
	
	public static void cancelLike(String word, String source) {
		if (!UserInfo.isLogged()) {
			JOptionPane.showConfirmDialog(null, "Please Login First!");
			return;
		}
		String message = "Cancel" + " " + UserInfo.getName() + " " + word + " " + source;
		Network.sendToServer(message);
	}
	
	public static void shareWordCard(String toUser,int rating){
		String message = "Share" + " " + toUser + " ###" + WordEntry.getWord() + "###" + WordEntry.getExplanation(rating).getExplanation();
		Network.sendToServer(message);;
	}
	
	public static void getExplanation(String word) {
		explanation = null;
		WordEntry.setWord(word);
		String message = "Query" + " " + word;
		Network.sendToServer(message);
		while (explanation == null){
			System.out.print("");
		}
		String[] result = explanation.split("###");
		for (int i = 0; i < 3; i ++) {
			if (result[i].startsWith("baidu")) {
				String[] exp = result[i].substring(6).split(";likenumber:");
				WordEntry.setExplanation(i, new Explanation("baidu", exp[0], Integer.parseInt(exp[1])));
			}
			else if (result[i].startsWith("bing")) {
				String[] exp = result[i].substring(5).split(";likenumber:");
				WordEntry.setExplanation(i, new Explanation("bing", exp[0], Integer.parseInt(exp[1])));
			}
			else {
				String[] exp = result[i].substring(7).split(";likenumber:");
				WordEntry.setExplanation(i, new Explanation("youdao", exp[0], Integer.parseInt(exp[1])));
			}
		}
		return;
	}
}
