package service;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldPdfService {
    public static final String CREATED_PDF = "D://HelloWorld.pdf";
    public static void main(String[] args) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document,new FileOutputStream(CREATED_PDF));
            document.open();
            // font and color settings
            Font font = new Font(Font.TIMES_ROMAN, 18, Font.NORMAL, Color.MAGENTA);
            Paragraph para = new Paragraph("Hello World PDF created using OpenPDF", font);
            document.add(para);
        } catch (DocumentException | IOException de) {
            System.err.println(de.getMessage());
        }
        document.close();
    }
}