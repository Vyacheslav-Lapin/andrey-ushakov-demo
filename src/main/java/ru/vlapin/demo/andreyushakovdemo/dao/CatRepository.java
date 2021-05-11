package ru.vlapin.demo.andreyushakovdemo.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlapin.demo.andreyushakovdemo.model.Cat;

public interface CatRepository extends JpaRepository<Cat, UUID> {
}
