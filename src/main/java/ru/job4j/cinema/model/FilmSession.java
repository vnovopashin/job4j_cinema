package ru.job4j.cinema.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

/**
 * Модель данных описывающая киносеанс
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 * {@code @date} 21.02.2023
 */
public class FilmSession {

    public static final Map<String, String> COLUMN_MAPPING = Map.of(
            "id", "id",
            "film_id", "filmId",
            "halls_id", "hallsId",
            "start_time", "startTime",
            "end_time", "endTime",
            "price", "price"
    );

    private int id;
    private int filmId;
    private int hallsId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int price;

    public FilmSession() {
    }

    public FilmSession(int filmId, int hallsId, LocalDateTime startTime, LocalDateTime endTime, int price) {
        this.filmId = filmId;
        this.hallsId = hallsId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getHallsId() {
        return hallsId;
    }

    public void setHallsId(int hallsId) {
        this.hallsId = hallsId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FilmSession that = (FilmSession) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "FilmSession{"
                + "id=" + id
                + ", filmId=" + filmId
                + ", hallsId=" + hallsId
                + ", startTime=" + startTime
                + ", endTime=" + endTime
                + ", price=" + price
                + '}';
    }
}
