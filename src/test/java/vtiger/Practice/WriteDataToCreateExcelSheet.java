package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToCreateExcelSheet {

	public static void main(String[] args) throws Throwable {
		// Step 1: Open the document in java Readable Format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		// Step 2: Create a WorkBook
		Workbook wb = WorkbookFactory.create(fis);
		
//		Step 3: Navigate to Sheet to Create a new one
		Sheet sh = wb.createSheet("Trial");
		
		int rowCount = 0;
//		Step 4: Navigate to row to Create a row
//		Row rw = sh.createRow(7);
		Row rw = sh.createRow(rowCount++);
		
//		Step 5: Create a cell
		Cell cl = rw.createCell(0);
		Cell cl1 = rw.createCell(1);
		Cell cl2 = rw.createCell(3);
		
		
//		Step 6: Provide data to be written
		cl1.setCellValue("SELENIUM");
		cl1.setCellValue("SQL");
		cl2.setCellValue("MYSQL");
	
		
//		Step 7: Open docx in java write format
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		
//		Step 8: Write the Data
		wb.write(fos);
		System.out.println("Data added Successfully");
		
//		step 9: close
		wb.close();

	}

}
