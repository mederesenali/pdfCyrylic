package com.example.downloadpdf;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import org.springframework.stereotype.Service;

@Service
public class PdfExporterService {
    public static final String FONT = "static/Arial Cyr.ttf";

    public void export(HttpServletResponse response) {
        try (Document document = new Document(PageSize.A4)){
            PdfWriter.getInstance(document, response.getOutputStream());
            BaseFont russianFont = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            String germanString = "This is a тайтл.";
            byte[] germanBytes = germanString.getBytes();
            String value = new String(germanBytes, StandardCharsets.UTF_8);
            document.open();
            Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            Font font = new Font(russianFont);
            fontTitle.setSize(18);
            Paragraph paragraph = new Paragraph(value, font);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
}
