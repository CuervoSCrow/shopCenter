package crow.example.shopcenter.repository;

import crow.example.shopcenter.entity.Local;
import crow.example.shopcenter.entity.Manager;
import crow.example.shopcenter.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrederRepositoryTest {

    @Autowired
    private OrederRepository orderRepository;

    @Test
    public void saveOrder(){

        Manager manager = Manager.builder()
                .firstName("Carlos")
                .lastName("Lopez")
                .build();

        Local local = Local.builder()
                .name("Binco")
                .floor("Fourth Floor")
                .build();

        Order order = Order.builder()
                .description("Camisa Tirnates Blanca")
                .price(10)
                .local(local)
                .build();

        orderRepository.save(order);
    }

}