package ru.vlapin.demo.andreyushakovdemo.controller;

import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {

  @NotNull
  @SneakyThrows
  @Contract(pure = true)
//  @GetMapping("api1")
  @GetMapping(
      path = "api1",
      produces = "application/json")
  public ResponseEntity<@NotNull String> get() {
    return ResponseEntity.ok("{\"мама\": 1}");
  }
}
