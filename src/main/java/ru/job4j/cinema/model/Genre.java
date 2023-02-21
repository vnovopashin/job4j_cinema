package ru.job4j.cinema.model;

import java.util.Objects;

/**
 * Модель данных описывающая жанр фильма
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 * {@code @date} 21.02.2023
 */
public class Genre {
    private int id;
    private String name;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Genre genre = (Genre) o;
        return id == genre.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Genre{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}
