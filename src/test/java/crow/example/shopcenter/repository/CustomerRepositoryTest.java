package crow.example.shopcenter.repository;

import crow.example.shopcenter.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}