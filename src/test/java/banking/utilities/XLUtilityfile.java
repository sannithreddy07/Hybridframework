package banking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtilityfile {
	
	FileInputStream filein;
	FileOutputStream fileOut;
	public XSSFWorkbook wb;
	public XSSFSheet sh;
	public XSSFRow row;
	public XSSFCell cell;
	String path=null;

	public XLUtilityfile(String path) {
		this.path=path;
	}
	
	public int getRowCount(String Sheetname) throws IOException {
		
		filein=new FileInputStream(path);
		wb=new XSSFWorkbook(filein);
		sh=wb.getSheet(Sheetname);
		int totalrows=sh.getLastRowNum();
		wb.close();
		filein.close();
		return totalrows;
		
	}
	
	public int getColCount(String Sheetname, int rownum) throws IOException {
		
		filein=new FileInputStream(path);
		wb=new XSSFWorkbook(filein);
		sh=wb.getSheet(Sheetname);
		row=sh.getRow(rownum);
		int colcount=row.getLastCellNum();
		wb.close();
		filein.close();
		return colcount;
		
	}
	
	public String getCelldata(String Sheetname, int rownum, int colnum) throws IOException {
		
		filein=new FileInputStream(path);
		wb=new XSSFWorkbook(filein);
		sh=wb.getSheet(Sheetname);
		row=sh.getRow(rownum);
		cell=row.getCell(colnum);
		DataFormatter df=new DataFormatter();
		String data;
		try {
		 data=df.formatCellValue(cell); //store the excel cell in string format and assign it to a string variable
		}catch(Exception e) { //if cell is empty throw an exception
			data="";
		}
		return data;
		
	}
	
public void setCelldata(String Sheetname, int rownum, int colnum, String data) throws IOException {
		
		filein=new FileInputStream(path);
		wb=new XSSFWorkbook(filein);
		sh=wb.getSheet(Sheetname);
		row=sh.getRow(rownum);
		cell=row.getCell(colnum);
		cell.setCellValue(data);
		
		fileOut=new FileOutputStream(path);
		wb.write(fileOut);
		wb.close();
		filein.close();
		fileOut.close();
}

}
