package com.example.springbootrest.Service.Implements;

import com.example.springbootrest.DAO.WorkplaceRepository;
import com.example.springbootrest.Service.interfaces.IWorkplaceService;
import com.example.springbootrest.entity.Workplace;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkplaceService implements IWorkplaceService {

    private final WorkplaceRepository workplaceRepository;

    public WorkplaceService(WorkplaceRepository workplaceRepository) {
        this.workplaceRepository = workplaceRepository;
    }

    @Override
    public List<Workplace> getAllWorkplace() {
        return workplaceRepository.findAll();
    }

    @Override
    public void saveWorkplace(Workplace workplace) {
        workplaceRepository.save(workplace);
    }

    @Override
    public Workplace getWorkplace(Integer id) {
        Workplace workplace = null;
        Optional<Workplace> optionalWorkplace = workplaceRepository.findById(id);
        if (optionalWorkplace.isPresent()){
            workplace = optionalWorkplace.get();
        }
        return workplace;
    }

    @Override
    public void deleteWorkplace(Integer id) {
        workplaceRepository.deleteById(id);
    }

    @Override
    public List<Workplace> findAllWorkplaceByName(String name) {
        return workplaceRepository.findAllByName(name);
    }

    @Override
    public Workplace findByNameAndCapitalization(String name, Integer capitalization) {
        return workplaceRepository.findByNameAndCapitalization(name, capitalization );
    }
}
