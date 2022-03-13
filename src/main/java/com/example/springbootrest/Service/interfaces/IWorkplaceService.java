package com.example.springbootrest.Service.interfaces;

import com.example.springbootrest.entity.Workplace;
import java.util.List;

public interface IWorkplaceService {
    List<Workplace> getAllWorkplace();
    void saveWorkplace(Workplace workplace);
    Workplace getWorkplace(Integer id);
    void deleteWorkplace(Integer id);
    List<Workplace> findAllWorkplaceByName(String name);
    Workplace findByNameAndCapitalization(String name, Integer capitalization);
}
