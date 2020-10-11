package com.sjsushil09.restfulwebservice.daoservice;

import com.sjsushil09.restfulwebservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService extends JpaRepository<User,Integer> {

}
