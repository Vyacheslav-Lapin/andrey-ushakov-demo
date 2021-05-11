package ru.vlapin.demo.andreyushakovdemo.dao;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.vlapin.demo.andreyushakovdemo.model.Cat;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(authorities = "ADMIN")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class CatRepositoryTest {

  MockMvc mvc;

  @Test
  @SneakyThrows
  @DisplayName("cat entity works correctly")
  void catEntityWorksCorrectlyTest() {
    mvc.perform(MockMvcRequestBuilders.get("/cats"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType(MediaTypes.HAL_JSON_VALUE))
        .andExpect(jsonPath("$.page.totalElements").isNumber())
//        .andExpect(jsonPath("$.page.totalElements").value(4))
    //        .andExpect(mvcResult -> assertEquals(3,
    //            JsonPath.parse(mvcResult.getResponse()
    //                               .getContentAsString())
    //                .<Integer>read("$.page.totalElements").intValue()))
    ;
  }
}
