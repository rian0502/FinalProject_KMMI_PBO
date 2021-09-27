package finalprojectpbo.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class NasabahDataModel {
    private  Connection connection ;

    public NasabahDataModel() {
        this.connection = DBHelper.getConnetion();
    }
    public void addIndvidual(){
        try {
            String sqlNasabah = "insert into nasabah(id_nasabah,nama,alamat) values "+"(?,?,?)";
            String sqlIndividual = "insert into individual(id_nasabah,nik,npwp) values "+"(?,?,?)";
            String sqlRekening = "inser into rekening(noRekening,balance,id_nasabah) values "+ "(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlNasabah);

        }catch (SQLException X){
            System.out.println(X);
        }
    }
    public void addPerusahaan(){
        try {
            String sqlNasabah = "insert into nasabah(id_nasabah,nama,alamat) values "+"(?,?,?)";
            String sqlIndividual = "insert into perusahaan(id_nasabah,nib) values "+"(?,?,?)";
            String sqlRekening = "inser into rekening(noRekening,balance,id_nasabah) values "+ "(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlNasabah);

        }catch (SQLException X){
            System.out.println(X);
        }
    }
}
