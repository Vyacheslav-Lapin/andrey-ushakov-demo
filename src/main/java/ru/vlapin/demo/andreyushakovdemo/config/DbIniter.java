package ru.vlapin.demo.andreyushakovdemo.config;

import static ru.vlapin.demo.andreyushakovdemo.common.Loggable.LogLevel.INFO;

import java.util.Arrays;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.vlapin.demo.andreyushakovdemo.common.Loggable;
import ru.vlapin.demo.andreyushakovdemo.dao.CatRepository;
import ru.vlapin.demo.andreyushakovdemo.model.Cat;

@Component
@Loggable(INFO)
@RequiredArgsConstructor
public class DbIniter implements CommandLineRunner {

  CatRepository catRepository;

  Date date;

  @Override
  public void run(String... __) throws Exception {
    Arrays.stream("Васька, Мурзик, Барсик, Том".split(", "))
        .map(Cat::new)
        .forEach(catRepository::save);

    System.out.println("date = " + date);
  }
}
