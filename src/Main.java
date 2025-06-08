import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.*;
import java.sql.Timestamp;   // Para manejar fechas y horas (timestamp)


public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner lectorEntrada = new Scanner(System.in);

        System.out.println("=== REGISTRAR NUEVO USUARIO ===");

        System.out.print("Ingrese el ID del usuario: ");
        int idUsuario = lectorEntrada.nextInt();
        lectorEntrada.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese el nombre de usuario: ");
        String nombreUsuario = lectorEntrada.nextLine();

        System.out.print("Ingrese la contraseña: ");
        String contrasena = lectorEntrada.nextLine();

        System.out.print("Ingrese el rol: ");
        String rol = lectorEntrada.nextLine();

        System.out.print("Ingrese el Nombre Completo: ");
        String nombre = lectorEntrada.nextLine();

        System.out.print("Ingrese el Teléfono: ");
        String telefono = lectorEntrada.nextLine();

        System.out.print("Ingrese el Correo Electrónico: ");
        String correoElectronico = lectorEntrada.nextLine();

        System.out.print("Ingrese el Número de Identificación: ");
        String numeroIdentificacion = lectorEntrada.nextLine();

        // Por defecto: estadoUsuario es 'Activo'
        System.out.print("Ingrese el estado (Activo/Inactivo): ");
        String estadoUsuario = lectorEntrada.nextLine();


        // Crear el objeto Usuario
        Usuario objUsuario = new Usuario(idUsuario, nombreUsuario, contrasena, rol, nombre, telefono, correoElectronico, numeroIdentificacion, estadoUsuario);

        // Crear el objeto de la conexión
        System.out.println();
        Connection connection = SQLconexion.connect();
        System.out.println();
        // Crear el objeto para insertar datos
        UsuarioCRUD objUsuarioCRUD = new UsuarioCRUD();

        // Insertar los datos
        objUsuarioCRUD.insertarUsuario(objUsuario, connection);
        System.out.println();
        System.out.println("  Usuario registrado exitosamente.");

        // Llamar método BUSCAR Usuario
        System.out.println("******* TABLA DE USUARIOS ********");
        System.out.println();
        objUsuarioCRUD.buscarUsuario(connection);
        System.out.println();

        System.out.println("======== ACTUALIZAR DATOS USUARIO ========");
        System.out.println();
        System.out.print("Ingrese el ID del usuario a actualizar: ");
        int idActualizar = lectorEntrada.nextInt();
        lectorEntrada.nextLine(); // Limpiar buffer

        List<String> campos = new ArrayList<>();
        List<String> valores = new ArrayList<>();

        // Preguntas dinámicas para cada campo
        System.out.print("¿Desea actualizar nombre de Usuario? (s/n): ");
        if (lectorEntrada.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Ingrese nombre de Usuario: ");
            campos.add("nombreUsuario");
            valores.add(lectorEntrada.nextLine());
        }

        System.out.print("¿Desea actualizar la contraseña? (s/n): ");
        if (lectorEntrada.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Ingrese Nueva contrasena: ");
            campos.add("contrasena");
            valores.add(lectorEntrada.nextLine());
        }

        System.out.print("¿Desea actualizar el rol? (s/n): ");
        if (lectorEntrada.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Ingrese Nuevo rol (Tecnico/Analista/Administrador/Sysadmin): ");
            campos.add("rol");
            valores.add(lectorEntrada.nextLine());
        }

        System.out.print("¿Desea actualizar su nombre? (s/n): ");
        if (lectorEntrada.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Ingrese nombre: ");
            campos.add("nombre");
            valores.add(lectorEntrada.nextLine());
        }

        System.out.print("¿Desea actualizar su No. de telefono? (s/n): ");
        if (lectorEntrada.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Ingrese Nuevo No. de telefono: ");
            campos.add("telefono");
            valores.add(lectorEntrada.nextLine());
        }

        System.out.print("¿Desea actualizar el correo Electronico? (s/n): ");
        if (lectorEntrada.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Ingrese Nuevo correo Electronico: ");
            campos.add("correoElectronico");
            valores.add(lectorEntrada.nextLine());
        }

        System.out.print("¿Desea actualizar estado de Usuario? (s/n): ");
        if (lectorEntrada.nextLine().equalsIgnoreCase("s")) {
            System.out.print("Ingrese Nuevo estado de Usuario (Activo/Inactivo): ");
            campos.add("estadoUsuario");
            valores.add(lectorEntrada.nextLine());
        }

        // Ejecutar actualización si hay al menos un campo
        if (campos.isEmpty()) {
            System.out.println("No se seleccionaron campos para actualizar.");
        } else {
            objUsuarioCRUD.actualizarUsuario(idActualizar, campos, valores, connection);
        }

        // Llamar método BUSCAR Usuario Actualizado
        System.out.println("******* TABLA DE USUARIOS ********");
        System.out.println();
        objUsuarioCRUD.buscarUsuario(connection);


        // ************ Método eliminar ***************************
        System.out.println("\nPRUEBA ELIMINAR REGISTRO USUARIO");
        System.out.println();
        System.out.print("Ingrese el ID del usuario para eliminar: ");
        int idEliminar = lectorEntrada.nextInt();
        lectorEntrada.nextLine(); // Limpia el buffer del scanner
        // Llamar al método eliminar
        objUsuarioCRUD.eliminarUsuario(idEliminar, connection);

        // Llamar método BUSCAR Usuario Actualizado
        System.out.println("******* TABLA DE USUARIOS ********");
        System.out.println();
        objUsuarioCRUD.buscarUsuario(connection);

        connection.close();
    }
}
