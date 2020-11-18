package pep.distribuidos.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "permisos")
public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permiso",  unique=true, nullable=false)
    private Integer idPermiso;

    @Column(name = "codigo", nullable = false)
    private  Integer codigo;

    // Datos que ingresa el ususario
    @Column(name = "rut_persona", unique = false, nullable = false, length = 10)
    private String rutPersona;

    @Column(name = "nombre_persona", nullable = false, length = 180)
    private String nombrePersona;

    @Column(name = "direccion_origen", nullable = false)
    private String direccionOrigen;

    @Column(name = "direccion_destino", nullable = false)
    private String direccionDestino;

    @Column(name = "correo", nullable = false, length = 512)
    private String correo;

    @Column(name = "motivo", nullable = false)
    private byte motivo;

    // Fecha y hora del permiso, solo al momento de apretar botón continuar.

    @Column(name = "hora_inicio", nullable = false)
    private Date horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private Date horaFin;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "fechaFin", nullable = false)
    private Date fechaFin;


    // Constructor
    public  Permiso(){}

    public Permiso(Integer codigo, String rutPersona, String nombrePersona, String direccionOrigen, String direccionDestino, String correo, byte motivo, Date horaInicio, Date horaFin, Date fechaInicio, Date fechaFin){
        this.codigo = codigo;
        this.rutPersona = rutPersona;
        this.nombrePersona = nombrePersona;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.correo = correo;
        this.motivo = motivo;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getRutPersona() {
        return rutPersona;
    }

    public void setRutPersona(String rutPersona) {
        this.rutPersona = rutPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public byte getMotivo() {
        return motivo;
    }

    public void setMotivo(byte motivo) {
        this.motivo = motivo;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
