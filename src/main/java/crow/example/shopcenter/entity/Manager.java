package crow.example.shopcenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Manager {

    @Id
    @SequenceGenerator(
            name = "manager_sequence",
            sequenceName = "manager_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "manager_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private long managerId;

    private String firstName;
    private String lastName;


}
