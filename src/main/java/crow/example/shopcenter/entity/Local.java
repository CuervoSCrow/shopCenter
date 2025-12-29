package crow.example.shopcenter.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "manager")
public class Local {
    @Id
    @SequenceGenerator(
            name = "local_sequence",
            sequenceName = "local_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "local_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private long localId;

    private String name;
    private String floor;

    @OneToOne(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "manager_id",
            referencedColumnName = "managerId"
    )
    private Manager manager;
}
