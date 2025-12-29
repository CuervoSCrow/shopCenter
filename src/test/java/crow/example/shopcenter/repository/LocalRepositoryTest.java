package crow.example.shopcenter.repository;

import crow.example.shopcenter.entity.Customer;
import crow.example.shopcenter.entity.Local;
import crow.example.shopcenter.entity.Manager;
import crow.example.shopcenter.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LocalRepositoryTest {

    @Autowired
    private LocalRepository localRepository;

    @Test
    public void saveLocalTest(){
        Manager manager = Manager.builder()
                .firstName("Alice")
                .lastName("Johnson")
                .build();

        Local local =
                Local.builder()
                        .name("PetShop")
                        .floor("Second Floor")
                        .manager(manager)
                        .build();
        localRepository.save(local);
    }

    @Test
    public void findByAllLocalsTest(){
        List<Local> locals = localRepository.findAll();
        System.out.println("locals = " + locals);
    }

    @Test
    public void saveLocalWithOrdersTest(){
        Manager manager = Manager.builder()
                .firstName("Bob")
                .lastName("Smith")
                .build();

        Order order = Order.builder()
                .description("Entrada Pelicual 1, Sala 5")
                .price(6.50)
                .build();

        Order order2 = Order.builder()
                .description("Entrada Pelicula 2, Sala 3")
                .price(8.00)
                .build();

        Local local =
                Local.builder()
                        .name("Cinema")
                        .floor("Third Floor")
                        .manager(manager)
//                        .orderList(List.of(order, order2))
                        .build();

        localRepository.save(local);
    }

    @Test
    public void findAllLocalsWithOrdersTest(){
        List<Local> locals = localRepository.findAll();


    }

    @Test
    public void sabeLocalWithCustomersTest(){
        Manager manager = Manager.builder()
                .firstName("Diana")
                .lastName("Prince")
                .build();

        Customer customer = Customer.builder()
                .firstName("Bruce")
                .lastName("Wayne")
                .email("batman@gmail.com")
                .build();

        Customer customer2 = Customer.builder()
                .firstName("Clark")
                .lastName("Kent")
                .email("superman@gmail.com")
                .build();

        Local local =
                Local.builder()
                        .name("Clukin Bell")
                        .floor("First Floor")
//                        .manager(manager)
                        .customerList(List.of(customer,customer2))
                        .build();

        localRepository.save(local);
    }

    @Test
    public void findAllLocalsWithCustomersTest() {
        List<Local> locals = localRepository.findAll();
        System.out.println("locals = " + locals);
    }

    @Test
    public void findCustomerByLocalsTest() {
        Local local = localRepository.findById(10L).get();
        List<Customer> customerList = local.getCustomerList();
        for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }
    }

}