/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectpbo;

import java.sql.SQLException;
import java.util.ArrayList;

import finalprojectpbo.database.DBHelper;
import finalprojectpbo.database.NasabahDataModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/view.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
//        NasabahDataModel ahdm = new NasabahDataModel();
//        Individu ih = new Individu(2, "Alif Akbar", "Pringsewu", 123123L, 12334L, new Rekening(12312, 312515));
//        ahdm.addIndvidual(ih);
//        launch(args);
        DBHelper.getConnetion();
    }
    
}
