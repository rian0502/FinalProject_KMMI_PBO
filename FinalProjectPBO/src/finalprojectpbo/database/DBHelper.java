package finalprojectpbo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static final String dbURL = "D:\\Java\\FinalProject\\FinalProject_KMMI_PBO\\FinalProjectPBO\\src\\finalprojectpbo\\database\\Koperasi.db";

    public static Connection getConnetion(){
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(dbURL);
            System.out.println("Connected");
        }catch (ClassNotFoundException ex){
            System.out.println(ex);
            System.out.println("Kelas Tidak ditemukan");
        }catch (SQLException e){
            System.out.println(e);
            System.out.println("Koneksi gagal");
        }
        return connection;
    }
}
