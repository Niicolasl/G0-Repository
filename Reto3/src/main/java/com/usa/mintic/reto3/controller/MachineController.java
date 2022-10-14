package com.usa.mintic.reto3.controller;


import com.usa.mintic.reto3.model.Client;
import com.usa.mintic.reto3.model.Machine;
import com.usa.mintic.reto3.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Machine")
public class MachineController {

    @Autowired
    private MachineService machineService;

    @GetMapping("/all")
    public List<Machine> getAll(){
        return machineService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine save(@RequestBody Machine p){
        return machineService.save(p);
    }

    @GetMapping("/{id}")
    public Optional<Machine> getMachine(@PathVariable("id")int machineId){
        return machineService.getMachine(machineId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine update(@RequestBody Machine machine) {
        return machineService.update(machine);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int machineId) {
        return machineService.delete(machineId);
    }

}

