package ru.vlapin.demo.andreyushakovdemo.common;

import static lombok.AccessLevel.PRIVATE;

import javax.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Getter
@ToString
@Component
//@FieldNameConstants
@RequiredArgsConstructor
public class Abc {

  @NonFinal
  @Setter(value = PRIVATE, onMethod_ = @Autowired)
  Bcd bcd;

  @PostConstruct
  private void init() {
    System.out.println("bcd = " + bcd);
  }

  @EventListener
  public void afterContextInitialization(ContextRefreshedEvent __) {
    System.out.println("bcd 2 = " + bcd);
  }

}

@Component
@ToString(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
class Bcd {

  Abc abc;
}

@Component
@RequiredArgsConstructor
class Main implements CommandLineRunner {

  Abc abc;
  Bcd bcd;

  @Override
  public void run(String... args) throws Exception {
    System.out.println("abc = " + abc);
    System.out.println("(abc.getBcd() == bcd) = " + (abc.getBcd() == bcd));
  }
}
