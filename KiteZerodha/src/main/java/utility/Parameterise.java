package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parameterise {
public static String Exceldata(int row , int col) throws EncryptedDocumentException, IOException
{
	FileInputStream file = new FileInputStream("E:\\jawaautomation\\KiteZerodha\\src\\test\\resources\\Book1.xlsx");
	 String user = WorkbookFactory.create(file).getSheet("Credential").getRow(row).getCell(col).getStringCellValue();
	return user;
}
}
