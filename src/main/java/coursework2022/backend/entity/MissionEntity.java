package coursework2022.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "missions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cars_id")
    private CarEntity car;

    @Column(name = "route")
    private String route;

    @Column(name = "fuel")
    private int fuel;

    @Column(name = "price")
    private int price;

    @Column(name = "distance")
    private int distance;

    @Column(name = "duration")
    private String duration;

}
