package lab7.lab7;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lab7.lab7.repository.appuser.AppUser;
import lab7.lab7.repository.appuser.AppUserRepository;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository underTest;

    @Test
    void itShouldFindUserByEmail() {
        AppUser user = new AppUser(
                "test@example.com",
                LocalDate.of(2000, 1, 1)
        );
        underTest.save(user);

        Optional<AppUser> result = underTest.findUserByEmail("test@example.com");

        assertThat(result).isPresent();
        assertThat(result.get().getEmail()).isEqualTo("test@example.com");
    }
}
