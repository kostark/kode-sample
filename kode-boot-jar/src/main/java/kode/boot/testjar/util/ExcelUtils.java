package kode.boot.testjar.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.*;

/**
 * @since 1.0 - 2016/11/23
 */
public class ExcelUtils {

	private HSSFWorkbook workbook;
	private HSSFSheet currentSheet;
	private LinkedList<String> propertiesList;
	private String currentTitle;

	public ExcelUtils() {
		workbook = new HSSFWorkbook();
	}

	public void createSheet(String name) {
		currentSheet = workbook.createSheet(name);
		propertiesList = new LinkedList<>();
		currentTitle = null;
	}

	public void setTitle(String title) {
		currentTitle = title;
		HSSFRow row1 = currentSheet.createRow(0);
		HSSFCell cell = row1.createCell(0);
		cell.setCellValue(currentTitle);

	}

	/**
	 * 名称属性隐射
	 *
	 * @param headerMap 标题和属性的隐射
	 */
	public void setHeader(Map<String, String> headerMap) {
		LinkedHashMap<String, String> currentHeader = new LinkedHashMap<>(headerMap);
		currentHeader.entrySet().forEach(c -> propertiesList.add(c.getValue()));

		// 设置标题的单元格合并
		currentSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, currentHeader.size() - 1));

		//在sheet里创建第二行
		HSSFRow rowHeader = currentSheet.createRow(1);

		//创建单元格并设置单元格内容
		int columnIndex = 0;
		for (String headerName : currentHeader.keySet()) {
			HSSFCell cell = rowHeader.createCell(columnIndex);
			cell.setCellValue(headerName);
			columnIndex++;
		}
	}

	private void setCell(HSSFCell cell, Object value) {
		if (value == null)
			return;

		if (value instanceof String) {
			cell.setCellValue((String) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else if (value instanceof Date) {
			cell.setCellValue((Date) value);
		} else if (value instanceof Calendar) {
			cell.setCellValue((Calendar) value);
		} else if (value instanceof Double) {
			cell.setCellValue((Double) value);
		} else if (value instanceof BigDecimal) {
			cell.setCellValue(((BigDecimal) value).longValue());
		} else {
			cell.setCellValue(value.toString());
		}
	}

	public void setData(List<Map<String, Object>> data) {
		int rowIndex = 2;
		for (Map<String, Object> map : data) {
			HSSFRow row = currentSheet.createRow(rowIndex);

			int columnIndex = 0;
			for (String columnName : propertiesList) {
				HSSFCell cell = row.createCell(columnIndex);
				setCell(cell, map.get(columnName));
				columnIndex++;
			}

			rowIndex++;
		}
	}

	public void setFooter() {
	}

	/**
	 * 导出 excel 到输出流
	 *
	 * @param os 输出流
	 * @throws IOException 输出异常
	 */
	public void export(OutputStream os) throws IOException {
		workbook.write(os);
	}
}
