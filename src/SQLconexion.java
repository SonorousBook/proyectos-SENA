import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLconexion {
    public static Connection connect() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/technical_visit";
        String user = "root";
        String password = "HALLOWEENf1r3w0rk*";

        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println("            ¡Conexion Exitosa! :D");
        return connection;

    }
}
