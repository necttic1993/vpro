package Conexion_DB;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;
//import org.apache.commons.dbcp2.BasicDataSource;

public class conectar {

    ////hosting 
    /*
     private final String DB = "manumora_necttic";
     private final String USER = "manumora_system";
     private final String URL = "jdbc:mysql://108.167.140.233:3306/" + DB + "?autoReconnect=true";
     private final String PASS = "canis";

     */
    private final String DB = "necttic";
    private final String USER = "system";
   // private final String URL = "jdbc:mysql://localhost:3306/" + DB + "?autoReconnect=true&useCompresion=true";
   // private final String PASS = "canis";

    //kyrios
   //  private final String URL = "jdbc:mysql://192.168.0.8:3306/" + DB + "?autoReconnect=true&useCompresion=true";
   //  private final String PASS = "NectticKyrios1993@";
    //gabaon
      private final String URL = "jdbc:mysql://192.168.1.200:3306/" + DB + "?autoReconnect=true&useCompresion=true";
      private final String PASS = "NectticGabaon1993@";
    //freccia
    //  private final String URL = "jdbc:mysql://192.168.100.138:3306/" + DB + "?autoReconnect=true&useCompresion=true";
    //  private final String PASS = "canis";
    //all you need
      //private final String URL = "jdbc:mysql://192.168.100.100:3306/" + DB + "?autoReconnect=true&useCompresion=true";
     // private final String PASS = "canis";
    private static conectar dataSource;
    private BasicDataSource basicDataSource = null;

    private conectar() {

        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);
        basicDataSource.setUrl(URL);
        basicDataSource.setMaxTotal(1000);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxWaitMillis(10 * 1000l);
        //basicDataSource.setMaxWaitMillis(-1);

    }

    public static conectar getInstance() {
        if (dataSource == null) {
            dataSource = new conectar();
            return dataSource;
        } else {
            return dataSource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.basicDataSource.getConnection();
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
