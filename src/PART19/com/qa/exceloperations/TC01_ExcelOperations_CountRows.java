package PART19.com.qa.exceloperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TC01_ExcelOperations_CountRows {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis= new FileInputStream("C:\\Users\\ADMIN\\Desktop\\SampleData.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("LoginData");
		int rowcount=ws.getLastRowNum();
		System.out.println("NO OF ROWS ARE->"+rowcount);
		
		 wb.close();
		 fis.close();
	}

}
		