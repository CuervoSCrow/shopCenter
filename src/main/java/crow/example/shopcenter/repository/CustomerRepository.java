package crow.example.shopcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import crow.example.shopcenter.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository
        extends JpaRepository<Customer,Long> {


    Optional<Customer> findByFirstName(String firstName);
    Optional<Customer> findByFirstNameIgnoreCase(String firstName);
    List<Customer> findByFirstNameIgnoreCaseContaining(String firstNamePart);
    List<Customer> findByLastNameIgnoreCaseContaining(String firstNamePart);
    List<Customer> findByLastNameNotNull();
    List<Customer> findByAddress_CityIgnoreCaseContaining(String city);

}
