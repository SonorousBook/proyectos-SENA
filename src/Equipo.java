public class Equipo {

    private String numeroSerieEquipo;
    private String modelo;
    private String descripcion;
    private String fechaAdquisicion; // Puedes usar java.sql.Date si prefieres
    private int idSede;
    private String estado;
    private String tipoEquipo;
    private String activoFijo;

    // Constructor vacío
    public Equipo() {
    }

    // Constructor con todos los parámetros
    public Equipo(String numeroSerieEquipo, String modelo, String descripcion, String fechaAdquisicion, int idSede, String estado, String tipoEquipo, String activoFijo) {
        this.numeroSerieEquipo = numeroSerieEquipo;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.fechaAdquisicion = fechaAdquisicion;
        this.idSede = idSede;
        this.estado = estado;
        this.tipoEquipo = tipoEquipo;
        this.activoFijo = activoFijo;
    }

    // Getters y Setters
    public String getNumeroSerieEquipo() {
        return numeroSerieEquipo;
    }

    public void setNumeroSerieEquipo(String numeroSerieEquipo) {
        this.numeroSerieEquipo = numeroSerieEquipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(String fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(String tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public String getActivoFijo() {
        return activoFijo;
    }

    public void setActivoFijo(String activoFijo) {
        this.activoFijo = activoFijo;
    }
}

