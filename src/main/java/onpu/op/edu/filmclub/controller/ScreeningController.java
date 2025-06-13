package onpu.op.edu.filmclub.controller;

import onpu.op.edu.filmclub.entity.Screening;
import onpu.op.edu.filmclub.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screenings")
public class ScreeningController {

    @Autowired
    private ScreeningService screeningService;

    @PostMapping
    public Screening createScreening(@RequestBody Screening screening) {
        return screeningService.saveScreening(screening);
    }

    @GetMapping
    public List<Screening> getAllScreenings() {
        return screeningService.getAllScreenings();
    }

    @GetMapping("/{id}")
    public Screening getScreeningById(@PathVariable Long id) {
        return screeningService.getScreeningById(id);
    }

    @GetMapping("/movie/{movieId}")
    public List<Screening> getScreeningsByMovieId(@PathVariable Long movieId) {
        return screeningService.getScreeningsByMovieId(movieId);
    }

    @DeleteMapping("/{id}")
    public void deleteScreening(@PathVariable Long id) {
        screeningService.deleteScreening(id);
    }

    // Новий запит
    @PutMapping("/{id}")
    public Screening updateScreening(@PathVariable Long id, @RequestBody Screening screening) {
        screening.setId(id);
        return screeningService.saveScreening(screening);
    }
}