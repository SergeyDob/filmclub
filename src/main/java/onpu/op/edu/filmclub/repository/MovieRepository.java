package onpu.op.edu.filmclub.repository;

import onpu.op.edu.filmclub.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.movie.id = :movieId")
    Double findAverageRatingByMovieId(@Param("movieId") Long movieId);

    List<Movie> findByGenreIgnoreCase(String genre);

    @Query("SELECT r.movie FROM Review r GROUP BY r.movie ORDER BY AVG(r.rating) DESC")
    List<Movie> findTopRatedMovies();

    @Query("SELECT m FROM Movie m WHERE m.id NOT IN (SELECT r.movie.id FROM Review r)")
    List<Movie> findMoviesWithoutReviews();
}