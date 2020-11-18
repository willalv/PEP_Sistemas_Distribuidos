package pep.distribuidos.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pep.distribuidos.entidades.Permiso;
import pep.distribuidos.repositorios.PermisoRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
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
        int permisoId = id;
        return permisoRepositorio.findPermisoByIdPermiso(permisoId);
    }

    @GetMapping(value = "/permiso/codigo/{codigo}")
    @ResponseBody
    public Permiso getPermisoByCodigo(@PathVariable int codigo){
        int codigoPermiso = codigo;
        return permisoRepositorio.findPermisoByCodigo(codigoPermiso);
    }


    //@PostMapping(path = "/permisos", consumes="application/json")
    //public ResponseEntity<String> agregarPermiso(@RequestBody Permiso permiso){ }

    @PostMapping(value = "/permisos")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Permiso create(@RequestBody Permiso permiso){
        return permisoRepositorio.save(permiso);
    }


}
