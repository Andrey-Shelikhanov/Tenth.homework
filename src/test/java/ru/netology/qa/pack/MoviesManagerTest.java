package ru.netology.qa.pack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoviesManagerTest {
    @Test
    public void nothingAdded() {
        MoviesManager manager = new MoviesManager();
        String[] expected = {};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void oneFilmAdded() {
        MoviesManager manager = new MoviesManager();
        manager.addMovie("Film I");
        String[] expected = {"Film I"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void threeFilmsAdded() {
        MoviesManager manager = new MoviesManager();
        manager.addMovie("Film I");
        manager.addMovie("Film II");
        manager.addMovie("Film III");
        String[] expected = {"Film I", "Film II", "Film III"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ifFindLastLessThanLimit() {
        MoviesManager manager = new MoviesManager();
        manager.addMovie("Film I");
        manager.addMovie("Film II");
        manager.addMovie("Film III");
        String[] expected = {"Film III", "Film II", "Film I"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindWhenNothingAdded() {
        MoviesManager manager = new MoviesManager();
        String[] expected = {};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindOneFilmAdded() {
        MoviesManager manager = new MoviesManager();
        manager.addMovie("Film I");
        String[] expected = {"Film I"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ifFindLastSameAsLimit() {
        MoviesManager manager = new MoviesManager(6);
        manager.addMovie("Film I");
        manager.addMovie("Film II");
        manager.addMovie("Film III");
        manager.addMovie("Film IV");
        manager.addMovie("Film V");
        manager.addMovie("Film VI");
        String[] expected = {"Film VI", "Film V", "Film IV", "Film III", "Film II", "Film I"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ifFindLastMoreThanLimit() {
        MoviesManager manager = new MoviesManager();
        manager.addMovie("Film I");
        manager.addMovie("Film II");
        manager.addMovie("Film III");
        manager.addMovie("Film IV");
        manager.addMovie("Film V");
        manager.addMovie("Film VI");
        String[] expected = {"Film VI", "Film V", "Film IV", "Film III", "Film II"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}
