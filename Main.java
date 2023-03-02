package exercise05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Browser {

	static ArrayList<String> bookmarksList = new ArrayList<>();

	public static ArrayList<String> getBookmarksList() {
		return bookmarksList;
	}

	public static void setBookmarksList(ArrayList<String> bookmarksList) {
		Browser.bookmarksList = bookmarksList;
	}

	class Bookmarks {
		void addBookmark(String url) {
			bookmarksList.add(url);
		}
	}

	static class History {
		void displayHistory() {
			System.out.println("Displaying history : ");
			for (String url : bookmarksList) {
				System.out.println(url);
			}
		}
	}

}

interface shortcutsInterface {
	public void addShortcut();

	public void displayShortcut();
}

public class Main {
	public static void main(String[] args) {

		String ch;

		Browser browser = new Browser();
		Browser.Bookmarks bookmark = browser.new Bookmarks();

		do {
			System.out.println("Enter url");
			Scanner sc = new Scanner(System.in);
			String url = sc.nextLine();

			bookmark.addBookmark(url);

			System.out.println("Do you wish to continue? (Yes/No)");
			ch = sc.nextLine();
		} while (ch.equalsIgnoreCase("yes"));

		HashMap<String, String> shortcutMap = new HashMap<>();

		shortcutsInterface shortcuts = new shortcutsInterface() {
			public void addShortcut() {
				ArrayList<String> bookmarksList = Browser.getBookmarksList();
				for (String obj : bookmarksList) {
					System.out.println("Enter shortcut for " + obj);
					Scanner sc1 = new Scanner(System.in);
					String shortcut = sc1.nextLine();
					shortcutMap.put(shortcut, obj);
				}
			}

			public void displayShortcut() {
				for (Map.Entry<String, String> entry : shortcutMap.entrySet()) {
					System.out.println(entry.getKey() + ": " + entry.getValue());
				}

			}
		};

		shortcuts.addShortcut();
		shortcuts.displayShortcut();

		Browser.History history = new Browser.History();
		history.displayHistory();
	}
}
