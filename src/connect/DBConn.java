
package connect;

import java.sql.Connection;
public class DBConn {

    private String Drivers, ServerName, Port, DatabaseName, Username, Password;
    private Connection conn = null;
    public static java.sql.Connection Connection = null;

    private String getConnectionUrl() {
        return Drivers + ServerName + ":" + Port + ";databaseName=" + DatabaseName + ";";
    }
    //JTDS
    public java.sql.Connection getConnection() {
        try {
            readJTDS();
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            conn = java.sql.DriverManager.getConnection(getConnectionUrl(), Username, Password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    private void readJTDS() {
        Drivers = "jdbc:jtds:sqlserver://";
        ServerName = "192.168.2.11";
        Port = "1433";
        DatabaseName = "SUSAPP_SUST";       
        Username = "sa";
        Password = "Information@";
    }

}
