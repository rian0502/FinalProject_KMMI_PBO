/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectpbo.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import finalprojectpbo.Individu;
import finalprojectpbo.Rekening;
import finalprojectpbo.database.NasabahDataModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.xml.ws.Holder;


public class viewController implements Initializable {

    @FXML
    private Label lblAddStatusindividual;

    @FXML
    private Label lblAddStatusPerusahaan;

    @FXML
    private Label lblDBStatus;

    @FXML
    private TextField tfIDIndividual;

    @FXML
    private TextField tfNamaIndividual;

    @FXML
    private TextField tfAlamatIndividual;

    @FXML
    private TextField tfNIKIndividual;

    @FXML
    private TextField tfNPWPIndividual;

    @FXML
    private TextField tfNoRekIndividual;

    @FXML
    private TextField tfSaldoRekIndividual;

    @FXML
    private Button btnAddIndividual;

    @FXML
    private Button btnPerbaruiIndividual;

    @FXML
    private Button btnHapusIndividual;

    @FXML
    private TextField tfIDNasabahBaruIndividual;

    @FXML
    private TextField tfNoRekBaruIndividual;

    @FXML
    private TextField tfSaldoRekBaruIndividual;

    @FXML
    private Button btnTambahRekBaruIndividual;

    @FXML
    private TextField tfIDPerusahaan;

    @FXML
    private TextField tfNamaPerusahaan;

    @FXML
    private TextField tfAlamatPerusahaan;

    @FXML
    private TextField tfNIBPerusahaan;

    @FXML
    private TextField tfNoRekPerusahaan;

    @FXML
    private TextField tfSaldoPerusahaan;

    @FXML
    private Button btnAddPerusahaan;

    @FXML
    private Button btnPerbaruiPerusahaan;

    @FXML
    private Button btnHapusPerusahaan;

    @FXML
    private TextField tfIDNasabahBaruPerusahaan;

    @FXML
    private TextField tfNoRekBaruPerusahaan;

    @FXML
    private TextField tfSaldoRekBaruPerusahaan;

    @FXML
    private Button btnTambahRekBaruPerusahaan;

    private NasabahDataModel nadamod;

    @FXML
    void handleHapusIndividual(ActionEvent event) {
        tfIDIndividual.setText(""+nadamod.nextRekeningID());
        tfNoRekIndividual.setText(tfIDIndividual.getText() + "01");
    }

    @FXML
    void handleHapusPerusahaan(ActionEvent event) {

    }

    @FXML
    void handlePerbaruiTabelIndividual(ActionEvent event) {

    }

    @FXML
    void handlePerbaruiTabelPerusahaan(ActionEvent event) {

    }

    @FXML
    void handleTambahNasabahIndividual(ActionEvent event) throws SQLException {
        Individu holderIndividu = new Individu(
            Integer.parseInt(tfIDIndividual.getText()),
            tfNamaIndividual.getText(),
            tfAlamatIndividual.getText(),
            Long.parseLong(tfNIKIndividual.getText()),
            Long.parseLong(tfNPWPIndividual.getText()),
            new Rekening(Integer.parseInt(tfNoRekIndividual.getText()), Double.parseDouble(tfSaldoRekIndividual.getText()))
        );

        nadamod.addIndvidual(holderIndividu);
        lblAddStatusindividual.setText("Account berhasil dibuat");
        btnPerbaruiIndividual.fire();
        btnHapusIndividual.fire();
    }

    @FXML
    void handleTambahNasabahPerusahaan(ActionEvent event) {

    }

    @FXML
    void handleTambahRekBaruIndividual(ActionEvent event) {

    }

    @FXML
    void handleTambahRekBaruPerusahaan(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        //DB Status
        nadamod = new NasabahDataModel();
        lblDBStatus.setText(nadamod.connection == null? "Not Connected" : "Connected");
        //New
        btnHapusIndividual.fire(); //Clear and also show id nasabah with nomor rekening
        btnPerbaruiIndividual.fire(); //Show data in table
    }
    
}
