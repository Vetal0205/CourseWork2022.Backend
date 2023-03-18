package coursework2022.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cars")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

    private String name;

    private String power;

    @Column(name = "weigth")
    private String weight;

    @Column(name = "fuel_consumption")
    private String fuelConsumption;

    @Column(name = "fuel_range")
    private String fuelRange;

    @Column(name = "fuel_tank")
    private String fuelTank;

    private String crew;

    private String speed;

    private String production;

    private String image;
}
