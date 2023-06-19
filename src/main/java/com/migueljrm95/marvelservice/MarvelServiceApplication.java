package com.migueljrm95.marvelservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(
        info = @Info(
                title = "Marvel API",
                version = "1.0"
        ),
        servers =  @Server(url = "http://localhost:8080/",description = "v1.0")
)
public class MarvelServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MarvelServiceApplication.class, args);
    }

}
