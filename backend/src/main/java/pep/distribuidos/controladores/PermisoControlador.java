package pep.distribuidos.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pep.distribuidos.entidades.Correo;
import pep.distribuidos.entidades.Permiso;
import pep.distribuidos.repositorios.PermisoRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;

@RestController
@CrossOrigin(origins = "*")
public class PermisoControlador {

    @Autowired
    private PermisoRepositorio permisoRepositorio;

    //@Autowired
    //private JavaMailSender mailsender;

    @GetMapping(value = "/permisos")
    @ResponseBody
    public Iterable<Permiso> getAll(){
        return permisoRepositorio.findAll();
    }

    @GetMapping(value = "/permiso/{id}")
    @ResponseBody
    public Permiso getPermisoByIdPermiso(@PathVariable int id){
        return permisoRepositorio.findPermisoByIdPermiso(id);
    }

    @GetMapping(value = "/permiso-codigo/{codigo}")
    @ResponseBody
    public Permiso getPermisoByCodigo(@PathVariable int codigo){
        return permisoRepositorio.findPermisoByCodigo(codigo);
    }

    //Función enviar correo
    /*public void enviarCorreo(Correo correo)
    {
        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(correo.getDestinatario());
        email.setSubject(correo.getAsunto());
        email.setText(correo.getMensaje());

        mailSender.send(email);
    }*/


    @PostMapping(value = "/permisos")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Permiso create(@RequestBody Permiso permiso){
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(new Date());
        calendario.set(Calendar.MINUTE, calendario.get(Calendar.MINUTE) + 15);
        Date fecha = calendario.getTime();
        Byte tipoPermiso = permiso.getMotivo();

        permiso.setFechaInicio(fecha);
        permiso.setHoraInicio(fecha);

        if (tipoPermiso == 1 || tipoPermiso == 2 || tipoPermiso == 5 ||
                tipoPermiso == 10 || tipoPermiso == 12) {
            calendario.set(Calendar.HOUR, calendario.get(Calendar.HOUR) + 3);
            fecha = calendario.getTime();
            permiso.setFechaFin(fecha);
            permiso.setHoraFin(fecha);
        }

        else if (tipoPermiso == 3 || tipoPermiso == 9 || tipoPermiso == 11) {
            calendario.set(Calendar.HOUR, calendario.get(Calendar.HOUR) + 2);
            fecha = calendario.getTime();
            permiso.setFechaFin(fecha);
            permiso.setHoraFin(fecha);
        }

        else if (tipoPermiso == 4) {
            calendario.set(Calendar.MINUTE, calendario.get(Calendar.MINUTE) + 30);
            fecha = calendario.getTime();
            permiso.setFechaFin(fecha);
            permiso.setHoraFin(fecha);
        }

        else if (tipoPermiso == 6 || tipoPermiso == 7) {
            calendario.set(Calendar.HOUR, calendario.get(Calendar.HOUR) + 5);
            fecha = calendario.getTime();
            permiso.setFechaFin(fecha);
            permiso.setHoraFin(fecha);
        }

        else if (tipoPermiso == 13) {
            calendario.set(Calendar.HOUR, calendario.get(Calendar.HOUR) + 6);
            fecha = calendario.getTime();
            permiso.setFechaFin(fecha);
            permiso.setHoraFin(fecha);
        }

        else if (tipoPermiso == 14) {
            calendario.set(Calendar.HOUR, calendario.get(Calendar.HOUR) + 4);
            fecha = calendario.getTime();
            permiso.setFechaFin(fecha);
            permiso.setHoraFin(fecha);
        }

        else if (tipoPermiso == 15) {
            calendario.set(Calendar.MINUTE, calendario.get(Calendar.MINUTE) + 90);
            fecha = calendario.getTime();
            permiso.setFechaFin(fecha);
            permiso.setHoraFin(fecha);
        }

        else if (tipoPermiso == 16) {
            SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
            String hora = "23:59:59";
            permiso.setFechaFin(fecha);
            try {
                permiso.setHoraFin(formato.parse(hora));
            }
            catch (ParseException ex)
            {
                System.out.println(ex);
            }
        }

        else {
            permiso.setFechaFin(fecha);
            permiso.setHoraFin(fecha);
        }

        int n = (int) (Math.random() * (999999999 + 1));
        permiso.setCodigo(n);




        return permisoRepositorio.save(permiso);
    }


}
