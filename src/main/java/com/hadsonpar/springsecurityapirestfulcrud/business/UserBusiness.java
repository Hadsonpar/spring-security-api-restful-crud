package com.hadsonpar.springsecurityapirestfulcrud.business;

import com.hadsonpar.springsecurityapirestfulcrud.entity.Users;
import com.hadsonpar.springsecurityapirestfulcrud.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserBusiness {
    @Autowired
    private IUsersRepository iUsersRepository;

    @GetMapping
    public List<Users> getAllUsers(){
        return iUsersRepository.findAll();
    }

    @PostMapping
    public Users createUsers(@RequestBody Users users){
        return iUsersRepository.save(users);
    }

    @GetMapping("{id}")
    public Users getIdUsers(@PathVariable("id") Long id) throws Exception {
        return iUsersRepository.findById(id).orElseThrow(
                () -> new Exception("No se encontró el registro"));
    }

    @PutMapping("/{id}")
    public Users updateUsers(@RequestBody Users users, @PathVariable("id") Long id) throws Exception {
        try {
            users.setId(id);
            return this.iUsersRepository.save(users);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró el registro", e);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUsers(@PathVariable("id") Long id) throws Exception {
        try {
            this.getIdUsers(id);
            iUsersRepository.deleteById(id);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontró el registro", e);
        }
    }
}
