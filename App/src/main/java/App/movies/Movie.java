package App.movies;

import java.time.LocalDate;

public class Movie {
    private String name;
    private LocalDate releaseDate;
    private String author;
    private long duration;
    private Genre genre;

    public Movie(String name, LocalDate releaseDate, String author, long duration, Genre genre) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.author = author;
        this.duration = duration;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Фильм: " + name
                + " | Дата выхода: " + releaseDate
                + " | Автор: " + author
                + " | Продолжительность: " + duration + " (мин)"
                + " | Жанр: " + genre.getValue();
    }
}
