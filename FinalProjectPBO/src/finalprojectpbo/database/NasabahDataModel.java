package finalprojectpbo.database;

import finalprojectpbo.Individu;
import finalprojectpbo.Perusahaan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class NasabahDataModel {
    private  Connection connection ;

    public NasabahDataModel() {
        this.connection = DBHelper.getConnetion();
    }
    public void addIndvidual(Individu individu){

        try {
            String sqlNasabah = "insert into nasabah(id_nasabah,nama,alamat) values "+"(?,?,?)";
            String sqlIndividual = "insert into individual(id_nasabah,nik,npwp) values "+"(?,?,?)";
            String sqlRekening = "inser into rekening(noRekening,balance,id_nasabah) values "+ "(?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlNasabah);
            preparedStatement.setInt(1,individu.getId());
            preparedStatement.setString(2,individu.getNama());
            preparedStatement.setString(3,individu.getAlamat());
            preparedStatement.execute();

            PreparedStatement preparedIndividual = connection.prepareStatement(sqlNasabah);
            preparedIndividual.setInt(1,individu.getId());
            preparedIndividual.setLong(2,individu.getNik());
            preparedIndividual.setLong(3,individu.getNpwp());
            preparedIndividual.execute();

            PreparedStatement preparedRekening = connection.prepareStatement(sqlRekening);
            preparedRekening.setInt(1,individu.getRekening().get(0).getNoRekening());
            preparedRekening.setDouble(2,individu.getRekening().get(0).getSaldo());
            preparedRekening.setInt(3,individu.getId());
            preparedRekening.execute();

        }catch (SQLException X){
            System.out.println(X);
        }
    }
    public void addPerusahaan(Perusahaan perusahaan){
        try {
            String sqlNasabah = "insert into nasabah(id_nasabah,nama,alamat) values "+"(?,?,?)";
            String sqlIPerusahaan = "insert into perusahaan(id_nasabah,nib) values "+"(?,?)";
            String sqlRekening = "inser into rekening(noRekening,balance,id_nasabah) values "+ "(?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlNasabah);
            preparedStatement.setInt(1,perusahaan.getId());
            preparedStatement.setString(2,perusahaan.getNama());
            preparedStatement.setString(3,perusahaan.getAlamat());
            preparedStatement.execute();

            PreparedStatement preparedPerusahaan = connection.prepareStatement(sqlIPerusahaan);
            preparedPerusahaan.setInt(1,perusahaan.getId());
            preparedPerusahaan.setString(2,perusahaan.getNib());
            preparedPerusahaan.execute();

            PreparedStatement preparedRekening = connection.prepareStatement(sqlRekening);
            preparedRekening.setInt(1,perusahaan.getRekening().get(0).getNoRekening());
            preparedRekening.setDouble(2,perusahaan.getRekening().get(0).getSaldo());
            preparedRekening.setInt(3,perusahaan.getId());
            preparedRekening.execute();

        }catch (SQLException X){
            System.out.println(X);
        }
    }
}
