package util;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class PDFGenerator {

    public static void generateSimpleReport(String fileName, String content) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();
            document.add(new Paragraph(content));
            document.close();
        } catch (Exception e) {
            System.err.println("Failed to generate PDF: " + e.getMessage());
        }
    }
}
