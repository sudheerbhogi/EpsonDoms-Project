package com.EpsonDoms.Excelfilelibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.EpsonDoms.Genericlibrary.Frameworkconstant;
/**
 * This Class Provides the Reusable Method To Perform ExcelFile 
 * 
 * 
 *@author sande
 */
public class ReadExcelFile implements Frameworkconstant {

	public  FileInputStream fis = null;
	public  Workbook wb = null;
	public  FileOutputStream fos = null;

	public  String readSingleData(String sheetname, int row, int cell) {
		// 1. Convert the physical file into java Readable File
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 2. Create The Workbook Using WorkbookFactory
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 3. Using Workbook Get The Sheet Control
		// 4. Using Sheet Get the Row Control
		// 5. Using Row Get the Column Control
		// 6. Using Column Get the Cell-data
		String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return data;

	}

	public void readMultipleData(String sheetname) {

		// 1. Convert the physical file into java Readable File
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 2. Create The Workbook Using WorkbookFactory
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 3. Using Workbook Get The Sheet Control
		// 4. Using Sheet Get the Row Control
		// 5. Using Row Get the Column Control
		// 6. Using Column Get the Cell-data
		int rowcount = wb.getSheet(sheetname).getLastRowNum();
		for (int i = 0; i < rowcount; i++) {
			String data = wb.getSheet(sheetname).getRow(i).getCell(1).getStringCellValue();
		}

	}

	public  void writeData(String sheetname, int row, int cell, String data) {
		// 1. Convert the physical file into java Readable File
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 2. Create The Workbook Using WorkbookFactory
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 3. Using Workbook Get The Sheet Control
		// 4. Using Sheet Get the Row Control
		// 5. Using Row create the column
		// 6. Using the Column set the Cell-data

		wb.getSheet(sheetname).getRow(row).createCell(cell).setCellValue("data we will pass");

		// 7. convert java readable file into physical file
		try {
			fos = new FileOutputStream(excelpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 8. Write the data
		try {
			wb.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 9. Close the workbook
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}