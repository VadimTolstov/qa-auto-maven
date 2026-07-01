package ru.tolstov.hw12.movieRatings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MovieServiceTest {
    private MovieService<Number> movieService;

    /**
     * №	Тест	                                     Входные данные	                                        Ожидаемый результат
     * 1	Добавление рейтинга         	             movie=фильм "Inception", rating=Rating<Integer>(8)	    Рейтинг добавлен в хранилище, средняя оценка = 8.0
     * 2	Добавление рейтинга   1.1      	             movie=фильм "Inception", rating=Rating<Double>(1.1)	Рейтинг добавлен в хранилище, средняя оценка = 1.1
     * 3	Добавление рейтинга   9.9      	             movie=фильм "Inception", rating=Rating<Double>(9.9)	Рейтинг добавлен в хранилище, средняя оценка = 9.9
     * 4	Добавление рейтинга на границе 1	         movie=фильм "Matrix", rating=Rating<Integer>(1)	    Допустимо, средняя = 1.0
     * 5	Добавление рейтинга на границе 10	         movie=фильм "Matrix", rating=Rating<Integer>(10)	    Допустимо, средняя = 10.0 (после одной оценки)
     * 6	Добавление null-фильма	                     movie=null, rating=Rating<Integer>(5)	                Исключение IllegalArgumentException
     * 7	Добавление null-рейтинга	                 movie=фильм "Inception", rating=null	                Исключение IllegalArgumentException
     * 8	Добавление рейтинга <=0	                     movie=фильм "Inception", rating=Rating<Integer>(0)	    Исключение IllegalArgumentException
     * 9	Добавление рейтинга >=11	                 movie=фильм "Inception", rating=Rating<Integer>(11)    Исключение IllegalArgumentException
     * 10	Средний рейтинг для несуществующего фильма	 movie=фильм "Unknown" (не добавлен)	                getAverageRating возвращает 0.0
     * 11	Средний рейтинг для нескольких оценок	     A-6.5, B-3.5,	 A-5.5, B-7.5                           A (6.5+5.5)/2=6  B (3.5+7.5)/2=5.5
     * 12	Сортировка фильмов по популярности	         Три фильма: "A" (среднее 9.0), "B" (7.5), "C" (8.0)	Список: ["A", "C", "B"] (по убыванию средней)
     * 13	getAllAverageRatings возвращает  средние	 "A": [4,6], "B": [10], "C": без оценок	                Map: {"A"=5.0, "B"=10.0} (без "C")
     */

    @BeforeEach
    void setUp() {
        movieService = new MovieService<>();
    }

    public static Stream<Arguments> dataForValidationPositiveCasesAddRating() {
        return Stream.of(
                Arguments.of(new Movie("Inception"), new Rating<>(8)),
                Arguments.of(new Movie("Inception"), new Rating<>(1.1)),
                Arguments.of(new Movie("Inception"), new Rating<>(9.9)),
                Arguments.of(new Movie("Inception"), new Rating<>(1)),
                Arguments.of(new Movie("Inception"), new Rating<>(10))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForValidationPositiveCasesAddRating")
    void checkValidAddRating(Movie movie, Rating<Number> rating) {
        movieService.addRating(movie, rating);
        assertEquals(
                movie,
                movieService.getAllAverageRatings()
                        .keySet()
                        .stream()
                        .findFirst()
                        .get()
        );
        assertEquals(
                rating.estimation().doubleValue(),
                movieService.getAllAverageRatings().get(movie)
        );
    }

    public static Stream<Arguments> dataForInvalidAddRatingCases() {
        return Stream.of(
                Arguments.of(new Movie("Inception"), null, "movie или rating не должны быть null"),
                Arguments.of(new Movie("Inception"), new Rating<>(0), "Рейтинг должен быть >= 1 и <= 10, передан: 0.0"),
                Arguments.of(new Movie("Inception"), new Rating<>(-10), "Рейтинг должен быть >= 1 и <= 10, передан: -10.0"),
                Arguments.of(new Movie("Inception"), new Rating<>(11), "Рейтинг должен быть >= 1 и <= 10, передан: 11.0"),
                Arguments.of(new Movie("Inception"), new Rating<>(100), "Рейтинг должен быть >= 1 и <= 10, передан: 100.0"),
                Arguments.of(null, new Rating<>(10), "movie или rating не должны быть null")
        );
    }

    @ParameterizedTest
    @MethodSource("dataForInvalidAddRatingCases")
    void checkInvalidAddRating(Movie movie, Rating<Number> rating, String message) {
        IllegalArgumentException illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> movieService.addRating(movie, rating)
        );
        assertEquals(message, illegalArgumentException.getMessage());
    }


    @Test
    void checkValidGetAverageRatingWhenNoFilmName() {
        movieService.addRating(new Movie("Inception"), new Rating<>(2));
        assertEquals(0.0, movieService.getAverageRating(new Movie("Капитан немо")));
    }

    @Test
    void checkValidGetAverageRatingWhenOneFilmName() {
        Movie movie = new Movie("Inception");
        movieService.addRating(movie, new Rating<>(2));
        assertEquals(2.0, movieService.getAverageRating(movie));
    }

    @Test
    void checkValidGetAverageRating() {
        Movie movieA = new Movie("A");
        Movie movieB = new Movie("B");
        movieService.addRating(movieA, new Rating<>(6.5));
        movieService.addRating(movieA, new Rating<>(5.5));
        movieService.addRating(movieB, new Rating<>(3.5));
        movieService.addRating(movieB, new Rating<>(7.5));
        assertEquals(6.0, movieService.getAverageRating(movieA));
        assertEquals(5.5, movieService.getAverageRating(movieB));
    }

    @Test
    void checkValidGetMoviesSortedByPopularity() {
        Movie movieA = new Movie("A");
        Movie movieB = new Movie("B");
        Movie movieC = new Movie("C");
        movieService.addRating(movieA, new Rating<>(9.0));
        movieService.addRating(movieB, new Rating<>(7.5));
        movieService.addRating(movieC, new Rating<>(8.0));

        assertEquals(List.of(movieA, movieC, movieB), movieService.getMoviesSortedByPopularity());
    }

    @Test
    void checkValidGetAllAverageRatings() {
        Movie movieA = new Movie("A");
        Movie movieB = new Movie("B");
        Movie movieC = new Movie("C");
        Rating<Number> ratingA = new Rating<>(6.5);
        Rating<Number> ratingB = new Rating<>(7.5);
        Rating<Number> ratingC = new Rating<>(8.0);
        movieService.addRating(movieA, ratingA);
        movieService.addRating(movieB, ratingB);
        movieService.addRating(movieC, ratingC);

        assertEquals(Map.of(
                        movieA, ratingA.estimation().doubleValue(),
                        movieC, ratingC.estimation().doubleValue(),
                        movieB, ratingB.estimation().doubleValue()
                ),
                movieService.getAllAverageRatings()
        );
    }

    @Test
    void addRatingConcurrently() throws InterruptedException {
        int threadCount = 10;
        int additionsPerThread = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadId = i;
            executorService.submit(() -> {
                try {
                    for (int j = 0; j < additionsPerThread; j++) {
                        movieService.addRating(
                                new Movie(threadId + "-" + j),
                                new Rating<>(1)
                        );
                    }
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();

        assertEquals(threadCount * additionsPerThread, movieService.getAllAverageRatings().size());
    }
}