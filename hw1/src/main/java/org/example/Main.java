package org.example;

import org.example.dto.*;
import org.example.jdbs.JdbcStudentsRepository;
import org.example.jdbs.StudentsRepository;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws SQLException {

        ApplicationContext context = SpringApplication.run(Main.class);

        StudentsRepository repository = context.getBean(JdbcStudentsRepository.class);

        Console.main(args);
    }
}
