package com.deneme.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.deneme.Model.Bolum;
import com.deneme.Repository.BolumRepository;


@Service
public class BolumService {
	@Autowired
	private BolumRepository repo;
	
	public List<Bolum> listAll(){
		return repo.findAll();
		
	}
	
	public void save (Bolum Bolum) {
		repo.save(Bolum);
	}
	
	public Bolum get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

	
	public List<Bolum> findByName(String name){
		Bolum Bolum = new Bolum();
		Bolum.setAd(name);
		Example<Bolum> ex = Example.of(Bolum);
		return repo.findAll(ex);
	}
	
	public List<Bolum> findByActivity(String durum){
		Bolum Bolum = new Bolum();
		Bolum.setDurum(durum);
		Example<Bolum> ex = Example.of(Bolum);
		return repo.findAll(ex);
	}
	
	
}
