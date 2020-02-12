package PART19.com.qa.exceloperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TC02_ExcelOperations_CountColumns {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis= new FileInputStream("C:\\Users\\ADMIN\\Desktop\\SampleData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("LoginData");
		int rc=ws.getLastRowNum();
		
		XSSFRow row;
		
		   for(int i=0;i<=rc;i++)
		   {
			 row=ws.getRow(i); 
			 int colcount=row.getLastCellNum();
			 System.out.println("NO OF COLUMNS ARE->"+colcount);
		   }
		   
		    wb.close();
		    fis.close();
		
		
		
	}

}
