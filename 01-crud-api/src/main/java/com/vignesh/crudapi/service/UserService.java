package com.vignesh.crudapi.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vignesh.crudapi.model.UserModel;
import com.vignesh.crudapi.repo.UserRepo;


@Service
public class UserService {
  @Autowired
  private UserRepo userRepo;

  public List<UserModel> getAllUsers() {
    return userRepo.findAll();
  }

  public UserModel getUserById(Long id) {
    return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
  }

  public UserModel createUser(UserModel user) {
    return userRepo.save(user);
  }

  public UserModel updateUser(Long id, UserModel userDetails) {

    UserModel user = getUserById(id);
    user.setName(userDetails.getName());
    user.setEmail(userDetails.getEmail());
    user.setGender(userDetails.getGender());
    user.setAge(userDetails.getAge());

    return userRepo.save(user);

  }

  public void deleteUser(Long id) {
    userRepo.deleteById(id);
  } 





}
