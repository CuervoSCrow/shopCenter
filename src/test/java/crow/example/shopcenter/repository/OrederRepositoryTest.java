package crow.example.shopcenter.repository;

import crow.example.shopcenter.entity.Local;
import crow.example.shopcenter.entity.Manager;
import crow.example.shopcenter.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

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

    @Test
    public void findAllOrdersPaginationTest(){
       Pageable firstPageWithThreeElements =
               PageRequest.of(0,3);

       List<Order> orderList = orderRepository.findAll(firstPageWithThreeElements).getContent();
       long totalElements = orderRepository.findAll(firstPageWithThreeElements).getTotalElements();
       long totalPages = orderRepository.findAll(firstPageWithThreeElements).getTotalPages();
        System.out.println("totalElements = " + totalElements);
        System.out.println("totalPages = " + totalPages);
       for (Order order : orderList) {
           System.out.println("order = " + order);
       }

    }

    @Test
    public void fillAllOrdersWithSortingTest(){
        Pageable sortByPrice =
                PageRequest.of(
                        0,
                        3,
                        Sort.by("price")
                );
        Pageable sortByPriceDesc =
                PageRequest.of(
                        0,
                        3,
                        Sort.by("price").descending()
                );

        List<Order> orderList =
                orderRepository.findAll(sortByPriceDesc).getContent();

        for (Order order : orderList) {
            System.out.println("order = " + order);
        }
    }

    @Test
    public void findAllOrdersByDescriptionContainingIgnoreCaseTest(){
        Pageable firstPageWithTwoElements =
                PageRequest.of(0,5);

        List<Order> orderList =
                orderRepository.findByDescriptionContainingIgnoreCase(
                        "En",
                        firstPageWithTwoElements
                ).getContent();

        for (Order order : orderList) {
            System.out.println("order = " + order);
        }
    }

}