package com.deneme.service;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.deneme.Model.Rehber;

import com.deneme.Repository.RehberRepository;


@Service
public class RehberService {
	@Autowired
	private RehberRepository repo;
	
	public List<Rehber> listAll(){
		return repo.findAll();
		
	}
	
	public void save (Rehber Rehber) {
		repo.save(Rehber);
	}
	
	public Rehber get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

	public List<Rehber> signIn(String name, String surname) {
		Rehber Rehber = new Rehber();
		Rehber.setAd(name);
		Rehber.setSoyad(surname);
		Example<Rehber> ex = Example.of(Rehber);
		return repo.findAll(ex);
	}
	
	public List<Rehber> findName(String name){
		Rehber Rehber = new Rehber();
		Rehber.setAd(name);
		Example<Rehber> ex = Example.of(Rehber);
		return repo.findAll(ex);
	}
	
	public List<Rehber> findByAssociateAndActivity(String associate, String durum){
		Rehber Rehber = new Rehber();
		Rehber.setPersonelBaglantisi(associate);
		Rehber.setDurum(durum);
		Example<Rehber> ex = Example.of(Rehber);
		return repo.findAll(ex);
	}
	
	public List<Rehber> findByNameAndSurnameAndAssociateAndActivity(String Associate, String name,String surname,String durum){
		Rehber Rehber = new Rehber();
		Rehber.setAd(name);
		Rehber.setSoyad(surname);
		Rehber.setPersonelBaglantisi(Associate);
		Rehber.setDurum(durum);
		Example<Rehber> ex = Example.of(Rehber);
		return repo.findAll(ex);
	}
	
	
	public List<Rehber> findByActivity(String durum){
		Rehber Rehber = new Rehber();
		Rehber.setDurum(durum);
		Example<Rehber> ex = Example.of(Rehber);
		return repo.findAll(ex);
	}
	
	
}
