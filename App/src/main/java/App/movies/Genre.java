package App.movies;

public enum Genre {
    ACTION("боевик"),
    ADVENTURE("приключения"),
    COMEDY("комедия"),
    DRAMA("драма"),
    HORROR("ужасы");


    private String name;

    Genre(String name) {
        this.name = name;
    }

    public String getValue() {
        return name;
    }
}
