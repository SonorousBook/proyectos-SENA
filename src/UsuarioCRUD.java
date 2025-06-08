import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsuarioCRUD {
    //Definir métodos CRUD
    public void insertarUsuario(Usuario usuario, Connection connection) throws SQLException {
        String instructionStorage = "INSERT INTO usuario (idUsuario, nombreUsuario, contrasena, rol, nombre, telefono, correoElectronico, numeroIdentificacion, estadoUsuario) VALUES (?,?,?,?,?,?,?,?,?);";
        PreparedStatement statement = connection.prepareStatement(instructionStorage);

        //Se cargan los valores(Sustituye cada interrogacion), se escoge tipo de dato, luego se escoge el numero del parametro, el objeto de donde se obtiene con la funcion para obtener el dato
        statement.setInt(1,usuario.getIdUsuario());
        statement.setString(2,usuario.getNombreUsuario());
        statement.setString(3,usuario.getContrasena());
        statement.setString(4,usuario.getRol());
        statement.setString(5,usuario.getNombre());
        statement.setString(6,usuario.getTelefono());
        statement.setString(7,usuario.getCorreoElectronico());
        statement.setString(8,usuario.getNumeroIdentificacion());
        statement.setString(9,usuario.getEstadoUsuario());

        statement.executeUpdate();
        statement.close();

    }

    public void buscarUsuario(Connection connection) throws SQLException {
        String searchIntruction = "SELECT idUsuario, nombreUsuario, contrasena, rol, nombre, telefono, correoElectronico, numeroIdentificacion, estadoUsuario FROM usuario ORDER BY idUsuario ASC;";
        PreparedStatement statement = connection.prepareStatement(searchIntruction);

        ResultSet resultSet = statement.executeQuery();

        // Encabezados de la tabla
        System.out.printf("%-10s %-15s %-21s %-15s %-30s %-15s %-25s %-20s %-10s%n",
                "ID", "Usuario", "Contraseña", "Rol", "Nombre", "Teléfono", "Correo", "Identificación", "Estado");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        // Iterar sobre los resultados
        while (resultSet.next()){
            int idUsuario =resultSet.getInt("idUsuario");
            String nombreUsuario =resultSet.getNString("nombreUsuario");
            String contrasena =resultSet.getNString("contrasena");
            String rol =resultSet.getNString("rol");
            String nombre =resultSet.getNString("nombre");
            String telefono =resultSet.getNString("telefono");
            String correoElectronico =resultSet.getNString("correoElectronico");
            String numeroIdentificacion =resultSet.getNString("numeroIdentificacion");
            String estadoUsuario =resultSet.getNString("estadoUsuario");

            // Imprimir cada fila como una tabla
            System.out.printf("%-10d %-15s %-21s %-15s %-30s %-15s %-25s %-20s %-10s%n", idUsuario, nombreUsuario, contrasena, rol, nombre, telefono, correoElectronico, numeroIdentificacion, estadoUsuario);
        }

        // Cerrar recursos
        resultSet.close();
        statement.close();
    }

    public void actualizarUsuario(int idUsuario, List<String> campos, List<String> valores, Connection connection) throws SQLException {

        // 1. Construir el SQL dinámico
        StringBuilder sql = new StringBuilder("UPDATE Usuario SET ");
        for (int i = 0; i < campos.size(); i++) {
            sql.append(campos.get(i)).append(" = ?");
            if (i < campos.size() - 1) {
                sql.append(", ");
            }
        }
        sql.append(" WHERE idUsuario = ?");

        // 2. Preparar el statement
        PreparedStatement statement = connection.prepareStatement(sql.toString());

        // 3. Asignar valores a los parámetros
        for (int i = 0; i < valores.size(); i++) {
            statement.setString(i + 1, valores.get(i));
        }
        statement.setInt(valores.size() + 1, idUsuario);

        // 4. Ejecutar la actualización
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("\n✅ Usuario actualizado exitosamente.");
        } else {
            System.out.println("\n⚠️ No se encontró el usuario para actualizar.");
        }

        statement.close();
    }

      public void eliminarUsuario(int idUsuario, Connection connection) throws SQLException {
        String eliminarSQL = "DELETE FROM Usuario WHERE idUsuario = ?";

        PreparedStatement statement = connection.prepareStatement(eliminarSQL);
        statement.setInt(1, idUsuario); // Bind del id

        int filasAfectadas = statement.executeUpdate(); // Ejecuta la eliminación
        if (filasAfectadas > 0) {
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("No se encontró el usuario con ese ID.");
        }

        statement.close(); // Cierra el recurso
    }
}
