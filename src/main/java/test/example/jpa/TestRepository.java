package test.example.jpa;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import test.example.jpa.Entity.Customers;

public interface TestRepository extends JpaRepository<Customers, Integer> {

    @Override
    Optional<Customers> findById(Integer id);
}
