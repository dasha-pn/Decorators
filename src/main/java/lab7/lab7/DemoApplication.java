package lab7.lab7;

import lab7.lab7.repository.flower.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Kyiv"));
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner seed(FlowerRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Flower(12, FlowerColor.RED,    100, FlowerType.ROSE));
                repo.save(new Flower(10, FlowerColor.YELLOW,  80, FlowerType.TULIP));
            }
        };
    }
}
