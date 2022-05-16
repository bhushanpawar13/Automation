package AutoTrial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class excelread {

	

	// Constructor
	public excelread() {
		
		
	}
	public static String read() throws IOException {
		String data = null;
		
	// Get Access to sheet
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
	int rowcount = sheet1.getLastRowNum();System.out.println("Total Row: "+rowcount);
	int colcount = sheet1.getRow(1).getLastCellNum();System.out.println("Total col: "+""+colcount);
	for(int i=1;i<=rowcount;i++)
	{
		data = new DataFormatter().formatCellValue(sheet1.getRow(i).getCell(0)); // modified
	
		System.out.println(data);
		wb.close();
	}
	return data;
	
}
	
	
	}