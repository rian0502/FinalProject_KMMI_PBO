/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectpbo;

import java.sql.Connection;
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
        stage.setTitle("Sistem Koperasi");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
//        DBHelper.getConnetion();
    }
    
}
