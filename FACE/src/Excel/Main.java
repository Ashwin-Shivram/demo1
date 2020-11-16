package Excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		DAO excelWriter = new DAO();
		System.out.println("Enter the number of books to be inserted:");
		int size = Integer.parseInt(sc.nextLine());
		Book obj = null;
		Map<Integer,Book> map = new HashMap<Integer,Book>();
		for(int i=0;i<size;i++) {
			System.out.println("Enter Title of Book "+(i+1));
			String title = sc.nextLine();
			System.out.println("Enter Author of Book "+(i+1));
			String author = sc.nextLine();
			System.out.println("Enter the cost of Book "+(i+1));
			float cost = Float.parseFloat(sc.nextLine());
			obj = new Book(title, author, cost);
			excelWriter.setEntryBook(obj);
		}
		map = excelWriter.getEntryBook();
		System.out.println(map);
		String excelFilePath = "NiceJavaBooks.xls";
		List<Book> list = new ArrayList<Book>();
		for(Map.Entry<Integer, Book> e : map.entrySet()) {
			Book b = e.getValue();
			list.add(b);
		}
		System.out.println(list);
		excelWriter.writeExcel(list, excelFilePath);
		sc.close();
	}

}
