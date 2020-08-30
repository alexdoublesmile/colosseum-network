package edu.plohoy.springbootdemo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Launcher {
    ConfigurableApplicationContext ctx = SpringApplication.run(Launcher.class);
}
