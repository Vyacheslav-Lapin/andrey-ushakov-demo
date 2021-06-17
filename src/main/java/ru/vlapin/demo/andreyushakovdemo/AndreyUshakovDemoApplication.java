package ru.vlapin.demo.andreyushakovdemo;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;

@SpringBootApplication
@ComponentScan(includeFilters = @Filter(Aspect.class))
//@ComponentScan({"ru.vlapin.demo.andreyushakovdemo.dao", "ru.vlapin.demo.andreyushakovdemo.controller"})
public class AndreyUshakovDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(AndreyUshakovDemoApplication.class, args);
  }

//  @Bean
//  @Primary
//  Date date() {
//    System.out.println("!!");
//    return new Date();
//  }
}

