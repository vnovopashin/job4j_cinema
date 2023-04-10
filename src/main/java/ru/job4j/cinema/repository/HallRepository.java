package ru.job4j.cinema.repository;

import ru.job4j.cinema.model.Hall;

import java.util.Collection;
import java.util.Optional;

/**
 * Интерфейс инкапсулирующий логику хранения данных
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 * {@code @date} 04.04.2023
 */
public interface HallRepository {
    Optional<Hall> findById(int id);

    Collection<Hall> findAll();
}
