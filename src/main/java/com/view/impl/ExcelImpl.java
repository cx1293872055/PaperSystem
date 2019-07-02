package com.view.impl;

import com.pojo.Paper;
import org.apache.poi.hssf.usermodel.*;

import javax.servlet.ServletOutputStream;
import java.util.List;

public class ExcelImpl {
public void export(String [] titles,List<Paper> list,ServletOutputStream out) throws Exception {

    try {
        //第一步，创建一个workbook，对应一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //第二部，在workbook找那个添加一个sheet，对应Excel文件中的sheet
        HSSFSheet hssfSheet = workbook.createSheet("sheet1");
        //第三部在sheet中天剑表头低0行，之一蓝版本POI对Excel的行列数有限制short
        HSSFRow row = hssfSheet.createRow(0);

        //第四部，创建单元格，并设置值表头，设置表头居中
        HSSFCellStyle hssfCellStyle = workbook.createCellStyle();

        hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        HSSFCell hssfCell = null;
        for (int i = 0; i < titles.length; i++) {
            hssfCell = row.createCell(i);
            hssfCell.setCellValue(titles[i]);
            hssfCell.setCellStyle(hssfCellStyle);
        }

        //第五步写入实体数据
        for (int i = 0; i < list.size(); i++) {
            row = hssfSheet.createRow(i + 1);
            Paper paper = list.get(i);

            //第六步创建单元格，并设置值
            row.createCell(0).setCellValue(paper.getPaperId());

            String name = null;
            if (paper.getPaperName() != null) {
                name = paper.getPaperName();
            }
            row.createCell(1).setCellValue(name);

            String num = null;
            if ((Integer)paper.getPaperNum() != null) {
                num = String.valueOf(paper.getPaperNum());
            }
            row.createCell(2).setCellValue(num);

            String details = null;
            if (paper.getPaperDetail() != null) {
                details = paper.getPaperDetail();
            }
            row.createCell(3).setCellValue(details);
        }

        try {
            workbook.write(out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    } catch (Exception e) {
        e.printStackTrace();
        throw new Exception("导出信息失败");
    }

}
}
