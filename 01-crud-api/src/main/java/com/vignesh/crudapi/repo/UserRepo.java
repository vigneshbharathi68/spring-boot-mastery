package com.vignesh.crudapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vignesh.crudapi.model.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long>{
  List<UserModel> findByGender(String gender); 
  List<UserModel> findByEmail(String email);
}
