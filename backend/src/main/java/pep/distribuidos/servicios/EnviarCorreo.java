package pep.distribuidos.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import pep.distribuidos.entidades.Permiso;

import java.text.SimpleDateFormat;

@Service
public class EnviarCorreo {

    @Autowired
    private JavaMailSender mailSender;


    public void sendEmail(Permiso permiso) {
        SimpleMailMessage email = new SimpleMailMessage();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        String textoMotivo = "";
        if (permiso.getMotivo() == 1)
            textoMotivo = "Asistencia a establecimientos de salud";
        else if (permiso.getMotivo() == 2)
            textoMotivo = "Compras insumos básicos";
        else if (permiso.getMotivo() == 3)
            textoMotivo = "Salida de personas con espectro autista u otra discapacidad mental";
        else if (permiso.getMotivo() == 4)
            textoMotivo = "Paseo de mascotas";
        else if (permiso.getMotivo() == 5)
            textoMotivo = "Pago de servicios básicos y gestiones";
        else if (permiso.getMotivo() == 6)
            textoMotivo = "Asistencia a funeral familiar directo";
        else if (permiso.getMotivo() == 7)
            textoMotivo = "Proceso de postulación al Sistema de Admisión Escolar, retiro de alimentos, textos escolares y/o artículos tecnológicos";
        else if (permiso.getMotivo() == 8)
            textoMotivo = "Comparecencia a una citación en virtud de la Ley";
        else if (permiso.getMotivo() == 9)
            textoMotivo = "Entregar alimentos u otros insumos de primera necesidad a adultos mayores";
        else if (permiso.getMotivo() == 10)
            textoMotivo = "Proporcionar alimentos o insumos de primera necesidad en Recinto Penitenciario";
        else if (permiso.getMotivo() == 11)
            textoMotivo = "Traslado del menor o adolescente al hogar del tutelar";
        else if (permiso.getMotivo() == 12)
            textoMotivo = "Traslado de padres o tutores a establecimientos de Salud o Centros de SENAME";
        else if (permiso.getMotivo() == 13)
            textoMotivo = "Permiso para donantes de sangre";
        else if (permiso.getMotivo() == 14)
            textoMotivo = "Matrimonio y Unión Civil";
        else if (permiso.getMotivo() == 15)
            textoMotivo = "Salida de Niños, Niñas y Adolescentes";
        else if (permiso.getMotivo() == 16)
            textoMotivo = "Permiso de Traslado Interregional";

        String fechaTextoInicio = formatter.format(permiso.getFechaInicio());
        String fechaTextoFin = formatter.format(permiso.getFechaFin());

        String mensajeCorreo = "Sr. (a) " + permiso.getNombrePersona() + ":\n" +
                "Por este medio confirmamos que su Permiso Temporal fue generado con éxito.\n" +
                "A continuación encontrará una copia de su Permiso Temporal.\n"+
                "\nAtentamente, \nSistemas Distribuidos." +
                "\n\n---------------------------------------------\n\n" +
                "Nombre completo: " + permiso.getNombrePersona() + "\n" +
                "Rut/DNI: "+ permiso.getRutPersona() + "\n" +
                "Dirección origen: " + permiso.getDireccionOrigen() + "\n" +
                "Direccion destino: " + permiso.getDireccionDestino() +"\n" +
                "Fecha y hora desde: " + fechaTextoInicio + "\n" +
                "Fecha y hora hasta: " + fechaTextoFin + "\n" +
                "Motivo: " + textoMotivo + "\n" +
                "Código permiso: " + permiso.getCodigo() + "\n";


        email.setTo(permiso.getCorreo());
        email.setSubject("Permiso temporal");
        email.setText(mensajeCorreo);

        mailSender.send(email);
    }

}
