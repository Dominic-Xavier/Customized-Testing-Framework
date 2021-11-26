package com.excelSheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelSheet {
	
	private String filePath = "./TestData.xls";
	private String sheetName = "TestScenario";
	private FileInputStream inputStream;
	private Workbook workbook;
	private Sheet sheet;
	private Map<String, Object> map = new HashMap();
	private int totalNoOfRows = 600000;
	
	public String getData(int row) throws IOException {
		inputStream = new FileInputStream(new File(filePath));
		workbook = new HSSFWorkbook(inputStream);
		sheet = workbook.getSheet(sheetName);
		String value = null;
		for (int i = 1; i<row; i++) {
			Row rows = sheet.getRow(i);
			for(int j=0;j<sheet.getRow(i).getPhysicalNumberOfCells();j++) {
				Cell cell = rows.getCell(j);
				switch (cell.getCellType()) {
				case NUMERIC:
					int numericCellValue = (int)cell.getNumericCellValue();
					value = String.valueOf(numericCellValue);
				break;
				
				case STRING:
					value = cell.getStringCellValue();
				break;
 				
				case BOOLEAN:
					value = String.valueOf(cell.getBooleanCellValue());
				break;
				}
			}
		}
		return value;
	}
	
	public int findRow(String testcaseName) throws IOException {
		int emptyRow = 0;
		for(int row=0; row<totalNoOfRows; row++) {
			String data = getData(row);
			if(data.isBlank() || data.isEmpty() || data==null)
				emptyRow++;
			else
				emptyRow = 0;
			if(emptyRow==15)
				break;
			if(!data.equals(testcaseName))
				continue;
			return row;
		}
		return -1;
	}
}
