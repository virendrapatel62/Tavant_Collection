package com.feelfreetocode.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feelfreetocode.models.User;

public interface UserDao extends JpaRepository<User, Long>{

}
