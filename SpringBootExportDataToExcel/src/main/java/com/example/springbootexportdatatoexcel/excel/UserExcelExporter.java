package com.example.springbootexportdatatoexcel.excel;

import com.example.springbootexportdatatoexcel.model.Student;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserExcelExporter {
    private XSSFWorkbook workbook;

    private XSSFSheet sheet;

    private List<Student> listStudent;

    public UserExcelExporter(List<Student> listStudent) {
        this.listStudent = listStudent;
        workbook = new XSSFWorkbook();
    }
    // Row : hàng ngang, columnCount : cột, cell : Ô

    //Tạo các Cell
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    // Tạo dòng tiêu đề Header
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Student");

        Row row = sheet.createRow(0); // Hàng đầu tiên
        XSSFCellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true); // Bôi đậm chữ
        font.setFontHeight(20); // Chiều cao chữ
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        createCell(row, 0, "Student Information", style);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
        font.setFontHeightInPoints((short) (10));

        row = sheet.createRow(1);
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "Student Id", style);
        createCell(row, 1, "Student Name", style);
        createCell(row, 2, "Student Address", style);
        createCell(row, 3, "Student City", style);
        createCell(row, 4, "Student Pin", style);
    }

    // Tạo dữ liệu cho các dòng
    private void writeDataLine() {
        int rowCount = 2;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);

        for (Student stu : listStudent) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, stu.getsId(), style);
            createCell(row, columnCount++, stu.getsName(), style);
            createCell(row, columnCount++, stu.getsAddress(), style);
            createCell(row, columnCount++, stu.getsCity(), style);
            createCell(row, columnCount++, stu.getsPin(), style);
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLine();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

}
