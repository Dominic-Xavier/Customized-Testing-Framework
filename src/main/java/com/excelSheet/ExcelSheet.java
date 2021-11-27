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
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet {
	
	private static ExcelSheet excelSheet = null;
	
	private static final String filePath = "./EnvConfig.xls";
	private static final String sheetName = "Config";
	private static FileInputStream inputStream;
	private static Workbook workbook;
	private static Sheet sheet;
	private static String[][] values; 
	private static Map<String, String> map = new HashMap<>();
	private static int count = 0;
	
	private ExcelSheet() {
		
	}
	
	public synchronized static ExcelSheet getExcelSheet() {
		if(excelSheet==null) {
			excelSheet = new ExcelSheet();
		}
		return excelSheet;
	}
	
	private Map<String, String> getData() throws IOException {
		
		inputStream = new FileInputStream(new File(filePath));
		workbook = new HSSFWorkbook(inputStream);
		sheet = workbook.getSheet(sheetName);
		String value = null;
		int totalRows = sheet.getPhysicalNumberOfRows();
		values = new String[totalRows][2];
		for (int i=1; i<totalRows; i++) {
			Row rows = sheet.getRow(i);
			int totalcolumns = sheet.getRow(i).getPhysicalNumberOfCells();
			for(int j=0;j<totalcolumns;j++) {
				Cell cell = rows.getCell(j);
				switch (cell.getCellType()) {
				case NUMERIC:
					int numericCellValue = (int)cell.getNumericCellValue();
					value = String.valueOf(numericCellValue);
					values[i][j] = value;
				break;
				
				case STRING:
					value = cell.getStringCellValue();
					values[i][j] = value;
				break;
 				
				case BOOLEAN:
					value = String.valueOf(cell.getBooleanCellValue());
					values[i][j] = value;
				break;
				}
			}
		}
		Map<String, String> getvalueAsMap = getvalueAsMap(values);
		count++;
		return getvalueAsMap;
	}
	
	private static Map<String, String> getvalueAsMap(String[][] list ) {
		
	    for (String[] m : list) {
	      if (map.put(m[0], m[1]) != null) {
	        throw new IllegalStateException("Duplicate key");
	      }
	    }
	    return map;
	}
	
	public String getData(String key) throws IOException {
		if(count==0)
			getExcelSheet().getData();
		return map.get(key);
	}
}


