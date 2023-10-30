package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelSheet {

	public static void main(String[] args) throws Throwable {
		// Step 1: Open the document in java Readable Format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		// Step 2: Create a WorkBook
		Workbook wb = WorkbookFactory.create(fis);
		
//		Step 3: Navigate to Sheet
		Sheet sh = wb.getSheet("Contacts");
		
//		Step 4: Navigate to row
		Row rw = sh.getRow(4);
		
//		Step 5: Create a cell
		Cell cl = rw.createCell(5);
		
//		Step 6: Provide data to be written
		cl.setCellValue("SELENIUM");
		
//		Step 7: Open docx in java write format
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		
//		Step 8: Write the Data
		wb.write(fos);
		System.out.println("Data added Successfully");
		
//		step 9: close
		wb.close();

	}

}
