package coursework2022.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "missions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ElementCollection
    @Column(name = "cars_id")
    private List<String> carsID;

    private String route;
    private int fuel;
    private int price;
    private int distance;
    private String duration;

}
