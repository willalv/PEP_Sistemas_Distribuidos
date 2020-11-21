package pep.distribuidos.entidades;

import org.springframework.data.relational.core.sql.In;

import java.util.Date;

public class Correo {

    private Long id;
    private String asunto;
    private String mensaje;
    private String destinatario;
    private Integer codigo;


    public Correo(String destinatario, Integer codigo, String nombre, String rutPersona, String direccionOrigen,
                  String direccionDestino, Date fechaInicio, Date fechaFin, Date horaInicio, Date horaFin, byte motivo)
    {
        String textoMotivo = "";
        if (motivo == 1)
            textoMotivo = "Asistencia a establecimientos de salud";
        else if (motivo == 2)
            textoMotivo = "Compras insumos básicos";
        else if (motivo == 3)
            textoMotivo = "Salida de personas con espectro autista u otra discapacidad mental";
        else if (motivo == 4)
            textoMotivo = "Paseo de mascotas";
        else if (motivo == 5)
            textoMotivo = "Pago de servicios básicos y gestiones";
        else if (motivo == 6)
            textoMotivo = "Asistencia a funeral familiar directo";
        else if (motivo == 7)
            textoMotivo = "Proceso de postulación al Sistema de Admisión Escolar, retiro de alimentos, textos escolares y/o artículos tecnológicos";
        else if (motivo == 8)
            textoMotivo = "Comparecencia a una citación en virtud de la Ley";
        else if (motivo == 9)
            textoMotivo = "Entregar alimentos u otros insumos de primera necesidad a adultos mayores";
        else if (motivo == 10)
            textoMotivo = "Proporcionar alimentos o insumos de primera necesidad en Recinto Penitenciario";
        else if (motivo == 11)
            textoMotivo = "Traslado del menor o adolescente al hogar del tutelar";
        else if (motivo == 12)
            textoMotivo = "Traslado de padres o tutores a establecimientos de Salud o Centros de SENAME";
        else if (motivo == 13)
            textoMotivo = "Permiso para donantes de sangre";
        else if (motivo == 14)
            textoMotivo = "Matrimonio y Unión Civil";
        else if (motivo == 15)
            textoMotivo = "Salida de Niños, Niñas y Adolescentes";
        else if (motivo == 16)
            textoMotivo = "Permiso de Traslado Interregional";

        this.asunto = "Permiso temporal";
        this.destinatario = destinatario;
        this.codigo = codigo;
        this.mensaje = "Sr. (a) " + nombre + ":\n Por este medio confirmamos que su Permiso Temporal fue generado con éxito.\n" +
                "A continuación encontrará una copia de su Permiso Temporal."+
                 "\nAtentamente, \nSistemas Distribuidos.\n\n\nCopia Permiso Temporal:\n" +
                "Nombre completo:" + nombre + "\n" +
                "Rut/DNI:"+ rutPersona + "\n" +
                "Dirección origen:" + direccionOrigen + "\n" +
                "Direccion destino:" + direccionDestino +"\n" +
                "Fecha y hora desde:" + fechaInicio + " " + horaInicio + "\n" +
                "Fecha y hora hasta:" + fechaFin + " " + horaFin + "\n" +
                "Motivo:" + textoMotivo + "\n" +
                "Código permiso:" + codigo + "\n";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
}
