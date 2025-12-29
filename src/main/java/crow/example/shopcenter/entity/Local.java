package crow.example.shopcenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @OneToOne
    @JoinColumn(
            name = "manager_id",
            referencedColumnName = "managerId"
    )
    private Manager manager;
}
