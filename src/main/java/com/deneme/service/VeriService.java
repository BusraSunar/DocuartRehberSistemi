package com.deneme.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.deneme.Model.Firma;
import com.deneme.Model.Veri;
import com.deneme.Repository.VeriRepository;


@Service
public class VeriService {
	@Autowired
	private VeriRepository repo;
	
	public List<Veri> listAll(){
		return repo.findAll();
		
	}
	
	public void save (Veri Veri) {
		repo.save(Veri);
	}
	
	public Veri get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

	
	public List<Veri> findName(String name){
		Veri Veri = new Veri();
		Veri.setFirmaAdi(name);
		Example<Veri> ex = Example.of(Veri);
		return repo.findAll(ex);
	}
	
	 
	
	
	
	
}
