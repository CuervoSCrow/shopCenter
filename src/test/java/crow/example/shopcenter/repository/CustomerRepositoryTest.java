package crow.example.shopcenter.repository;

import crow.example.shopcenter.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest{

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void saveCustomerTest(){
         Customer customer = Customer.builder()
                 .firstName("Juan")
                 .lastName("Sanz")
                 .email("juansanz@crow.com")
                    .build();
         customerRepository.save(customer);
    }

    @Test
    public void findByFirstNameTest() {
        Customer customer = customerRepository.findByFirstName("Juan").get();
        System.out.println("customer = " + customer);
    }

    @Test
    public void findByFirstNameIgnoreCaseTest() {
        Customer customer = customerRepository.findByFirstNameIgnoreCase("juAN").get();
        System.out.println("customer = " + customer);
    }

    @Test
    public void findByFirstNameIgnoreCaseContainingTest() {
        Customer customer = customerRepository
                .findByFirstNameIgnoreCaseContaining("ua")
                .get();
        System.out.println("customer = " + customer);
    }

    @Test
    public void findAllCustomersTest() {
        List<Customer> customers = customerRepository.findAll();
        customers.forEach(System.out::println);
    }

}