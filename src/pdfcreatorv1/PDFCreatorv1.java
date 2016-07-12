/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfcreatorv1;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import static java.lang.System.in;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

/**
 *
 * @author Carlos
 */
public class PDFCreatorv1 extends Application {
    
    PDFBox document;
    
    @Override
    public void start(Stage primaryStage) {
        document=new PDFBox();
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
                try {
                    
                    
                    //list specific files
                    File f = new File("D:\\Camera - Copy");
                    File[] list = f.listFiles(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.toLowerCase().endsWith(".jpg");
                    };
                    });
                    
                    int i=1;
                    
                    System.out.println("Tamanho"+list.length);
                    
                    for(File ficheiro:list) {
                        document.addImage(ficheiro.toString());
                        if((i%5)==0) {
                            document.savePdfFile("d:\\temp.pdf");
                            System.out.println("salva...");
                        }
                        System.out.println(i++);
                    }               

                    
                    document.createPdfFile("d:\\temp.pdf");
                    
                } catch (IOException ex) {
                    Logger.getLogger(PDFCreatorv1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
