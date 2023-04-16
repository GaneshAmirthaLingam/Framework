package org.dataDrivenFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataUtils {

	@DataProvider(name = "pro")
	private static String[][] getExcelData() throws IOException {
		File f = new File("C:\\Users\\ADMIN\\eclipse-workspace\\Framework\\Excel\\Data.xlsx");
		FileInputStream stream = new FileInputStream(f);
		XSSFWorkbook w = new XSSFWorkbook(stream);
		XSSFSheet sheet = w.getSheet("test");
		int lastRowNum = sheet.getLastRowNum();
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[lastRowNum][lastCellNum];
		for (int i = 1; i < lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter format = new DataFormatter();
				String value = format.formatCellValue(cell);
				data[i - 1][j] = value;

			}

		}
		w.close();
		return data;

	}

}
