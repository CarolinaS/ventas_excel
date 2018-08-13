package com.tcs.ventas.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.tcs.ventas.model.dto.VentaDTO;
import com.tcs.ventas.model.dto.VentaDetalleDTO;

public class ExcelView extends AbstractXlsView{

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      Workbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        response.setHeader("Content-Disposition", "attachment; filename=\"venta.xls\"");

        @SuppressWarnings("unchecked")
        VentaDTO venta = (VentaDTO) model.get("venta");

        Sheet sheet = workbook.createSheet("Venta Detail");
        sheet.setDefaultColumnWidth(30);

        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setBold(true);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);


        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("codigoProducto");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("precioProducto");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("nombreProducto");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("cantidad");
        header.getCell(3).setCellStyle(style);
        header.createCell(4).setCellValue("subtotal");
        header.getCell(4).setCellStyle(style);



        int rowCount = 1;

        for(VentaDetalleDTO venta1 : venta.getItems()){
            Row ventaRow =  sheet.createRow(rowCount++);
            ventaRow.createCell(0).setCellValue(venta1.getCodigoProducto());
            ventaRow.createCell(1).setCellValue(venta1.getPrecioProducto().doubleValue());
            ventaRow.createCell(2).setCellValue(venta1.getNombreProducto());
            ventaRow.createCell(3).setCellValue(venta1.getCantidad());
            ventaRow.createCell(4).setCellValue(venta1.getSubTotal().doubleValue());

            }

    }

}
