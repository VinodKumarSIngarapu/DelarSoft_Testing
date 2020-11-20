package com.dataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelReader {
	private String homePageTabs="";
	private String scenario1="";
	private String scenario2="";
	private String negativeScenarioTab="";
	
	

	HSSFWorkbook workbook;
    HSSFSheet sheet;
    HSSFCell cell;
	
	public String getHomePageTabs() {
		return homePageTabs;
	}

	public void setHomePageTabs(String homePageTabs) {
		this.homePageTabs = homePageTabs;
	}

	public String getScenario1() {
		return scenario1;
	}

	public void setScenario1(String scenario1) {
		this.scenario1 = scenario1;
	}

	public String getScenario2() {
		return scenario2;
	}

	public void setScenario2(String scenario2) {
		this.scenario2 = scenario2;
	}
	
	public String getNegativeScenarioTab() {
		return negativeScenarioTab;
	}

	public void setNegativeScenarioTab(String negativeScenarioTab) {
		this.negativeScenarioTab = negativeScenarioTab;
	}
	
	public void ReadData() {
		try {
		File src=new File("C:\\Users\\Yashmit\\Interview-eclipse-workspace\\DelarSoft_Test\\TestData.xls");
	      
	     // Load the file.
	     FileInputStream finput = new FileInputStream(src);
	      
	     // Load he workbook.
	    workbook = new HSSFWorkbook(finput);
	      
	     // Load the sheet in which data is stored.
	     sheet= workbook.getSheetAt(0);
	      
	     for(int i=1; i<=sheet.getLastRowNum(); i++)
	     {
	         // Import data for Email.
	         cell = sheet.getRow(i).getCell(0);
	         cell.setCellType(Cell.CELL_TYPE_STRING);
	         setHomePageTabs(cell.getStringCellValue());
	          
	         // Import data for password.
	         cell = sheet.getRow(i).getCell(1);
	         cell.setCellType(Cell.CELL_TYPE_STRING);
	         setScenario1(cell.getStringCellValue());
	         
	         cell = sheet.getRow(i).getCell(2);
	         cell.setCellType(Cell.CELL_TYPE_STRING);
	         setScenario2(cell.getStringCellValue());
	         
	         cell = sheet.getRow(i).getCell(3);
	         cell.setCellType(Cell.CELL_TYPE_STRING);
	         setNegativeScenarioTab(cell.getStringCellValue());
	                 
	     }
	     
		}catch(FileNotFoundException fe) {
			fe.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
