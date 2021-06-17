package ru.vlapin.demo.andreyushakovdemo.model;

import ru.vlapin.demo.andreyushakovdemo.model.Drink;

@FunctionalInterface
public interface Bar {
  Drink sellDrink(Person person);
}
