package crow.example.shopcenter.repository;

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
                        .orderList(List.of(order, order2))
                        .build();

        localRepository.save(local);
    }

    @Test
    public void findAllLocalsWithOrdersTest(){
        List<Local> locals = localRepository.findAll();
        for(Local local : locals){
            System.out.println("local = " + local);
            System.out.println("Orders:");
            for(Order order : local.getOrderList()){
                System.out.println("\t" + order);
            }
        }
    }

}