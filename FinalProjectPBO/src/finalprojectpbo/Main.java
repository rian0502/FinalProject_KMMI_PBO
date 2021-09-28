/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectpbo;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author muham
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/view.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        ArrayList<Rekening> rekening = new ArrayList<Rekening>();
            
        Rekening rek1 = new Rekening(1, 1000000);
        Rekening rek2 = new Rekening(2, 1500000);
        Rekening rek3 = new Rekening(3, 2000000);

        rekening.add(rek1);
        rekening.add(rek2);
        rekening.add(rek3);
       
        
        Nasabah[] na = {new Individu(11111, 11111, "Nama", "Alamat", rekening), new Perusahaan("NIB", "Nama", "Alamat", rekening)};
    
    }
    
}
