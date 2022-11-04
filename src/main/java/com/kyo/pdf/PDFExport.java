/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kyo.pdf;

import com.kyo.pojos.Bill;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author datly
 */
public class PDFExport {

    private Bill bill;
    public PDFExport(Bill bill){
        this.bill=bill;
    }
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setPadding(8);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setColor(Color.BLACK);
         
        cell.setPhrase(new Phrase("Ma hoa don", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Ma phong", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Ma khach hang", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Tien dien", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Tien nuoc", font));
        table.addCell(cell);  
        cell.setPhrase(new Phrase("Tien phong", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Ngay tao ", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Tong tien", font));
        table.addCell(cell);
    }
     private void writeTableData(PdfPTable table) {
            table.addCell(String.valueOf(bill.getIdBill()));
            table.addCell(String.valueOf(bill.getIdRoom()));
            table.addCell(String.valueOf(bill.getIdCustomer()));
            table.addCell(String.valueOf(bill.getTienDien()));
            table.addCell(String.valueOf(bill.getTienNuoc()));
            table.addCell(String.valueOf(bill.getTienPhong()));
            table.addCell(String.valueOf(bill.getCreateDate()));
            table.addCell(String.valueOf(bill.getTotal()));
        
        

        
    }
    public void export(HttpServletResponse response) throws DocumentException, IOException {
         Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("Hoa don", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {3.0f, 3.5f, 3.0f, 3.0f, 3.0f, 2.5f, 3.0f, 2f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}
