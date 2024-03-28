package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class class consists of generic methods related to Excel file
 * @author ganta
 *
 */
public class ExcelFileUtility {
	/**
	 * This method will read data from Excel file and return value to the caller
	 * @param sheetname
	 * @param rowno
	 * @param colno
	 * @return
	 * @throws EncryptedDocumentException	
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheetname,int rowNo, int colNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(rowNo).getCell(colNo).getStringCellValue();
		return value;
	}

}
