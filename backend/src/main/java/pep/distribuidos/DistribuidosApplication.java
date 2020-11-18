package pep.distribuidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DistribuidosApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistribuidosApplication.class, args);
        Date fecha = new Date();
        System.out.println(fecha);
    }

}
