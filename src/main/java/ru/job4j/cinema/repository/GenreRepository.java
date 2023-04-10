package ru.job4j.cinema.repository;

import ru.job4j.cinema.model.Genre;

import java.util.Collection;
import java.util.Optional;

/**
 * Интерфейс инкапсулирующий логику хранения данных
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 * {@code @date} 04.04.2023
 */
public interface GenreRepository {
    Optional<Genre> findById(int id);

    Collection<Genre> findAll();
}
