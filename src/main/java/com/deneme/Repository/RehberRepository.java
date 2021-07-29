package com.deneme.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deneme.Model.Rehber;



@Repository
public interface RehberRepository extends JpaRepository<Rehber, Long> {

}
