package crow.example.shopcenter.entity;

import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name = "city",
                column = @Column(
                        name = "customer_city"
                )
        ),
        @AttributeOverride(
                name = "mainStreet",
                column = @Column(
                        name = "customer_main_street"
                )
        ),
        @AttributeOverride(
                name = "secondaryStreet",
                column = @Column(
                        name = "customer_secondary_street"
                )
        )
})
public class Address {
    private String city;
    private String mainStreet;
    private String secondaryStreet;
}

