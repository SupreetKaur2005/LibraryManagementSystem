package util;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PDFGenerator {

    private static final Logger logger = Logger.getLogger(PDFGenerator.class.getName());

    public static void generateSimpleReport(String fileName, String content) {
        if (fileName == null || content == null) {
            logger.warning("generateSimpleReport called with null parameters");
            return;
        }
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            Document document = new Document();
            PdfWriter.getInstance(document, fos);
            document.open();
            document.add(new Paragraph(content));
            document.close();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to generate PDF", e);
        }
    }
}
