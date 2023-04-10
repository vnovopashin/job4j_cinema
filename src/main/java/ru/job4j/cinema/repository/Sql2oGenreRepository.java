package ru.job4j.cinema.repository;

import org.sql2o.Sql2o;
import ru.job4j.cinema.model.Genre;

import java.util.Collection;
import java.util.Optional;

/**
 * Класс реализует интерфейс GenreRepository
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 * {@code @date} 04.04.2023
 */
public class Sql2oGenreRepository implements GenreRepository {

    private final Sql2o sql2o;

    public Sql2oGenreRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Optional<Genre> findById(int id) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM genres WHERE id = :id");
            var genre = query.addParameter("id", id).executeAndFetchFirst(Genre.class);
            return Optional.ofNullable(genre);
        }
    }

    @Override
    public Collection<Genre> findAll() {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM genres");
            return query.executeAndFetch(Genre.class);
        }
    }
}
