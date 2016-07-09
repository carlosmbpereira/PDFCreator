/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfcreatorv1;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 *
 * @author Carlos
 */
public class PDFBox {
    
    private PDDocument document;
    
    // construtor
    public PDFBox()
    {
        document=new PDDocument();
    }
            
    void createPdfFile(String f) throws IOException
    {
        try
        {
            // a valid PDF document requires at least one page
           
            
            PDPage page = new PDPage(PDRectangle.A1);
            document.addPage(page);
            
            PDImageXObject pdImage = PDImageXObject.createFromFile("d:\\image.jpg", document);
            
            PDPageContentStream contents = new PDPageContentStream(document, page, AppendMode.APPEND, true, true);
            
            contents.drawImage(pdImage, 20, 20);
            
            contents.close();
            
            page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            
            contents = new PDPageContentStream(document, page, AppendMode.APPEND, true, true);
            
            pdImage = PDImageXObject.createFromFile("d:\\image1.jpg", document);
            
            contents.drawImage(pdImage,0,0);
                    
            contents.close();
            
            document.save(f);
        }
        finally
        {
            document.close();
        }
    }
}
