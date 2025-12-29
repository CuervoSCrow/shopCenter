package crow.example.shopcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import crow.example.shopcenter.entity.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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

    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    Customer getCustomerByEmailAddress(String email);

    @Query("SELECT c.firstName FROM Customer c WHERE c.email = :email")
    String getCustomerFirstNameByEmailAddress(String email);

    @Query(
            value = "SELECT * FROM tbl_customers WHERE email_address = :email",
            nativeQuery = true)
    Customer getCustomerByEmailAddressNative(String email);

    @Transactional
    @Modifying
    @Query (
            value = "UPDATE tbl_customers SET first_name = :firstName " +
                    "WHERE email_address = :email",
            nativeQuery = true)
    void updateCustomerNameByEmail(
            String firstName,
            String email);


}
