public class Cliente {

    private String NIT_Cliente;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private String tipoCliente;

    // Constructor vacío
    public Cliente() {
    }

    // Constructor con todos los parámetros
    public Cliente(String NIT_Cliente, String nombre, String direccion, String telefono, String correoElectronico, String tipoCliente) {
        this.NIT_Cliente = NIT_Cliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.tipoCliente = tipoCliente;
    }

    // Getters y Setters
    public String getNIT_Cliente() {
        return NIT_Cliente;
    }

    public void setNIT_Cliente(String NIT_Cliente) {
        this.NIT_Cliente = NIT_Cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
