package onpu.op.edu.filmclub.controller;

import onpu.op.edu.filmclub.entity.Movie;
import onpu.op.edu.filmclub.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        movie.setId(id);
        return movieService.saveMovie(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    @GetMapping("/{id}/average-rating")
    public Double getAverageRating(@PathVariable Long id) {
        return movieService.getAverageRating(id);
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> getMoviesByGenre(@PathVariable String genre) {
        return movieService.getMoviesByGenre(genre);
    }

    @GetMapping("/top-rated")
    public List<Movie> getTopRatedMovies() {
        return movieService.getTopRatedMovies();
    }

    @GetMapping("/unreviewed")
    public List<Movie> getUnreviewedMovies() {
        return movieService.getUnreviewedMovies();
    }

    // Нові запити
    @GetMapping("/search")
    public List<Movie> searchMovies(@RequestParam String title) {
        return movieService.searchMoviesByTitle(title);
    }

    @GetMapping("/date-range")
    public List<Movie> getMoviesInDateRange(@RequestParam String start, @RequestParam String end) {
        return movieService.getMoviesBetweenDates(LocalDate.parse(start), LocalDate.parse(end));
    }

    @GetMapping("/genres")
    public List<String> getAllGenres() {
        return movieService.getAllGenres();
    }

    @GetMapping("/count")
    public long countMovies() {
        return movieService.countAllMovies();
    }

    @GetMapping("/latest")
    public List<Movie> getLatestMovies(@RequestParam(defaultValue = "5") int count) {
        return movieService.getLatestMovies(count);
    }

    // Додатковий 15-й запит
    @GetMapping("/director/{director}")
    public List<Movie> getMoviesByDirector(@PathVariable String director) {
        return movieService.getMoviesByDirector(director);
    }
}