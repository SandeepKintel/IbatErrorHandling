package IbatAttemptToRecovery.IbatErrorHandling;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class LsbfDatasheet 
{
	static String username;
	static String password;
	
	public void getData() throws EncryptedDocumentException, IOException{
	FileInputStream f1=new FileInputStream("C:\\Users\\sandeep.kumar\\eclipse-workspace\\LsbfErrorHandling\\Datasheet.xlsx");
		Workbook w1=WorkbookFactory.create(f1);
		username= w1.getSheet("creds").getRow(1).getCell(0).getStringCellValue();
		password= w1.getSheet("creds").getRow(1).getCell(1).getStringCellValue();
		
	}

}
