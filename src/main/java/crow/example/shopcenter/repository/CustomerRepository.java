package crow.example.shopcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import crow.example.shopcenter.entity.Customer;

public interface CustomerRepository
        extends JpaRepository<Customer,Long> {

}
