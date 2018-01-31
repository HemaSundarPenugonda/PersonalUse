package com.hs.poc;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class POIUtilities {

    public static XSSFSheet createNewSheetExcel(XSSFWorkbook workbook, String sheetName) {
        return workbook.createSheet(sheetName);
    }

    public static void writeToCellExcel(XSSFSheet sheet, int rowNum, int colNum, String field) {
        writeToCellExcel(sheet, rowNum, colNum, field, false);
    }

    public static void writeToCellExcel(XSSFSheet sheet, int rowNum, int colNum, String field, boolean bold) {

        XSSFFont font = sheet.getWorkbook().createFont();
        font.setBold(true);

        XSSFCellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
//        cellStyle.setWrapText(true);

        Row row;
        Cell cell;
        row = sheet.getRow(rowNum);
        if (row == null)
            row = sheet.createRow(rowNum);
        row.setRowStyle(cellStyle);

        cell = row.getCell(colNum);
        if (cell == null)
            cell = row.createCell(colNum);
        cell.setCellValue(field);
        if (bold)
            cell.setCellStyle(cellStyle);

    }

    public static XSSFWorkbook createExcel() {
        return new XSSFWorkbook();
    }

    public static void writeToExcel(String fileName, XSSFWorkbook workbook) throws IOException {
        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            workbook.write(outputStream);
        } finally {
            workbook.close();
        }
    }

    public static void setAutoAdjustColumns(XSSFSheet sheet) {
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);
    }
}
