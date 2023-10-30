package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains reusable methods related to excel file
 * @author bhumi
 *
 */

public class ExcelFileUtility {

	/**
	 * This method will read data into Excel Sheet and return the value to caller
	 * @param Sheet
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @throws Throwable
	 */
	public String readDataFromExcel(String SheetName, int rowNum, int cellNum) throws Throwable{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(SheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	/**
	 * This method will write data into Excel Sheet
	 * @param Sheet
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @throws Throwable
	 */
	
	public void writeDataIntoExcel(String SheetName, int rowNum, int cellNum, String value) throws Throwable{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.createSheet(SheetName).createRow(rowNum).createCell(cellNum).setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		wb.close();
	}
	
	
	
	/**
	 * This method will read multiple data from excel sheet 
	 * at time used for data provider
	 * @param SheetName
	 * @return 
	 * @throws Throwable
	 */
	
	public Object[][] readMultipleDataFromExcel(String SheetName) throws Throwable{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		for(int i= 0; i < lastRow; i++) {
			for(int j = 0; j < lastCell; j++) {
				data[i][j] = sh.getRow(i + 1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
