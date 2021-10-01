package finalprojectpbo.database;

import java.sql.*;


public class DBHelper {
//    private static final String dbURL = "jdbc:sqlite:D:\\Java\\FinalProject\\FinalProject_KMMI_PBO\\FinalProjectPBO\\src\\finalprojectpbo\\database\\Koperasi.db";
    private static final String dbURL = "jdbc:sqlite:src\\finalprojectpbo\\database\\Koperasi.db";
    public static Connection getConnection(){
        Connection connection;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(dbURL);
            System.out.println("Connected");
            creatTable(connection);
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

    public static void creatTable(Connection connection){
        String sql = "CREATE TABLE IF NOT EXISTS Nasabah (" +
                "    id_nasabah INT (20)      PRIMARY KEY," +
                "    nama       VARCHAR (50)," +
                "    alamat     VARCHAR (100) " +
                ");" +
                "CREATE TABLE IF NOT EXISTS individual (" +
                "    id_nasabah INT (20) PRIMARY KEY" +
                "                        REFERENCES Nasabah (id_nasabah) ON DELETE RESTRICT" +
                "                                                        ON UPDATE CASCADE," +
                "    nik        INT," +
                "    npwp       INT" +
                ");" +
                "CREATE TABLE IF NOT EXISTS perusahaan (" +
                "    id_nasabah INT (20)     PRIMARY KEY" +
                "                            REFERENCES Nasabah (id_nasabah) ON DELETE RESTRICT" +
                "                                                            ON UPDATE CASCADE," +
                "    nib        VARCHAR (50) " +
                ");" +
                "CREATE TABLE IF NOT EXISTS Rekening (" +
                "    noRekening INT (20) PRIMARY KEY," +
                "    saldo      DOUBLE," +
                "    id_nasabah INT (20) REFERENCES Nasabah (id_nasabah) ON DELETE RESTRICT" +
                "                                                        ON UPDATE CASCADE" +
                ");";
        try{
            String[] sqls = sql.split(";");
            for (String sfor : sqls){
                PreparedStatement preparedStatement = connection.prepareStatement(sfor);
                preparedStatement.execute();
            }

        }catch (SQLException E){
            System.out.println(E);
        }
    }
}
