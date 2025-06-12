package onpu.op.edu.filmclub.controller;

import onpu.op.edu.filmclub.entity.Movie;
import onpu.op.edu.filmclub.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}