package PART19.com.qa.exceloperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TC03_ExcelOperations_ReadingData {
	
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\ADMIN\\Desktop\\SampleData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("LoginData");	
		int rc=ws.getLastRowNum();
		
		XSSFRow row;
		XSSFCell cell1,cell2;
		String UserName,Password;
		 
		for(int i=0; i<rc; i++) 
		{
			row=ws.getRow(i);
			cell1=row.getCell(0);
			cell2=row.getCell(1);
			
			UserName=cell1.getStringCellValue();
			Password=cell2.getStringCellValue();
			
			System.out.println(UserName +"=" +Password);
			wb.close();
			fis.close();
		}
		
		
 		
		
	}

}
