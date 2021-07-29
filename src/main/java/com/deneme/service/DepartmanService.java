package com.deneme.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.deneme.Model.Departman;
import com.deneme.Repository.BolumRepository;
import com.deneme.Repository.DepartmanRepository;


@Service
public class DepartmanService {
	@Autowired
	private DepartmanRepository repo;
	
	public List<Departman> listAll(){
		return repo.findAll();
		
	}
	
	public void save (Departman Departman) {
		repo.save(Departman);
	}
	
	public Departman get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}


	
}
