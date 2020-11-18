package pep.distribuidos.entidades;

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
    private int idPermiso;

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

    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Column(name = "fechaFin", nullable = false)
    private Date fechaFin;


    // Constructor
    public Permiso(String rutPersona, String nombrePersona, String direccionOrigen, String direccionDestino, String correo,
    byte motivo){

        this.rutPersona = rutPersona;
        this.nombrePersona = nombrePersona;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.correo = correo;
        this.motivo = motivo;

        //Date inicio = new Date();
        //DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        //this.horaInicio = formatoHora.format(inicio);

    }



}
