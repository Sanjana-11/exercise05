package exercise05;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Browser {

	ArrayList<String> bookmarksList = new ArrayList<>();
	static List<String> urlList = new ArrayList<>();
	LinkedHashMap<String, String> shortcutsMap = new LinkedHashMap<>();

	public List<String> getUrlList() {
		return urlList;
	}

	class Bookmarks {
		void addBookmark(String url) {
			bookmarksList.add(url);
		}

		void displayBookmark() {
			System.out.println("Displaying bookmarked urls : ");
			for (String url : bookmarksList) {
				System.out.println(url);
			}
		}
	}

	ShortcutsInterface shortcuts = new ShortcutsInterface() {
		public void addShortcut() {
			for (String url : urlList) {
				System.out.println("Enter shortcut for " + url);
				Scanner sc1 = new Scanner(System.in);
				String shortcut = sc1.nextLine();
				shortcutsMap.put(shortcut, url);
			}
		}

		public void displayShortcut() {
			System.out.println("Displaying shortcuts : ");
			for (Map.Entry<String, String> entry : shortcutsMap.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}

		}
	};

	static class History {
		void addUrl(String url) {
			urlList.add(url);
		}

		void displayHistory() {
			System.out.println("Displaying url history : ");
			for (String url : urlList) {
				System.out.println(url);
			}
		}
	}

}

interface ShortcutsInterface {
	public void addShortcut();

	public void displayShortcut();
}

public class Main {
	public static void main(String[] args) {

		String ch;

		Browser browser = new Browser();
		Browser.Bookmarks bookmark = browser.new Bookmarks();

		Browser.History history = new Browser.History();

		do {
			System.out.println("Enter url");
			Scanner sc = new Scanner(System.in);
			String url = sc.nextLine();
			history.addUrl(url);
			System.out.println("Bookmark url (Yes/No)");
			String bookmarkUrl = sc.nextLine();
			if (bookmarkUrl.equalsIgnoreCase("yes")) {
				bookmark.addBookmark(url);
			}
			System.out.println("Do you wish to continue? (Yes/No)");
			ch = sc.nextLine();
		} while (ch.equalsIgnoreCase("yes"));
		bookmark.displayBookmark();

		browser.shortcuts.addShortcut();
		browser.shortcuts.displayShortcut();

		history.displayHistory();
	}
}
