package ru.vlapin.demo.andreyushakovdemo.config;

import java.util.Date;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Configuration
//@Profile("prod")
//@Profile("local")
//@Profile("test")
//@Profile("dev")
public class IsDate implements Condition {

  @Bean
//  @Conditional(IsDate.class)
  Date date() {
    System.out.println("!");
    return new Date();
  }

  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    return false;
  }
}
