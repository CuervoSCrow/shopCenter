package crow.example.shopcenter.repository;

import crow.example.shopcenter.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrederRepository
        extends JpaRepository<Order,Long> {

    Page<Order> findByDescriptionContainingIgnoreCase(
            String description,
            Pageable pageable
    );
}
