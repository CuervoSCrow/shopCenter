package crow.example.shopcenter.repository;

import crow.example.shopcenter.entity.Local;
import crow.example.shopcenter.entity.Manager;
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

}