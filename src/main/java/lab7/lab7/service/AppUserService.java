package lab7.lab7.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lab7.lab7.repository.appuser.AppUser;
import lab7.lab7.repository.appuser.AppUserRepository;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    public void addNewUser(AppUser user) {
        Optional<AppUser> userOptional =
                appUserRepository.findUserByEmail(user.getEmail());

        if (userOptional.isPresent()) {
            throw new IllegalStateException("email already taken");
        }

        appUserRepository.save(user);
    }
}
