package com.example.springbootrest.DAO.Interfaces;

import com.example.springbootrest.entity.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WorkplaceRepository extends JpaRepository<Workplace, Integer> {
    Workplace findByNameAndCapitalization(String name, Integer capitalization);
    List<Workplace> findAllByName(String name);
}
