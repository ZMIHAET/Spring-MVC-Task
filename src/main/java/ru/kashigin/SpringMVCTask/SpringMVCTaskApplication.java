package ru.kashigin.SpringMVCTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.kashigin.SpringMVCTask")
public class SpringMVCTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringMVCTaskApplication.class, args);
    }
}
