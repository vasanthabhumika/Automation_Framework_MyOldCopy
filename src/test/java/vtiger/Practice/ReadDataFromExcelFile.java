package vtiger.Practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws Throwable {
		//Step 1: Open the document in java Readable format
		  FileInputStream fis  = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		  
//		  Step 2: Create a workBook
		  Workbook wb = WorkbookFactory.create(fis);
		  
//		  Step 3: Navigate to required Sheet
		  Sheet sh = wb.getSheet("Organizations");
		  
//		  Step 4: Navigate to required row
		  Row rw = sh.getRow(6);
		  
//		  Step 5: Navigate to required Cell
		  Cell cl = rw.getCell(3);
		  
//		  Step 6: Read the data inside the cell
		  String data = cl.getStringCellValue();
		  System.out.println(data);
		  
//		  Step 7: Close the workbook
		  wb.close();

//		  close() - avoid memory leakage..
	}

}
