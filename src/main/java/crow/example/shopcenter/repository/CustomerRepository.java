package crow.example.shopcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import crow.example.shopcenter.entity.Customer;

import java.util.Optional;

public interface CustomerRepository
        extends JpaRepository<Customer,Long> {


    Optional<Customer> findByFirstName(String firstName);
    Optional<Customer> findByFirstNameIgnoreCase(String firstName);
    Optional<Customer> findByFirstNameIgnoreCaseContaining(String firstNamePart);
}
