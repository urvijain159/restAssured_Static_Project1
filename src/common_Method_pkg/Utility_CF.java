package common_Method_pkg;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility_CommonFunctions {
	public static void creator(String eve_filename,String req_body,String res_body) throws IOException
	{
		File newfile=new File("C:\\Users\\Admin\\Desktop\\restAssuredProject\\" +eve_filename+".txt");
		System.out.println(" A new text file created with name:" +newfile.getName());
		
		FileWriter datawriter=new FileWriter(newfile);
		datawriter.write("Request Body :"+"\n" +req_body+"\n\n");
		datawriter.write("Response Body :"+"\n" +res_body);
		datawriter.close();
		System.out.println("request body and response body are written into text file named: " +newfile.getName());
		
	}
	
	public static ArrayList<String> readdataexcel(String sheetname,String testcasename) throws IOException
	{
		ArrayList<String> Data=new ArrayList<String>();
		//step1: create the object of File input stream
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Desktop\\restAssuredProject\\Urvi_API_testData.xlsx");
		//step2: access the excel file 
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		//step3: access the sheet name
		int countofsheet=workbook.getNumberOfSheets();
		for (int i=0;i<countofsheet;i++)
		{
			String filesheetname=workbook.getSheetName(i);
			if(filesheetname.equalsIgnoreCase(sheetname))
			{
				//step4: access the row from where the data is suppose to fetch
				XSSFSheet sheet=workbook.getSheetAt(i);
				Iterator<Row> rows=sheet.iterator();
				//Row r=rows.next();
				while(rows.hasNext())
				{
					Row r1=rows.next();
					if(r1.getCell(0).getStringCellValue().equalsIgnoreCase(testcasename))
					{
						Iterator<Cell> cellvalues=r1.cellIterator();
						while(cellvalues.hasNext()) {
							String testdata=cellvalues.next().getStringCellValue();
							Data.add(testdata);
						}
					}
				}
			}
			
		}

		
			workbook.close();
		    return Data;
      }
      }

         
