package onpu.op.edu.filmclub.service;

import onpu.op.edu.filmclub.entity.AppUser;
import onpu.op.edu.filmclub.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    public AppUser save(AppUser appUser) {
        return appUserRepository.save(appUser);
    }
}