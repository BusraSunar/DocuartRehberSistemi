package com.deneme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.deneme.Model.Personel;
import com.deneme.Repository.PersonelRepository;

@Service
public class PersonelService {
	@Autowired
	private PersonelRepository repo;
	
	public List<Personel> listAll(){
		return repo.findAll();
		
	}
	
	public void save (Personel Personel) {
		repo.save(Personel);
	}
	
	public Personel get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

	public List<Personel> signIn(String name, String password) {
		Personel Personel = new Personel();
		Personel.setKullaniciAdi(name);
		Personel.setSifre(password);
		Example<Personel> ex = Example.of(Personel);
		return repo.findAll(ex);
	}
	
	public List<Personel> findName(String name){
		Personel Personel = new Personel();
		Personel.setAd(name);
		Example<Personel> ex = Example.of(Personel);
		return repo.findAll(ex);
	}
	
	public List<Personel> findByUserName(String userName){
		Personel Personel = new Personel();
		Personel.setKullaniciAdi(userName);
		Personel.setDurum("Aktif");
		Example<Personel> ex = Example.of(Personel);
		return repo.findAll(ex);
	}
	
	
	
	
	
	
}
