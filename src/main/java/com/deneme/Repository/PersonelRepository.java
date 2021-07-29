package com.deneme.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deneme.Model.Personel;


@Repository
public interface PersonelRepository extends JpaRepository<Personel, Long> {
}
