package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"dev.paie.service", "dev.paie.util", "dev.paie.spring"})
//permet de rechercher des beans Spring dans le package dev.paie.service
public class ServicesConfig {

}