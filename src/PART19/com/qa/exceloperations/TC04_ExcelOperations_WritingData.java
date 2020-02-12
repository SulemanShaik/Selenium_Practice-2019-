package PART19.com.qa.exceloperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TC04_ExcelOperations_WritingData {
	
	public static void main(String[] args) throws IOException {
		
		
		FileInputStream fis= new FileInputStream("C:\\Users\\ADMIN\\Desktop\\SampleData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("LoginData");
		 XSSFRow row;
		XSSFCell  cell;
		
		
		
		row =ws.getRow(1);
		cell=row.createCell(2);
		cell.setCellValue("PASS");
		
		row=ws.getRow(2);
	    cell=row.createCell(2);
	    cell.setCellValue("FAIL");
		
		
          FileOutputStream  fos = new FileOutputStream("C:\\Users\\ADMIN\\Desktop\\SampleData.xlsx");
		   wb.write(fos);
		        
		      wb.close();
		      fis.close();
		      fos.close();
		     
		
		
		
		
	}

}
