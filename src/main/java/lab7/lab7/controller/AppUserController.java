package lab7.lab7.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lab7.lab7.repository.appuser.AppUser;
import lab7.lab7.service.AppUserService;

@RestController
@RequestMapping(path = "api/appuser")
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping
    public List<AppUser> getUsers() {
        return appUserService.getAllUsers();
    }

    @PostMapping
    public void registerNewUser(@RequestBody AppUser user) {
        appUserService.addNewUser(user);
    }
}
