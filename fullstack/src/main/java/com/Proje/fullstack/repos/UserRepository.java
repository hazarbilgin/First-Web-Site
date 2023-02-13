package com.Proje.fullstack.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Proje.fullstack.Entities.c.User;




public interface UserRepository extends JpaRepository<User,Long> {

}
