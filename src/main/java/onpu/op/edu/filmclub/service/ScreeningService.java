package onpu.op.edu.filmclub.service;

import onpu.op.edu.filmclub.entity.Screening;
import onpu.op.edu.filmclub.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningService {

    @Autowired
    private ScreeningRepository screeningRepository;

    public Screening saveScreening(Screening screening) {
        return screeningRepository.save(screening);
    }

    public List<Screening> getAllScreenings() {
        return screeningRepository.findAll();
    }

    public Screening getScreeningById(Long id) {
        return screeningRepository.findById(id).orElse(null);
    }

    public void deleteScreening(Long id) {
        screeningRepository.deleteById(id);
    }

    public List<Screening> getScreeningsByMovieId(Long movieId) {
        return screeningRepository.findByMovieId(movieId);
    }
}