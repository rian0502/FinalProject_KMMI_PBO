/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectpbo;

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
        stage.setTitle("Sistem Nasabah Koperasi");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        NasabahDataModel nadamod = new NasabahDataModel();
        Individu indv = new Individu(1, "Alif Akbar", "Pringsewu", 20102L, 123123L, new Rekening(1231231, 23123.0));
//        launch(args);
        DBHelper.getConnection();
    }
    
}
