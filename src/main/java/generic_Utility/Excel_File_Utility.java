package generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This Class Consist of Methods Related to Excel File
 */
public class Excel_File_Utility {
/**
 * 
 * @param sheetname
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String ToReadTheDataFromExcelFile(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException{

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Workbook ws = WorkbookFactory.create(fis);
		String value = ws.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return value;
		
		
		
	}
}
