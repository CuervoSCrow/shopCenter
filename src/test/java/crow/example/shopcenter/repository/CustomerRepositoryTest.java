package crow.example.shopcenter.repository;

import crow.example.shopcenter.entity.Address;
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
    public void saveCustomerWithAddressEmbeddedTest() {
        Address address = Address.builder()
                .city("Madrid")
                .mainStreet("Calle Mayor, 1")
                .secondaryStreet("Calle Minor, 2")
                .build();

        Customer customer = Customer.builder()
                .firstName("Alejandra")
                .email("alejandra@gmail.com")
                .address(address)
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
        List<Customer> customerList  = customerRepository
                .findByFirstNameIgnoreCaseContaining("a");
        for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }
    }

    @Test
    public void findByLastNameIgnoreCaseContainingTest() {
        List<Customer> customerList  = customerRepository
                .findByLastNameIgnoreCaseContaining("vidal");
        for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }
    }

    @Test
    public void findByLastNameNotNullTest() {
        List<Customer> customerList  = customerRepository
                .findByLastNameNotNull();
        for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }
    }

    @Test
    public void findByCustomerAddressCityIgnoreCaseContainingTest() {
        List<Customer> customerList  = customerRepository
                .findByAddress_CityIgnoreCaseContaining("mad");
        for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }
    }

    @Test
    public void findAllCustomersTest() {
        List<Customer> customers = customerRepository.findAll();
        customers.forEach(System.out::println);
    }



}