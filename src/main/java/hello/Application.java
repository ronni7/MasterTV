package hello;

import hello.entities.Movie;
import hello.repositories.ServerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Time;
import java.text.SimpleDateFormat;


@SpringBootApplication
public class Application {
    //  private static final Logger log =  LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

   /* @Bean
    public CommandLineRunner demo(ServerRepository repository) {
        return (args) -> {
            // save a couple of Users
            repository.save(new Movie("Lord Of The Rings: The Fellowship Of The Ring",
                    "Frodo gets ring,goes mad, runs through Middlearth to destroy it", 192, 7, "lotr1.mp4"));
            repository.save(new Movie("Lord Of The Rings: The Two Towers",
                    "Frodo has ring, Theoden says 'Where was Gondor x100 times, LMAO",215,7,"lotr2.mp4"));
            repository.save(new Movie("Lord Of The Rings: The Fellowship Of The Ring",
                    "Frodo steps into Mordor finally, Aragorn is going to be king wtf",292,7,"lotr3.mp4"));
        };
        }*/
}
