package com.example.springbootrest.controllers;

import com.example.springbootrest.Service.interfaces.WorkplaceService;
import com.example.springbootrest.entity.Workplace;
import com.example.springbootrest.exception_handling.NoSuchWorkplaceException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/info")
public class WorkplaceController {
    private final WorkplaceService workplaceService;

    public WorkplaceController(WorkplaceService WorkplaceService) {
        this.workplaceService = WorkplaceService;
    }

    @GetMapping("/workplace")
    public List<Workplace> showAllWorkplace() {
        return workplaceService.getAllWorkplace();
    }

    @GetMapping("/workplace/{workplaceId}")
    public Workplace getWorkplaceById(@PathVariable String workplaceId) {
        Workplace workplace = workplaceService.getWorkplace(Integer.valueOf(workplaceId));
        if (workplace == null) {
            throw new NoSuchWorkplaceException("There is no workplace with ID = " + workplaceId + " " +
                    "in Database", new Throwable());
        }
        return workplace;
    }

    @GetMapping("/workplace/{workplaceName}/{workplaceCapitalization}")
    public Workplace findByNameAndCapitalization(@PathVariable String workplaceName,
                                                 @PathVariable Integer workplaceCapitalization) {
        Workplace workplace = workplaceService.findByNameAndCapitalization(workplaceName, workplaceCapitalization);
        if (workplace == null) {
            throw new NoSuchWorkplaceException("There is no workplace with NAME = " + workplaceName +
                    " and Capitalization = " + workplaceCapitalization + " in DB!", new Throwable());
        }
        return workplace;
    }

    @PostMapping("/workplace")
    public String addNewWorkplace(@RequestBody Workplace workplace) {
        workplaceService.saveWorkplace(workplace);
        return "Workplace was successfully added";
    }

    @DeleteMapping("/workplace/{id}")
    public String deleteWorkplace(@PathVariable int id) {
        Workplace workplace = workplaceService.getWorkplace(id);
        if (workplace == null) {
            throw new NoSuchWorkplaceException("There is no workplace with ID = " +
                    id + " in Database", new Throwable());
        }

        workplaceService.deleteWorkplace(id);
        return "Employee with ID = " + id + " was successfully deleted";
    }
}
