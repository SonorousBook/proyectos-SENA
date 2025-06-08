public class Sede {

    private int idSede;
    private String NIT_Cliente;
    private String nombreSede;
    private String direccionSede;
    private String telefonoSede;
    private String ciudad;
    private String correo;

    // Constructor vacío
    public Sede() {
    }

    // Constructor con todos los parámetros
    public Sede(int idSede, String NIT_Cliente, String nombreSede, String direccionSede, String telefonoSede, String ciudad, String correo) {
        this.idSede = idSede;
        this.NIT_Cliente = NIT_Cliente;
        this.nombreSede = nombreSede;
        this.direccionSede = direccionSede;
        this.telefonoSede = telefonoSede;
        this.ciudad = ciudad;
        this.correo = correo;
    }

    // Getters y Setters
    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public String getNIT_Cliente() {
        return NIT_Cliente;
    }

    public void setNIT_Cliente(String NIT_Cliente) {
        this.NIT_Cliente = NIT_Cliente;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getDireccionSede() {
        return direccionSede;
    }

    public void setDireccionSede(String direccionSede) {
        this.direccionSede = direccionSede;
    }

    public String getTelefonoSede() {
        return telefonoSede;
    }

    public void setTelefonoSede(String telefonoSede) {
        this.telefonoSede = telefonoSede;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
