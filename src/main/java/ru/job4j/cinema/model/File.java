package ru.job4j.cinema.model;

import java.util.Objects;

/**
 * Модель данных описывающая файлы-постеры, файлы-постеры хранятся в папке files,
 * а относительный путь до файла-постера хранится в базе данных.
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 * {@code @date} 21.02.2023
 */
public class File {
    private int id;
    private String name;
    private String path;

    public File() {
    }

    public File(String name, String path) {
        this.name = name;
        this.path = path;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        File file = (File) o;
        return id == file.id && Objects.equals(path, file.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, path);
    }

    @Override
    public String toString() {
        return "File{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", path='" + path + '\''
                + '}';
    }
}
