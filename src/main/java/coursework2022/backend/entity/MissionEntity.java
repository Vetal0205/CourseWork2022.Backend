package coursework2022.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;


@Entity
@Table(name = "missions", schema = "lfou")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "cars_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany
    @JoinTable(
            schema = "lfou",
            name = "mission_car",
            joinColumns = @JoinColumn(name = "mission_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    private List<CarEntity> cars;

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
