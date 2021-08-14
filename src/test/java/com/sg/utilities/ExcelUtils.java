package com.sg.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
		public static Object[][] getSheetToObjectArray(String fileDetail, String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(fileDetail); // location

		XSSFWorkbook book = new XSSFWorkbook(file); // open

		XSSFSheet sheet = book.getSheet(sheetName); // sheet

		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(1).getPhysicalNumberOfCells();

		Object[][] main = new Object[rowCount - 1][cellCount];

		DataFormatter format = new DataFormatter();

		for (int r = 1; r < rowCount; r++) {
			for (int c = 0; c < cellCount; c++) {
				XSSFRow row = sheet.getRow(r);
				XSSFCell cell = row.getCell(c);
				main[r - 1][c] = format.formatCellValue(cell);
			}
		}
		return main;
	}
		
}
