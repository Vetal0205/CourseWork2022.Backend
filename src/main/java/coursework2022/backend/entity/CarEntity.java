package coursework2022.backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cars", schema = "lfou")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

    private String name;

    private String power;
    private int amount;
    @Column(name = "weigth")
    private String weight;

    @JsonProperty("fuel_consumption")
    @Column(name = "fuel_consumption")
    private String fuelConsumption;

    @JsonProperty("fuel_range")

    @Column(name = "fuel_range")
    private String fuelRange;

    @JsonProperty("fuel_tank")

    @Column(name = "fuel_tank")
    private String fuelTank;

    private String crew;

    private String speed;

    private String production;

    private String image;
}
