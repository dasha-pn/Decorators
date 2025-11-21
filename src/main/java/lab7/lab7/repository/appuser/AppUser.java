package lab7.lab7.repository.appuser;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name = "app_user",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "app_user_email_unique",
                        columnNames = "email"
                )
        }
)

@Getter
@Setter
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    private LocalDate dob;

    @Transient
    private Integer age;

    public AppUser() {
    }

    public AppUser(String email, LocalDate dob) {
        this.email = email;
        this.dob = dob;
    }

    public Integer getAge() {
        return dob == null
                ? null
                : Period.between(this.dob, LocalDate.now()).getYears();
    }
}
