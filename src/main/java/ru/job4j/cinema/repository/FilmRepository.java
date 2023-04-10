package ru.job4j.cinema.repository;

import ru.job4j.cinema.model.Film;

import java.util.Collection;
import java.util.Optional;

/**
 * Интерфейс инкапсулирующий логику хранения данных
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 * {@code @date} 20.03.2023
 */
public interface FilmRepository {
    Optional<Film> findById(int id);

    Collection<Film> findAll();
}
