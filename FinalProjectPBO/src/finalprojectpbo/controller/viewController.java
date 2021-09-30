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

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;
import com.sun.org.apache.regexp.internal.RE;
import finalprojectpbo.Individu;
import finalprojectpbo.Perusahaan;
import finalprojectpbo.Rekening;
import finalprojectpbo.database.NasabahDataModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.xml.ws.Holder;


public class viewController implements Initializable {
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
    private Label lblAddStatusindividual;

    @FXML
    private TableView<Individu> tblDataIndividu;

    @FXML
    private TableColumn<Individu, Integer> colIDIndividu;

    @FXML
    private TableColumn<Individu, String> colNamaIndividu;

    @FXML
    private TableColumn<Individu, String> colAlamatIndividu;

    @FXML
    private TableColumn<Individu, Long> colNIK;

    @FXML
    private TableColumn<Individu, Long> colNPWP;

    @FXML
    private TableColumn<Individu, Integer> colJumAkunIndividu;

    @FXML
    private TableView<Rekening> tblRekeningIndividu;

    @FXML
    private TableColumn<Rekening, Integer> colNumRekIndividu;

    @FXML
    private TableColumn<Rekening, Double> colSaldoIndividu;

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
    private Label lblAddStatusPerusahaan;

    @FXML
    private TableView<Perusahaan> tblDataPerusahaan;

    @FXML
    private TableColumn<Perusahaan, Integer> colIDPerusahaan;

    @FXML
    private TableColumn<Perusahaan, String> colNamaPerusahaan;

    @FXML
    private TableColumn<Perusahaan, String> colAlamatPerusahaan;

    @FXML
    private TableColumn<Perusahaan, String> colNIB;

    @FXML
    private TableColumn<Perusahaan, Integer> colJumAkunPerusahaan;

    @FXML
    private TableView<Rekening> tblRekeningPerusahaan;

    @FXML
    private TableColumn<Rekening, Integer> colNumRekPerusahaan;

    @FXML
    private TableColumn<Rekening, Double> colSaldoPerusahaan;

    @FXML
    private TextField tfIDNasabahBaruPerusahaan;

    @FXML
    private TextField tfNoRekBaruPerusahaan;

    @FXML
    private TextField tfSaldoRekBaruPerusahaan;

    @FXML
    private Button btnTambahRekBaruPerusahaan;

    @FXML
    private Label lblDBStatus;

    private NasabahDataModel nadamod;

    @FXML
    void handleHapusIndividual(ActionEvent event) throws SQLException {
        tfIDIndividual.setText("" + nadamod.nextNasabahID());
        tfNoRekIndividual.setText(tfIDIndividual.getText() + "01");
        tfNamaIndividual.setText("");
        tfAlamatIndividual.setText("");
        tfNIKIndividual.setText("");
        tfNPWPIndividual.setText("");
        tfSaldoRekIndividual.setText("");
    }

    @FXML
    void handleHapusPerusahaan(ActionEvent event) {

    }

    @FXML
    void handlePerbaruiTabelIndividual(ActionEvent event) {
        ObservableList<Individu> data = nadamod.getIndividu();
        colIDIndividu.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNamaIndividu.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colAlamatIndividu.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        colNIK.setCellValueFactory(new PropertyValueFactory<>("nik"));
        colNPWP.setCellValueFactory(new PropertyValueFactory<>("npwp"));
        colJumAkunIndividu.setCellValueFactory(new PropertyValueFactory<>("rekNum"));
        tblDataIndividu.setItems(null);
        tblDataIndividu.setItems(data);
        btnTambahRekBaruIndividual.setDisable(true);
        lblAddStatusindividual.setText("");
    }

    @FXML
    void handlePerbaruiTabelPerusahaan(ActionEvent event) {

    }

    @FXML
    void handleTambahNasabahIndividual(ActionEvent event) {
        Individu individu = new Individu(
                Integer.parseInt(tfIDIndividual.getText()),
                tfNamaIndividual.getText(),
                tfAlamatIndividual.getText(),
                Long.parseLong(tfNIKIndividual.getText()),
                Long.parseLong(tfNPWPIndividual.getText()),
                new Rekening(Integer.parseInt(tfNoRekIndividual.getText()),
                        Double.parseDouble(tfSaldoRekIndividual.getText()))
        );

        try {
            nadamod.addIndvidual(individu);
            btnPerbaruiIndividual.fire();
            btnHapusIndividual.fire();
            lblAddStatusindividual.setText("Akun Sukses Dibuat!");
        } catch (Exception e) {
            lblAddStatusindividual.setText("Akun Gagal Dibuat!");
        }
    }

    @FXML
    void handleTambahNasabahPerusahaan(ActionEvent event) {

    }

    @FXML
    void handleTambahRekBaruIndividual(ActionEvent event) throws SQLException{
        Rekening rekening = new Rekening(Integer.parseInt(tfNoRekBaruIndividual.getText()),
                Double.parseDouble(tfSaldoRekBaruIndividual.getText()));
        nadamod.addRekening(Integer.parseInt(tfIDNasabahBaruIndividual.getText()), rekening);
        btnPerbaruiIndividual.fire();
        tfSaldoRekBaruIndividual.setText("");
        lihatDataRekeningIndividu(Integer.parseInt(tfIDNasabahBaruIndividual.getText()));
    }

    @FXML
    void handleTambahRekBaruPerusahaan(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            nadamod = new NasabahDataModel();
            lblDBStatus.setText(nadamod.connection == null ? "Not Connected" : "Connected");
            btnHapusIndividual.fire();
            btnPerbaruiIndividual.fire();
        } catch (Exception es) {
            System.out.println("Error");
        }

        tblDataIndividu.getSelectionModel().selectedIndexProperty().addListener(listener -> {
            if (tblDataIndividu.getSelectionModel().getSelectedItem() != null) {
                Individu individu =tblDataIndividu.getSelectionModel().getSelectedItem();
                lihatDataRekeningIndividu(individu.getId());
                btnTambahRekBaruIndividual.setDisable(false);
                tfIDNasabahBaruIndividual.setText("" + individu.getId());
                try {
                    tfNoRekBaruIndividual.setText("" + nadamod.nextNoRekening(individu.getId()));
                } catch (Exception ex) {
                    System.out.println("Gagal load data rekening");
                }
            }
        });

    }

    public void lihatDataRekeningIndividu(int id) {
        ObservableList<Rekening> data = nadamod.getRekening(id);
        colNumRekIndividu.setCellValueFactory(new PropertyValueFactory<>("noRekening"));
        colSaldoIndividu.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        tblRekeningIndividu.setItems(null);
        tblRekeningIndividu.setItems(data);
    }
}
