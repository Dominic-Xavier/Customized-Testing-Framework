package com.excelSheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Baseclass.WebTestBase;
import com.testNgClass.BrowserDriver;

import net.bytebuddy.asm.Advice.This;

public class DataProviders extends WebTestBase{
	
	private static final String filePath = "./EnvConfig.xls";
	private static final String sheetName = "Configuration";
	private static FileInputStream inputStream;
	private static Workbook workbook;
	private static Sheet sheet;
	private static String[][] values; 
	private static final Map<String, String> map = new HashMap<>();
	private static boolean isgetDataExecuted = true;
	private static final Map<String, By> elementDatas = new HashMap<String, By>();
	//private static DataProviders dp;
	
	public DataProviders() {}
	
	/*public synchronized static DataProviders getInstance(WebDriver driver) {
		if(dp==null)
			dp = new DataProviders();
		drivers = driver;
		return dp;
	}*/
	
	private synchronized Map<String, String> getExcelSheet() throws IOException {
		inputStream = new FileInputStream(new File(filePath));
		workbook = new HSSFWorkbook(inputStream);
		sheet = workbook.getSheet(sheetName);
		String value = null;
		int totalcolumns = 2;
		int totalRows = sheet.getPhysicalNumberOfRows();
		System.out.println("Total No Of Rows "+totalRows);
		values = new String[totalRows][2];
		for (int i=1; i<totalRows; i++) {
			Row rows = sheet.getRow(i);
			//int totalcolumns = sheet.getRow(i).getPhysicalNumberOfCells();
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
		isgetDataExecuted = false;
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
	
	public synchronized String getData(String key) throws IOException {
		if(isgetDataExecuted)
			getExcelSheet();
		return map.get(key);
	}
	
	public static void element(String key, By by) {
		elementDatas.put(key, by);
	}
	
	public static WebElement element(String key) {
		By by = elementDatas.get(key);
		if(by==null) 
			throw new NoSuchElementException("Element "+key+" is not prenent");
		return driver.findElement(by);
	}
}


