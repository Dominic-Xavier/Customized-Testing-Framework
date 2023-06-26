package com.excelSheet;

public enum Parameter {
	
	CONFIG_FILE_NAME("./EnvConfig.xls"),
	CONFIG_SHEET_NAME("Configuration"),
	DATABASE_FILE_NAME("./dataFactory.xls"),
	DATABASE_SHEET__NAME("Query"),
	TEST_DATA_FILE_NAME("./TestData.xlsx"),
	TEST_DATA_SHEET_NAME("Data"),
	REG_DATA_SHEET_NAME("RegData");
	
	private final String key;
	
	Parameter(String key){
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}
}
