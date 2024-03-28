package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//step1: Open the Document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//step2: Cretae a workbook
		Workbook wb = WorkbookFactory.create(fis);			
		
		//step3:Navigate to required sheet
		Sheet sh = wb.getSheet("Contacts");	
		
		//step3:Navigate to required row 
		Row rw = sh.getRow(1);
		
		////step5:Navigate to required cell 
		Cell cl = rw.getCell(2);
		
		//step6: Capture the data
		String value = cl.getStringCellValue();
		System.out.println(value);
		
		//step7: Close the workbook
		wb.close();
		

	}

}
