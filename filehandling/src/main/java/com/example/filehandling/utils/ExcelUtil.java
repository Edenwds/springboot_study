package com.example.filehandling.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @Author: wds
 * @Description:
 * @Date: created in 15:10 2019/5/24
 */
public class ExcelUtil {

    public static OutputStream export(String title, String[] rowNames, List<JSONObject> dataList, OutputStream outputStream) throws IOException {

        SXSSFWorkbook workbook = new SXSSFWorkbook();
        SXSSFSheet sheet = (SXSSFSheet) workbook.createSheet(title);
        //设置默认列宽
        sheet.setDefaultColumnWidth(25);

        //设置表格标题
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, rowNames.length));
        SXSSFRow rowTitle = (SXSSFRow) sheet.createRow(0);
        rowTitle.setHeightInPoints(31f);
        SXSSFCell cellTitle = (SXSSFCell) rowTitle.createCell(0);
        //标题样式
        CellStyle titleStyle = getTitleStyle(workbook, 13);
        cellTitle.setCellStyle(titleStyle);
        cellTitle.setCellValue(title);

        //设置列名
        SXSSFRow rowRname = (SXSSFRow) sheet.createRow(1);
        CellStyle rowStyle = workbook.createCellStyle();
        rowStyle.setBottomBorderColor(HSSFColor.BLACK.index);
        rowRname.setRowStyle(rowStyle);
        rowRname.setHeightInPoints(21f);
        //列名样式
        CellStyle columnStyle = getColumnStyle(workbook, 12);
        for (int i = 0; i <= rowNames.length; i++) {
            SXSSFCell cellRname = (SXSSFCell) rowRname.createCell(i);
            cellRname.setCellType(SXSSFCell.CELL_TYPE_STRING);
            XSSFRichTextString text = null;
            if (i == 0) {
                text = new XSSFRichTextString("序号");
            } else {
                text = new XSSFRichTextString(rowNames[i - 1]);
            }
            cellRname.setCellValue(text);
            cellRname.setCellStyle(columnStyle);
        }

        //设置其他行
        //其他行样式
        CellStyle dataStyle = getDataStyle(workbook, 11);
        for (int i = 0; i < dataList.size(); i++) {
            JSONObject data = dataList.get(i);
            SXSSFRow dataRow = (SXSSFRow) sheet.createRow(i + 2);
            for (int j = 0; j <= rowNames.length; j++) {
                SXSSFCell cell = null;
                if (j == 0) {
                    cell = (SXSSFCell) dataRow.createCell(0, SXSSFCell.CELL_TYPE_NUMERIC);
                    cell.setCellValue(i + 1);
                } else {
                    cell = (SXSSFCell) dataRow.createCell(j, SXSSFCell.CELL_TYPE_NUMERIC);
                    cell.setCellValue(data.getString(rowNames[j - 1]));
                }
                cell.setCellStyle(dataStyle);
            }
        }

        //写到输入流
        workbook.write(outputStream);
        workbook.close();
        return outputStream;
    }

    private static CellStyle getDataStyle(SXSSFWorkbook workbook, int fontSize) {
        //设置字体
        Font font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short)fontSize);
        //设置字体名字
        font.setFontName("宋体");
        //设置样式;
        CellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(CellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(CellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(CellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(CellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(true);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(CellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        return style;
    }

    private static CellStyle getColumnStyle(SXSSFWorkbook workbook, int fontSize) {
        // 设置字体
        Font font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short)fontSize);
        //字体加粗
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("宋体");
        //设置样式;
        CellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(CellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(CellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(CellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(CellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(CellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        //设置背景填充色（前景色）
        style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);//设置别的颜色请去网上查询相关文档
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        return style;
    }

    private static CellStyle getTitleStyle(SXSSFWorkbook workbook, int fontSize) {
        // 设置字体
        Font font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short)fontSize);
        //字体加粗
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        //设置字体名字
        font.setFontName("宋体");
        //设置样式;
        CellStyle style = workbook.createCellStyle();
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(CellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        return style;
    }

}
