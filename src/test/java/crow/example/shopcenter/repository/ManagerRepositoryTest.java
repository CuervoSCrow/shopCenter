package crow.example.shopcenter.repository;

import crow.example.shopcenter.entity.Manager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ManagerRepositoryTest {

    @Autowired
    private ManagerRepository managerRepository;

    @Test
    public void findAllManagersTest(){
        List<Manager> managers = managerRepository.findAll();
        for (Manager manager : managers) {
            System.out.println("manager = " + manager);
        }
    }

}