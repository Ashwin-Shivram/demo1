package Excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class DAO {
	public void writeExcel(List<Book> listBook, String excelFilePath) throws IOException {
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet();

		int rowCount = 1;
		Row r = sheet.createRow(0);
		Cell c1 = r.createCell(1);
		c1.setCellValue("Title");
		c1 = r.createCell(2);
		c1.setCellValue("Author");
		c1 = r.createCell(3);
		c1.setCellValue("Cost");
		for (Book aBook : listBook) {
			Row row = sheet.createRow(rowCount++);
			
			writeBook(aBook, row);
		}

		try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
			workbook.write(outputStream);
		}
	}

	private void writeBook(Book aBook, Row row) {
		Cell cell = row.createCell(1);
		cell.setCellValue(aBook.getTitle());

		cell = row.createCell(2);
		cell.setCellValue(aBook.getAuthor());

		cell = row.createCell(3);
		cell.setCellValue(aBook.getPrice());
	}
	int i=1;
	Map<Integer, Book> entry = new HashMap<Integer,Book>();
	public void setEntryBook(Book b) {
		entry.put(i, b);
		i++;
	}
	public Map<Integer,Book> getEntryBook() {
		return entry;
	}
}
