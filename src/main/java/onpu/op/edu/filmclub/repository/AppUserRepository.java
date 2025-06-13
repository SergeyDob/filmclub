package onpu.op.edu.filmclub.repository;

import onpu.op.edu.filmclub.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}