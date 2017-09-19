package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelUtility {
	
	private static FileInputStream excelFileRead;
	private static FileOutputStream excelFilewrite;
	private static HSSFWorkbook excelWBook;
	private static HSSFSheet excelWSheet;
	private static Cell cell;
	static String excelFile = System.getProperty("user.dir")
			+ "\\HexadecimalValueConvert.xls";

	public static String readCellData(int rowNum, int ColNum, String sheetName) throws Exception {
		excelFileRead = new FileInputStream(excelFile);
		excelWBook = new HSSFWorkbook(excelFileRead);
		excelWSheet = excelWBook.getSheet(sheetName);
		try {
			cell = excelWSheet.getRow(rowNum).getCell(ColNum);
			String cellData = cell.getStringCellValue();
			excelFileRead.close();
			return cellData;
		} catch (Exception e) {
			excelFileRead.close();
			return "";
		}
	}

	// This method is to get the row count used of the excel sheet
	public static int getRowCount(String sheetName) throws Exception {
		excelFileRead = new FileInputStream(excelFile);
		excelWBook = new HSSFWorkbook(excelFileRead);
		excelWSheet = excelWBook.getSheet(sheetName);
		int rowCount = excelWSheet.getLastRowNum();
		excelFileRead.close();
		return rowCount;
	}

	public static void writeData(int row, int col, String sheetName, String data) throws Exception {
		excelFileRead = new FileInputStream(excelFile);
		excelWBook = new HSSFWorkbook(excelFileRead);
		excelWSheet = excelWBook.getSheet(sheetName);
		cell = null;
		cell = excelWSheet.getRow(row).getCell(col);
		cell.setCellValue(data);
		excelFileRead.close();
		excelFilewrite = new FileOutputStream(excelFile);
		excelWBook.write(excelFilewrite);
		excelFilewrite.close();
	}
}
