package org.tyytogetheyy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tyytogether.annotation.CicadaScan;

@CicadaScan(path = "org.tyytogetheyy.exception")
@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
