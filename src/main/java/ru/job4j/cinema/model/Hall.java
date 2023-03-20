package ru.job4j.cinema.model;

import java.util.Objects;

/**
 * Модель данных описывющая кинозал
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 * {@code @date} 21.02.2023
 */
public class Hall {
    private int id;
    private String name;
    private int rowCount;
    private int placeCount;
    private String description;

    public Hall() {
    }

    public Hall(String name, int rowCount, int placeCount, String description) {
        this.name = name;
        this.rowCount = rowCount;
        this.placeCount = placeCount;
        this.description = description;
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

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getPlaceCount() {
        return placeCount;
    }

    public void setPlaceCount(int placeCount) {
        this.placeCount = placeCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hall hall = (Hall) o;
        return id == hall.id && Objects.equals(name, hall.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Hall{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", rowCount=" + rowCount
                + ", placeCount=" + placeCount
                + ", description='" + description + '\''
                + '}';
    }
}
