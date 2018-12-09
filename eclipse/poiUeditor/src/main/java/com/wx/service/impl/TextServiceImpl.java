package com.wx.service.impl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx.dao.TextMapper;
import com.wx.entity.Text;
import com.wx.service.TextService;

@Service
public class TextServiceImpl extends BaseService<Text> implements TextService {

	@Autowired
	private TextMapper textMapper;

	private final static String excel2003 = ".xls";
	private final static String excel2007 = ".xlsx";

	@Override
	public int add(Text text) {
		return textMapper.add(text);
	}

	/**
	 * @param in
	 * @param fileName 处理上传的excel文件
	 *
	 */
	public List<List<Object>> getBankListByExcel(InputStream in, String fileName) throws Exception {
		List<List<Object>> list = null;
		// 创建Excel工作薄
		Workbook work = this.getWorkbook(in, fileName);
		if (null == work) {
			throw new Exception("创建Excel工作薄为空！");
		}
		int flag = 0;
		if (work instanceof HSSFWorkbook) {
			flag = 0;
		} else if (work instanceof XSSFWorkbook) {
			flag = 1;
		}
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;

		list = new ArrayList<List<Object>>();
		for (int i = 0; i < work.getNumberOfSheets(); i++) {
			sheet = work.getSheetAt(i);
			if (sheet == null) {
				continue;
			}

			for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
				row = sheet.getRow(j);
				if (row == null || row.getFirstCellNum() == j) {
					continue;
				}

				List<Object> li = new ArrayList<Object>();

				// Pattern pattern = Pattern.compile("[0-9]+.*[0-9]*");
				for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
					cell = row.getCell(y);
					li.add(this.getCellValue(flag, cell, y));
				}
				list.add(li);
			}
		}
		work.close();
		return list;
	}

	// 判断excel文件的格式
	public Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
		Workbook wb = null;
		String fileType = fileName.substring(fileName.lastIndexOf("."));
		if (excel2003.equals(fileType)) {
			wb = new HSSFWorkbook(inStr);
		} else if (excel2007.equals(fileType)) {
			wb = new XSSFWorkbook(inStr);
		} else {
			throw new Exception("解析的文件格式有误！");
		}
		return wb;
	}

	private String getCellValue(int flag, Cell cell, int flag2) {
		String cellvalue = "";
		DataFormatter formatter = new DataFormatter();
		if (flag == 0) {
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_NUMERIC: // 数字
				if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
					cellvalue = formatter.formatCellValue(cell);
				} else {
					double value = cell.getNumericCellValue();
					int intValue = (int) value;
					cellvalue = value - intValue == 0 ? String.valueOf(intValue) : String.valueOf(value);
				}
				break;
			case HSSFCell.CELL_TYPE_STRING: // 字符串
				cellvalue = cell.getStringCellValue();
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
				cellvalue = String.valueOf(cell.getBooleanCellValue());
				break;
			case HSSFCell.CELL_TYPE_FORMULA: // 公式
				cellvalue = String.valueOf(cell.getCellFormula());
				break;
			case HSSFCell.CELL_TYPE_BLANK: // 空值
				cellvalue = "";
				break;
			case HSSFCell.CELL_TYPE_ERROR: // 故障
				cellvalue = "";
				break;
			default:
				cellvalue = "UNKNOWN TYPE";
				break;
			}
		} else if (flag == 1) {
			switch (cell.getCellType()) {
			case XSSFCell.CELL_TYPE_NUMERIC: // 数字
				if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
					cellvalue = formatter.formatCellValue(cell);
				} else {
					double value = cell.getNumericCellValue();
					int intValue = (int) value;
					if (flag2 >= 11 && flag2 <= 14) {
						Calendar calendar = new GregorianCalendar(1900, 0, -1);
						Date d = calendar.getTime();
						Date dd = DateUtils.addDays(d, intValue);
						SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日hh:mm");
						cellvalue = sdf.format(dd);
						break;
					}
					cellvalue = value - intValue == 0 ? String.valueOf(value) : String.valueOf(intValue);
				}
				break;
			case XSSFCell.CELL_TYPE_STRING: // 字符串
				cellvalue = cell.getStringCellValue();
				break;
			case XSSFCell.CELL_TYPE_BOOLEAN: // Boolean
				cellvalue = String.valueOf(cell.getBooleanCellValue());
				break;
			case XSSFCell.CELL_TYPE_FORMULA: // 公式
				cellvalue = String.valueOf(cell.getCellFormula());
				break;
			case XSSFCell.CELL_TYPE_BLANK: // 空值
				cellvalue = "";
				break;
			case XSSFCell.CELL_TYPE_ERROR: // 故障
				cellvalue = "";
				break;
			default:
				cellvalue = "UNKNOWN TYPE";
				break;
			}
		}
		return cellvalue.trim();
	}

}
