package ValidOperationtestScript;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ValidationExcelOperation 
{
	public static String readData(String sheetName, int rowNum, int cellNum)
	{
	   try
	    {
		FileInputStream fis=new FileInputStream("G:\\TestData\\ValidoperationExcel.xlsx");
		Workbook w=WorkbookFactory.create(fis);
		String data=w.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	    }
	   catch(Exception e)
	    { 
		System.out.println("Exception Occured");
		return "";
		}
	}
	public static void writeData(String sheetName, int rowNum, int cellNum,String data)
	  {
		try
		{
		FileInputStream fis=new FileInputStream("G:\\TestData\\ValidoperationExcel.xlsx");
		Workbook w=WorkbookFactory.create(fis);
		w.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("G:\\TestData\\ValidoperationExcel.xlsx");
		w.write(fos);
		}
		catch(Exception e)
		{
		System.out.println("Exception Occured Again");	
		}
	}

}
