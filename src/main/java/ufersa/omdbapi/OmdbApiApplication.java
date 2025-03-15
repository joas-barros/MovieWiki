package ufersa.omdbapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ufersa.omdbapi.principal.Principal;

@SpringBootApplication
public class OmdbApiApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(OmdbApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();
        principal.exibeMenu();
    }
}
