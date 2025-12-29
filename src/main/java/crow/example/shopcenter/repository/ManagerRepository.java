package crow.example.shopcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import crow.example.shopcenter.entity.Manager;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository
    extends JpaRepository<Manager,Long> {
}
