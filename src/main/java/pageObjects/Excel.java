package pageObjects;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static String getDataInput() throws IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		XSSFRow row;
		XSSFCell cell;
		String inputData = "";
		for (int i = 0; i < 5; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0);
			inputData += cell.getStringCellValue() + "\n";
		}
		workBook.close();
		return inputData.trim();
	}

	public static String getDataOutput() throws IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		XSSFRow row;
		XSSFCell cell;
		String outputData = "";
		for (int i = 0; i < 5; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(1);
			outputData += cell.getStringCellValue() + "\n";
		}
		workBook.close();
		return outputData.trim();
	}

	public static void setDataFail() throws IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/TestReport.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		XSSFRow row;
		XSSFCell cell;
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		row = sheet.getRow(0);
		XSSFRow newRow = sheet.createRow(rowCount + 1);
		for (int j = 0; j < row.getLastCellNum(); j++) {

			// Fill data in row

			cell = newRow.createCell(j);

			cell.setCellValue("Pass");

		}
		fis.close();
		FileOutputStream outputStream = new FileOutputStream("./src/test/resources/TestReport.xlsx");

	    //write data in the excel file

	    workBook.write(outputStream);

	    //close output stream

	    outputStream.close();
		
	    }
	public static void setDataPass() throws IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/TestReport.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		XSSFRow row;
		XSSFCell cell;
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		row = sheet.getRow(0);
		XSSFRow newRow = sheet.createRow(rowCount + 1);
		for (int j = 0; j < row.getLastCellNum(); j++) {

			// Fill data in row

			cell = newRow.createCell(j);

			cell.setCellValue("Pass");

		}
		fis.close();
		FileOutputStream outputStream = new FileOutputStream("./src/test/resources/TestReport.xlsx");

	    //write data in the excel file

	    workBook.write(outputStream);

	    //close output stream

	    outputStream.close();
		
	    }

		

	}


