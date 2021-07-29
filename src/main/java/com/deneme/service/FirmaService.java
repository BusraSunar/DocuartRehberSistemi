package com.deneme.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.deneme.Model.Firma;
import com.deneme.Repository.FirmaRepository;


@Service
public class FirmaService {
	@Autowired
	private FirmaRepository repo;
	
	public List<Firma> listAll(){
		return repo.findAll();
		
	}
	
	public void save (Firma Firma) {
		repo.save(Firma);
	}
	
	public Firma get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

	
	public List<Firma> findName(String name){
		Firma Firma = new Firma();
		Firma.setFirmaAdi(name);
		Example<Firma> ex = Example.of(Firma);
		return repo.findAll(ex);
	}
	
	public List<Firma> findByActivity(String durum){
		Firma Firma = new Firma();
		Firma.setDurum(durum);
		Example<Firma> ex = Example.of(Firma);
		return repo.findAll(ex);
	}
	
	
}
