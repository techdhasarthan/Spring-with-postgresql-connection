package com.java.server.server.Student;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class studentconfig {
    @Bean
    CommandLineRunner commandLineRunner(studentRepository studentRepository){
        return args -> {
            student jake =  new student ( "dhasarathan",  LocalDate.of(2002,11,15),"dhasarathan@gmail.com");
            studentRepository.saveAll(List.of(jake));
        };
    }
}
