package onpu.op.edu.filmclub.service;

import onpu.op.edu.filmclub.entity.Movie;
import onpu.op.edu.filmclub.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.orElse(null);
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
}