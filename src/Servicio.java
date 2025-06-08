import java.util.List;
import java.util.Date;       // Para manejar fechas generales
import java.sql.Timestamp;   // Para manejar fechas y horas (timestamp)

public class Servicio {

    private int idServicio;
    private String fechaHoraInicio;
    private String fechaHoraFinalizacion;
    private String tipoServicio;
    private String observaciones;
    private String estadoServicio;
    private String NIT_Cliente;
    private int idSede;
    private String numeroSerieEquipo;
    private int idUsuario;
    private List<String> historialServicio;  // Listado de eventos como texto plano
    private String eventoGoogleId;

    // Constructor vacío
    public Servicio() {
    }

    // Constructor con todos los parámetros
    public Servicio(int idServicio, String fechaHoraInicio, String fechaHoraFinalizacion, String tipoServicio, String observaciones, String estadoServicio,
                    String NIT_Cliente, int idSede, String numeroSerieEquipo, int idUsuario, List<String> historialServicio, String eventoGoogleId) {
        this.idServicio = idServicio;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFinalizacion = fechaHoraFinalizacion;
        this.tipoServicio = tipoServicio;
        this.observaciones = observaciones;
        this.estadoServicio = estadoServicio;
        this.NIT_Cliente = NIT_Cliente;
        this.idSede = idSede;
        this.numeroSerieEquipo = numeroSerieEquipo;
        this.idUsuario = idUsuario;
        this.historialServicio = historialServicio;
        this.eventoGoogleId = eventoGoogleId;
    }

    // Getters y Setters
    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(String fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public String getFechaHoraFinalizacion() {
        return fechaHoraFinalizacion;
    }

    public void setFechaHoraFinalizacion(String fechaHoraFinalizacion) {
        this.fechaHoraFinalizacion = fechaHoraFinalizacion;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstadoServicio() {
        return estadoServicio;
    }

    public void setEstadoServicio(String estadoServicio) {
        this.estadoServicio = estadoServicio;
    }

    public String getNIT_Cliente() {
        return NIT_Cliente;
    }

    public void setNIT_Cliente(String NIT_Cliente) {
        this.NIT_Cliente = NIT_Cliente;
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public String getNumeroSerieEquipo() {
        return numeroSerieEquipo;
    }

    public void setNumeroSerieEquipo(String numeroSerieEquipo) {
        this.numeroSerieEquipo = numeroSerieEquipo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<String> getHistorialServicio() {
        return historialServicio;
    }

    public void setHistorialServicio(List<String> historialServicio) {
        this.historialServicio = historialServicio;
    }

    public String getEventoGoogleId() {
        return eventoGoogleId;
    }

    public void setEventoGoogleId(String eventoGoogleId) {
        this.eventoGoogleId = eventoGoogleId;
    }
}
