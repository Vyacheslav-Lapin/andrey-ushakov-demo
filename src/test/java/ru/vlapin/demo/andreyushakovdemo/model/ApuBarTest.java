package ru.vlapin.demo.andreyushakovdemo.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class ApuBarTest {

  Bar bar;

  @Test
  @SneakyThrows
  @DisplayName("Bar works correctly")
  void barWorksCorrectlyTest() {
    assertThat(bar.sellDrink(new PersonImpl("Вася", false))).isNotNull()
        .extracting(Drink::getName)
        .isEqualTo("Squishee");
  }

  @Test
  @SneakyThrows
  @DisplayName("Bar works correctly in bronen scenario")
  void barWorksCorrectlyInBronenScenarioTest() {
    assertThat(
        assertThrows(CustomerBrokenException.class,
            () -> bar.sellDrink(new PersonImpl("Петя", true))))
        .isNotNull()
        .isInstanceOf(CustomerBrokenException.class);
  }
}
