package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public XSSFSheet ws;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;

	public ExcelUtility(String path) {
		this.path = path;
	}

	// To count number of rows
	public int getRowCount(String sheetName) throws IOException {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		int rowcount = ws.getLastRowNum();

		wb.close();
		fi.close();
		return rowcount;
	}

	// To count specific cell data
	public int getCellCount(String sheetName, int rownum) throws IOException {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();

		wb.close();
		fi.close();
		return cellcount;
	}

	// To get Excel Cell Data
	public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);

		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}

		wb.close();
		fi.close();
		return data;
	}

	// To input Data in Excel Cell
	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {

		File xlfile = new File(path);
		if (!xlfile.exists()) // If file not exists then create new file
		{
			wb = new XSSFWorkbook();
			fo = new FileOutputStream(path);
			wb.write(fo);
		}
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);

		if (wb.getSheetIndex(sheetName) == -1)
			wb.createSheet(sheetName);
		ws = wb.getSheet(sheetName);

		if (ws.getRow(rownum) == null)
			ws.createRow(rownum);

		row = ws.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);

		fo = new FileOutputStream(path);
		wb.write(fo);

		wb.close();
		fi.close();
		fo.close();

	}

	// To fill color -> Status of TestCases
	public void fillRedColor(String sheetName, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);

		style = wb.createCellStyle();

		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fo = new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}

}