package com_kustom.genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	public String readpropertyData(String propertypath,String key) throws Throwable {
		FileInputStream fis=new FileInputStream(propertypath);
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key,"Incorrect key");
		
	}
	public String readExcelData(String excelpath,String sheet,int row,int cell) throws Throwable {
		FileInputStream fis =new FileInputStream("excelpath");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		Row r=sh.getRow(row);
		Cell ce=r.getCell(cell);
		String val=ce.toString();
		return val;
		
		
	}
	public void writeExcelData(String excelpath,String sheet,int row, int cell,String data) throws Throwable {
		FileInputStream fis =new FileInputStream("excelpath");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		Row r=sh.getRow(row);
		Cell ce=r.createCell(cell);
		ce.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(excelpath);
		wb.write(fos);
	}

}
