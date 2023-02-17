package com.hadsonpar.springsecurityapirestfulcrud.business;

import com.hadsonpar.springsecurityapirestfulcrud.entity.Users;

import java.util.List;

public interface IUserBusiness {
    public List<Users> getAllUsers();
    public Users createUsers(Users users);
    public Users getIdUsers(Long id) throws Exception;
    public Users updateUsers(Users users, Long id) throws Exception;
    public void deleteUsers(Long id) throws Exception;
}
