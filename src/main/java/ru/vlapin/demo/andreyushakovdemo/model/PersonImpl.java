package ru.vlapin.demo.andreyushakovdemo.model;

import lombok.Value;

@Value
public class PersonImpl implements Person {

  String name;
  boolean broke;
}
