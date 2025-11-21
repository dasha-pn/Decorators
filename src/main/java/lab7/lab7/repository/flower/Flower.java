package lab7.lab7.repository.flower;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flower")
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sepal_length")
    private double sepalLength;
    @Enumerated(EnumType.STRING)
    private FlowerColor color;
    private double price;
    @Enumerated(EnumType.STRING)
    private FlowerType type;

    public Flower(int price, FlowerColor color, int sepalLength, FlowerType type) {
        this.id = null;
        this.sepalLength = (double) sepalLength;
        this.color = color;
        this.price = (double) price;
        this.type = type;
    }
}
