import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Driver;

public class Connect {
    private Connection conn;

    public Connect(){
        conn = null;
    }

    public void connecting(){
        String connectStr = "jdbc:mariadb://localhost:3306/diakdu_konyv?user=diakdu&password=123";

        try {
            Driver dr =DriverManager.getDriver(connectStr);
            conn = dr.connect(connectStr, null);
        } catch (SQLException e) {
            System.out.println("Hiba a kapcsolódás során\n" + e.getMessage());
            //e.printStackTrace();
        }

        /*if (conn != null) {
            System.out.println("Ok");
        } else {
            System.out.println("Nincs kapcsolat");
        }*/
    }

    public Connection getConnection(){return conn;}
}
