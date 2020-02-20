package com.deneme.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deneme.Model.User;

@Repository
public interface ProductRepository extends JpaRepository<User, Long> {

}
