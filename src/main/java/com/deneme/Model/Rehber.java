package com.deneme.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rehber")
public class Rehber implements Serializable {
	@Column(name = "id")
	private Long id;
	
	@Column(name = "ad")
	private String ad;
	
	@Column(name = "soyad")
	private String soyad;
	
	@Column(name = "firma_adi")
	private String firmaAdi;
	
	@Column(name = "sube")
	private String sube;
	
	@Column(name = "gorevi")
	private String gorevi;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "cep_telefonu")
	private String cepTelefonu;
	
	@Column(name = "is_telefonu")
	private String isTelefonu;
	
	@Column(name = "dahili")
	private String dahili;
	
	@Column(name = "personel_baglantisi")
	private String personelBaglantisi;
	
	@Column(name ="durum")
	private String durum;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getFirmaAdi() {
		return firmaAdi;
	}
	public void setFirmaAdi(String firmaAdi) {
		this.firmaAdi = firmaAdi;
	}
	public String getSube() {
		return sube;
	}
	public void setSube(String sube) {
		this.sube = sube;
	}
	public String getGorevi() {
		return gorevi;
	}
	public void setGorevi(String gorevi) {
		this.gorevi = gorevi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCepTelefonu() {
		return cepTelefonu;
	}
	public void setCepTelefonu(String cepTelefonu) {
		this.cepTelefonu = cepTelefonu;
	}
	public String getIsTelefonu() {
		return isTelefonu;
	}
	public void setIsTelefonu(String isTelefonu) {
		this.isTelefonu = isTelefonu;
	}
	public String getDahili() {
		return dahili;
	}
	public void setDahili(String dahili) {
		this.dahili = dahili;
	}
	public String getDurum() {
		return durum;
	}
	public void setDurum(String durum) {
		this.durum = durum;
	}
	public String getPersonelBaglantisi() {
		return personelBaglantisi;
	}
	public void setPersonelBaglantisi(String personelBaglantisi) {
		this.personelBaglantisi = personelBaglantisi;
	}
	
	
	

}
