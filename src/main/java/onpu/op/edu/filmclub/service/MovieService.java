package onpu.op.edu.filmclub.service;

import onpu.op.edu.filmclub.entity.Movie;
import onpu.op.edu.filmclub.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public Double getAverageRating(Long movieId) {
        return movieRepository.findAverageRatingByMovieId(movieId);
    }

    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenreIgnoreCase(genre);
    }

    public List<Movie> getTopRatedMovies() {
        return movieRepository.findTopRatedMovies();
    }

    public List<Movie> getUnreviewedMovies() {
        return movieRepository.findMoviesWithoutReviews();
    }

    // Нові методи
    public List<Movie> searchMoviesByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Movie> getMoviesBetweenDates(LocalDate start, LocalDate end) {
        return movieRepository.findByReleaseDateBetween(start, end);
    }

    public List<String> getAllGenres() {
        return movieRepository.findAll().stream()
                .map(Movie::getGenre)
                .distinct()
                .collect(Collectors.toList());
    }

    public long countAllMovies() {
        return movieRepository.count();
    }

    public List<Movie> getLatestMovies(int count) {
        return movieRepository.findTopByOrderByReleaseDateDesc(count);
    }

    public List<Movie> getMoviesByDirector(String director) {
        return movieRepository.findByDirectorContainingIgnoreCase(director);
    }
}