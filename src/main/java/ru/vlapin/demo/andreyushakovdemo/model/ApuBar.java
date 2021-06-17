package ru.vlapin.demo.andreyushakovdemo.model;

import org.springframework.stereotype.Service;
import ru.vlapin.demo.andreyushakovdemo.config.Polite;

@Service
public class ApuBar implements Bar {

  @Polite
  @Override
  public Drink sellDrink(Person person) {
    if (person.isBroke()) throw new CustomerBrokenException();
    System.out.println("Here is your squishee");
    return () -> "Squishee";
  }
}
