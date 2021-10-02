/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectpbo.controller;

import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.PreparedStatement;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.xml.ws.Holder;


public class viewController implements Initializable {
    @FXML
    private MenuItem btnHelp;

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
    private TextField tfRekeningDipilihIndividual;

    @FXML
    private TextField tfNominalIndividual;

    @FXML
    private Button btnTarikTunaiIndividual;

    @FXML
    private Button btnTambahSaldoIndividual;

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
    private TextField tfRekeningDipilihPerusahaan;

    @FXML
    private TextField tfNominalPerusahaan;

    @FXML
    private Button btnTarikTunaiPerusahaan;

    @FXML
    private Button btnTambahSaldoPerusahaan;

    @FXML
    private Label lblDBStatus;

    @FXML
    private Label lblTarikTambahIndividu;

    @FXML
    private Label lblTambahTarikPerusahaan;

    private NasabahDataModel nadamod;

    private Rekening globalRekening; //Untuk tambah/tarik saldo

    @FXML
    void handleButtonHelp(ActionEvent event) { //Ke github
        Desktop desktop = java.awt.Desktop.getDesktop();
        try {
            //specify the protocol along with the URL
            URI oURL = new URI(
                    "https://github.com/rian0502/FinalProject_KMMI_PBO");
            desktop.browse(oURL);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void handleHapusIndividual(ActionEvent event) throws SQLException {
        tfIDIndividual.setText("" + nadamod.nextNasabahID());
        tfNoRekIndividual.setText(tfIDIndividual.getText() + "01");
        tfNamaIndividual.setText("");
        tfAlamatIndividual.setText("");
        tfNIKIndividual.setText("");
        tfNPWPIndividual.setText("");
        tfSaldoRekIndividual.setText("");
        tfSaldoRekBaruIndividual.setText("");
        tfNominalIndividual.setText("");
    }

    @FXML
    void handleHapusPerusahaan(ActionEvent event) throws SQLException {
        tfIDPerusahaan.setText("" + nadamod.nextNasabahID());
        tfNoRekPerusahaan.setText(tfIDIndividual.getText() + "01");
        tfNamaPerusahaan.setText("");
        tfAlamatPerusahaan.setText("");
        tfNIBPerusahaan.setText("");
        tfSaldoPerusahaan.setText("");
        tfSaldoRekBaruPerusahaan.setText("");
        tfNominalPerusahaan.setText("");
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
        btnTambahSaldoIndividual.setDisable(true);
        btnTarikTunaiIndividual.setDisable(true);
        tfNominalIndividual.setDisable(true);
        tfSaldoRekBaruIndividual.setDisable(true);
        lblAddStatusindividual.setText("");
        tblRekeningIndividu.setItems(null);
        lblTarikTambahIndividu.setText("");
        btnHapusIndividual.fire();
    }

    @FXML
    void handlePerbaruiTabelPerusahaan(ActionEvent event) {
        ObservableList<Perusahaan> data = nadamod.getPerusahaan();
        colIDPerusahaan.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNamaPerusahaan.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colAlamatPerusahaan.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        colNIB.setCellValueFactory(new PropertyValueFactory<>("nib"));
        colJumAkunPerusahaan.setCellValueFactory(new PropertyValueFactory<>("rekNum"));
        tblDataPerusahaan.setItems(null);
        tblDataPerusahaan.setItems(data);
        btnTambahRekBaruPerusahaan.setDisable(true);
        btnTambahSaldoPerusahaan.setDisable(true);
        btnTarikTunaiPerusahaan.setDisable(true);
        tfSaldoRekBaruPerusahaan.setDisable(true);
        tfNominalPerusahaan.setDisable(true);
        lblAddStatusPerusahaan.setText("");
        tblRekeningPerusahaan.setItems(null);
        lblTambahTarikPerusahaan.setText("");
        btnHapusPerusahaan.fire();
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
        Perusahaan perusahaan = new Perusahaan(
                Integer.parseInt(tfIDPerusahaan.getText()),
                tfNamaPerusahaan.getText(),
                tfAlamatPerusahaan.getText(),
                tfNIBPerusahaan.getText(),
                new Rekening(Integer.parseInt(tfNoRekPerusahaan.getText()),
                        Double.parseDouble(tfSaldoPerusahaan.getText()))
        );

        try {
            nadamod.addPerusahaan(perusahaan);
            btnPerbaruiPerusahaan.fire();
            btnHapusPerusahaan.fire();
            lblAddStatusPerusahaan.setText("Akun Sukses Dibuat!");
        } catch (Exception e) {
            lblAddStatusPerusahaan.setText("Akun Gagal Dibuat!");
        }
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
    void handleTambahRekBaruPerusahaan(ActionEvent event) throws SQLException{
        Rekening rekening = new Rekening(Integer.parseInt(tfNoRekBaruPerusahaan.getText()),
                Double.parseDouble(tfSaldoRekBaruPerusahaan.getText()));
        nadamod.addRekening(Integer.parseInt(tfIDNasabahBaruPerusahaan.getText()), rekening);
        btnPerbaruiPerusahaan.fire();
        tfSaldoRekBaruPerusahaan.setText("");
        lihatDataRekeningPerusahaan(Integer.parseInt(tfIDNasabahBaruPerusahaan.getText()));
    }

    @FXML
    void handleTambahSaldoIndividual(ActionEvent event) throws SQLException {
        globalRekening.tambahSaldo(Double.parseDouble(tfNominalIndividual.getText()));
//        Double saldoBaru = globalRekening.getSaldo() + Double.parseDouble(tfNominalIndividual.getText());
        String tambahSaldo = "UPDATE Rekening SET saldo = " + globalRekening.getSaldo()
                + " WHERE noRekening = " + globalRekening.getNoRekening();
        PreparedStatement preparedSaldoBaru = nadamod.connection.prepareStatement(tambahSaldo);
        preparedSaldoBaru.execute();
        preparedSaldoBaru.close();
        btnPerbaruiIndividual.fire();
        btnHapusIndividual.fire();
        lihatDataRekeningIndividu(Integer.parseInt(tfIDNasabahBaruIndividual.getText()));
        lblTarikTambahIndividu.setText("Berhasil!");
    }

    @FXML
    void handleTarikTunaiIndividual(ActionEvent event) throws SQLException {
        if (globalRekening.getSaldo() < Double.parseDouble(tfNominalIndividual.getText())) {
            lblTarikTambahIndividu.setText("Saldo Kurang");
        } else {
            globalRekening.tarikTunai(Double.parseDouble(tfNominalIndividual.getText()));
//            Double saldoBaru = globalRekening.getSaldo() - Double.parseDouble(tfNominalIndividual.getText());
            String tarikTunai = "UPDATE Rekening SET saldo = " + globalRekening.getSaldo()
                    + " WHERE noRekening = " + globalRekening.getNoRekening();
            PreparedStatement preparedSaldoBaru = nadamod.connection.prepareStatement(tarikTunai);
            preparedSaldoBaru.execute();
            preparedSaldoBaru.close();
            btnPerbaruiIndividual.fire();
            btnHapusIndividual.fire();
            lihatDataRekeningIndividu(Integer.parseInt(tfIDNasabahBaruIndividual.getText()));
            lblTarikTambahIndividu.setText("Berhasil!");
        }
    }

    @FXML
    void handleTambahSaldoPerusahaan(ActionEvent event) throws SQLException{
        globalRekening.tambahSaldo(Double.parseDouble(tfNominalPerusahaan.getText()));
//        Double saldoBaru = globalRekening.getSaldo() + Double.parseDouble(tfNominalPerusahaan.getText());
        String tambahSaldo = "UPDATE Rekening SET saldo = " + globalRekening.getSaldo()
                + " WHERE noRekening = " + globalRekening.getNoRekening();
        PreparedStatement preparedSaldoBaru = nadamod.connection.prepareStatement(tambahSaldo);
        preparedSaldoBaru.execute();
        preparedSaldoBaru.close();
        btnPerbaruiPerusahaan.fire();
        btnHapusPerusahaan.fire();
        lihatDataRekeningPerusahaan(Integer.parseInt(tfIDNasabahBaruPerusahaan.getText()));
        lblTambahTarikPerusahaan.setText("Berhasil!");
    }

    @FXML
    void handleTarikTunaiPerusahaan(ActionEvent event) throws SQLException{
        if (globalRekening.getSaldo() < Double.parseDouble(tfNominalPerusahaan.getText())) {
            lblTarikTambahIndividu.setText("Saldo Kurang");
        } else {
            globalRekening.tarikTunai(Double.parseDouble(tfNominalPerusahaan.getText()));
//            Double saldoBaru = globalRekening.getSaldo() - Double.parseDouble(tfNominalPerusahaan.getText());
            String tarikTunai = "UPDATE Rekening SET saldo = " + globalRekening.getSaldo()
                    + " WHERE noRekening = " + globalRekening.getNoRekening();
            PreparedStatement preparedSaldoBaru = nadamod.connection.prepareStatement(tarikTunai);
            preparedSaldoBaru.execute();
            preparedSaldoBaru.close();
            btnPerbaruiPerusahaan.fire();
            btnHapusPerusahaan.fire();
            lihatDataRekeningPerusahaan(Integer.parseInt(tfIDNasabahBaruPerusahaan.getText()));
            lblTambahTarikPerusahaan.setText("Berhasil!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            nadamod = new NasabahDataModel();
            lblDBStatus.setText(nadamod.connection == null ? "Not Connected" : "Connected");
            btnHapusIndividual.fire();
            btnPerbaruiIndividual.fire();
            btnHapusPerusahaan.fire();
            btnPerbaruiPerusahaan.fire();
        } catch (Exception es) {
            System.out.println("Error");
        }

        //Klik data di table akun individu
        tblDataIndividu.getSelectionModel().selectedIndexProperty().addListener(listener -> {
            if (tblDataIndividu.getSelectionModel().getSelectedItem() != null) {
                Individu individu =tblDataIndividu.getSelectionModel().getSelectedItem();
                individu.print();
                lihatDataRekeningIndividu(individu.getId());
                btnTambahRekBaruIndividual.setDisable(false);
                tfSaldoRekBaruIndividual.setDisable(false);
                tfIDNasabahBaruIndividual.setText("" + individu.getId());
                try {
                    tfNoRekBaruIndividual.setText("" + nadamod.nextNoRekening(individu.getId()));
                } catch (Exception ex) {
                    System.out.println("Gagal load data rekening");
                }
            }
        });

        //Klik data di tabel akun perusahaan
        tblDataPerusahaan.getSelectionModel().selectedIndexProperty().addListener(listener -> {
            if (tblDataPerusahaan.getSelectionModel().getSelectedItem() != null) {
                Perusahaan perusahaan = tblDataPerusahaan.getSelectionModel().getSelectedItem();
                perusahaan.print();
                lihatDataRekeningPerusahaan(perusahaan.getId());
                btnTambahRekBaruPerusahaan.setDisable(false);
                tfSaldoRekBaruPerusahaan.setDisable(false);
                tfIDNasabahBaruPerusahaan.setText("" + perusahaan.getId());
                try {
                    tfNoRekBaruPerusahaan.setText("" + nadamod.nextNoRekening(perusahaan.getId()));
                } catch (Exception ex) {
                    System.out.println("Gagal load data rekening");
                }
            }
        });

        //Klik data di rekening individu
        tblRekeningIndividu.getSelectionModel().selectedIndexProperty().addListener(listener -> {
            if (tblRekeningIndividu.getSelectionModel().getSelectedItem() != null) {
                globalRekening = tblRekeningIndividu.getSelectionModel().getSelectedItem();
                btnTarikTunaiIndividual.setDisable(false);
                btnTambahSaldoIndividual.setDisable(false);
                tfNominalIndividual.setDisable(false);
                tfRekeningDipilihIndividual.setText("" + globalRekening.getNoRekening());
            }
        });

        //Klik data di rekening perusahaan
        tblRekeningPerusahaan.getSelectionModel().selectedIndexProperty().addListener(listener -> {
            if (tblRekeningPerusahaan.getSelectionModel().getSelectedItem() != null) {
                globalRekening = tblRekeningPerusahaan.getSelectionModel().getSelectedItem();
                btnTarikTunaiPerusahaan.setDisable(false);
                btnTambahSaldoPerusahaan.setDisable(false);
                tfNominalPerusahaan.setDisable(false);
                tfRekeningDipilihPerusahaan.setText("" + globalRekening.getNoRekening());
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

    public void lihatDataRekeningPerusahaan(int id) {
        ObservableList<Rekening> data = nadamod.getRekening(id);
        colNumRekPerusahaan.setCellValueFactory(new PropertyValueFactory<>("noRekening"));
        colSaldoPerusahaan.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        tblRekeningPerusahaan.setItems(null);
        tblRekeningPerusahaan.setItems(data);
    }
}
