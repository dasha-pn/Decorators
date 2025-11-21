package lab7.lab7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import lab7.lab7.repository.appuser.AppUser;
import lab7.lab7.repository.appuser.AppUserRepository;
import lab7.lab7.service.AppUserService;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.never;

@ExtendWith(MockitoExtension.class)
class AppUserServiceTest {

    @Mock
    private AppUserRepository appUserRepository;

    @InjectMocks
    private AppUserService underTest;

    @Test
    void canAddNewUserWhenEmailFree() {
        AppUser user = new AppUser(
                "free@example.com",
                LocalDate.of(2000, 1, 1)
        );
        given(appUserRepository.findUserByEmail(user.getEmail()))
                .willReturn(Optional.empty());

        underTest.addNewUser(user);

        then(appUserRepository).should().save(user);
    }

    @Test
    void willThrowWhenEmailAlreadyTaken() {
        AppUser user = new AppUser(
                "taken@example.com",
                LocalDate.of(2000, 1, 1)
        );
        given(appUserRepository.findUserByEmail(user.getEmail()))
                .willReturn(Optional.of(user));

        assertThatThrownBy(() -> underTest.addNewUser(user))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("email already taken");

        then(appUserRepository).should(never()).save(any());
    }
}
