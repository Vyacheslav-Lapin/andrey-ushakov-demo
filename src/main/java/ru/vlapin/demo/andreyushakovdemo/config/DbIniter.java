package ru.vlapin.demo.andreyushakovdemo.config;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.vlapin.demo.andreyushakovdemo.dao.CatRepository;
import ru.vlapin.demo.andreyushakovdemo.model.Cat;

@Component
@RequiredArgsConstructor
public class DbIniter implements CommandLineRunner {

  CatRepository catRepository;

  @Override
  public void run(String... __) throws Exception {
    Arrays.stream("Васька, Мурзик, Барсик, Том".split(", "))
        .map(Cat::new)
        .forEach(catRepository::save);
  }
}
