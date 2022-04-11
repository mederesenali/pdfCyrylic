package com.example.downloadpdf;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class PdfExporterServiceTest {
    @Test
    public void encoding(){
        String germanString = "This is a тайтл.";
        byte[] germanBytes = germanString.getBytes();

        String asciiEncodedString = new String(germanBytes, StandardCharsets.UTF_8);
        assertEquals(asciiEncodedString, "This is a тайтл.");

    }

    @Test
    public void documnetTest() throws UnsupportedEncodingException {
        String russianString = "тайтл.";
        byte[] bytes = russianString.getBytes("ISO_8859_1");
        String value = new String(bytes, "ISO_8859_1");
        assertEquals(value, "This is a тайтл.");


    }
    @Test
    public void cp() throws UnsupportedEncodingException {
        String russianString = "тайтл.";
        byte[] bytes = russianString.getBytes("CP1252");
        String value = new String(bytes, "CP1252");
        assertEquals(value, "This is a тайтл.");


    }

}