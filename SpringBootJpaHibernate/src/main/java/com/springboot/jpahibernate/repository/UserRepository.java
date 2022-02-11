package com.springboot.jpahibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.jpahibernate.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
