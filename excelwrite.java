package AutoTrial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelwrite {
	
	//constructor
	public excelwrite() {
		
	}
	
	XSSFRow row = null;
	XSSFCell cell = null;
	public static void write() throws IOException {
		
		File src = new File("C:\\eclipse-4.13\\weborders.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int sheets = wb.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if (wb.getSheetName(i).equalsIgnoreCase("Sheet1")) {
				XSSFSheet sheet = wb.getSheetAt(i);
			}
		}
		// Get Access to All rows into the Sheet
		XSSFSheet sheet1 = wb.getSheetAt(0); // Load the first sheet
		
		
		//get all rows in the sheet
        int rowCount=sheet1.getLastRowNum()-sheet1.getFirstRowNum();
        
        for(int i=1;i<=rowCount;i++) {       	
		 //create a new cell in the row at index 2
		XSSFCell cell = sheet1.getRow(i).createCell(2);
		
		cell.setCellValue("Cust No"+i);
		
		// Write the data back in the Excel file
        FileOutputStream outputStream = new FileOutputStream("C:\\eclipse-4.13\\weborders.xlsx");
        wb.write(outputStream);
		
	}
        wb.close();
	

	}
}
