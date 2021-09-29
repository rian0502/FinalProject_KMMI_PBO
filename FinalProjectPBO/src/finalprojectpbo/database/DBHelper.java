package finalprojectpbo.database;

import java.sql.*;


public class DBHelper {
//    private static final String dbURL = "jdbc:sqlite:D:\\Java\\FinalProject\\FinalProject_KMMI_PBO\\FinalProjectPBO\\src\\finalprojectpbo\\database\\Koperasi.db";
    private static final String dbURL = "jdbc:sqlite:src\\finalprojectpbo\\database\\Koperasi.db";
    public static Connection getConnetion(){
        Connection connection;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(dbURL);
            System.out.println("Connected");
        }catch (ClassNotFoundException ex){
            System.out.println(ex);
            System.out.println("Kelas Tidak ditemukan");
            connection = null;
        }catch (SQLException e){
            System.out.println(e);
            System.out.println("Koneksi gagal");
            connection = null;
        }
        return connection;
    }
}
