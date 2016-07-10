/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfcreatorv1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private final PDDocument document;
    private PDPage current_page;
    private PDPageContentStream contents;
    private PDImageXObject pdImage;
    
    // construtor
    public PDFBox()
    {
        document=new PDDocument();
    }
            
    void createPdfFile(String f) throws IOException
    {
        try
        {
            document.save(f);
        }
        finally
        {
            document.close();
        }
    }
    
    void addImage(String f) {
       
        
        try {
            contents = new PDPageContentStream(document, current_page, AppendMode.APPEND, true, true);

            pdImage = PDImageXObject.createFromFile(f, document);

            contents.drawImage(pdImage,0,0);

            contents.close();
        } catch (IOException ex) {
            Logger.getLogger(PDFBox.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void addPage(PDRectangle p) {
        
        current_page = new PDPage(p);
        document.addPage(current_page);
    }
}
