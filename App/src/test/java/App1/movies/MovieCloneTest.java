package App1.movies;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MovieCloneTest {

    @Test
    void cloneCopiesAllFields() {
        Movie m = new Movie("Test", LocalDate.of(2020, 1, 1), "Author", 120, Genre.DRAMA);
        Movie copy = m.clone();

        assertNotSame(m, copy);
        assertEquals(m.getName(), copy.getName());
        assertEquals(m.getReleaseDate(), copy.getReleaseDate());
        assertEquals(m.getAuthor(), copy.getAuthor());
        assertEquals(m.getDuration(), copy.getDuration());
        assertEquals(m.getGenre(), copy.getGenre());
    }

    @Test
    void cloneIsIndependent() {
        Movie m = new Movie("Test", LocalDate.of(2020, 1, 1), "Author", 120, Genre.DRAMA);
        Movie copy = m.clone();

        copy.setName("Changed");
        copy.setGenre(Genre.COMEDY);

        assertEquals("Test", m.getName());
        assertEquals(Genre.DRAMA, m.getGenre());
    }
}