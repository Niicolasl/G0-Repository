package com.usa.mintic.reto3.controller;

import com.usa.mintic.reto3.model.Admin;
import com.usa.mintic.reto3.model.Score;
import com.usa.mintic.reto3.service.AdminService;
import com.usa.mintic.reto3.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAll(){
        return adminService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin s){
        return adminService.save(s);
    }

    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id")int adminId){
        return adminService.getAdmin(adminId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin) {
        return adminService.update(admin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int adminId) {
        return adminService.delete(adminId);
    }

}
