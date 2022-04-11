package com.example.downloadpdf;

import java.awt.Color;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import org.springframework.stereotype.Service;

@Service
public class PdfExporterService {
    public static final String FONT = "static/Arial Cyr.ttf";

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
       // cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);



        Font font = FontFactory.getFont(FontFactory.HELVETICA,"utf-16");
        ((com.lowagie.text.Font) font).setColor(Color.WHITE);

        cell.setPhrase(new Phrase("abc", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("аыфваываы", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("аывфаыаывф", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("аываывалжывалы", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("ваожвыаыжфалыфжвж", font));
        table.addCell(cell);
    }


//
//    public void export(HttpServletResponse response) throws DocumentException, IOException {
//        Document document = new Document(PageSize.A4);
//        PdfWriter.getInstance(document, response.getOutputStream());
//
//        document.open();
//        com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//        font.setSize(18);
//       // font.setColor(Color.BLUE);
//
//        Paragraph p = new Paragraph("List of Users", font);
//        p.setAlignment(Paragraph.ALIGN_CENTER);
//
//        document.add(p);
//
//        PdfPTable table = new PdfPTable(5);
//        table.setWidthPercentage(100f);
//        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
//        table.setSpacingBefore(10);
//
//        writeTableHeader(table);
//
//        document.add(table);
//
//        document.close();
//
//    }
    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        BaseFont russianFont=BaseFont.createFont(FONT, BaseFont.IDENTITY_H,BaseFont.EMBEDDED);//RECOGNIZED




        String germanString = "This is a тайтл.";
        byte[] germanBytes = germanString.getBytes();
        String value = new String(germanBytes, StandardCharsets.UTF_8);

        document.open();
       Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD); //  ????

        Font font=new Font(russianFont);
       // Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);//.
        fontTitle.setSize(18);


        Paragraph paragraph = new Paragraph(value, font);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(paragraph);
        document.close();
    }
}
