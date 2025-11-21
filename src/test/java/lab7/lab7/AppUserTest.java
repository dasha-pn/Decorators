package lab7.lab7;

import org.junit.jupiter.api.Test;

import lab7.lab7.repository.appuser.AppUser;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {

    @Test
    void getAgeCalculatesCorrectly() {
        LocalDate dob = LocalDate.now().minusYears(20);
        AppUser user = new AppUser("test@example.com", dob);

        Integer age = user.getAge();

        assertEquals(20, age);
    }

    @Test
    void getAgeReturnsNullWhenDobNull() {
        AppUser user = new AppUser();
        user.setEmail("test@example.com");

        assertNull(user.getAge());
    }
}
