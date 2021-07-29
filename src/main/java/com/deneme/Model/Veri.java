package com.deneme.Model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "veri")
public class Veri implements Serializable {
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "firma_adi")
	private String firmaAdi;
	
	@Lob
	@Column(name = "pdf")
    private byte[] pdf;
	
	@Column(name = "tur")
	private String tur;
	
	@Column(name = "tarih")
	private Date tarih;
	
	@Column(name = "no")
	private String no;
	
	@Column(name = "kdvsiz_tutar")
	private String kdvsizTutar;
	
	@Column(name = "kdvsiz_tutar")
	private String kdvTutar;
	
	@Column(name = "toplam_tutar")
	private String toplamTutar;
	
	@Column(name = "kargo_firmasi")
	private String kargoFirmasi;
	
	@Column(name = "kargo_tarihi")
	private Date kargoTarihi;
	
	@Column(name = "detay")
	private String detay;
	
	@Column(name = "aciklama")
	private String aciklama;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getPdf() {
		return pdf;
	}

	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}

	public String getFirmaAdi() {
		return firmaAdi;
	}

	public void setFirmaAdi(String firmaAdi) {
		this.firmaAdi = firmaAdi;
	}

	public String getTur() {
		return tur;
	}

	public void setTur(String tur) {
		this.tur = tur;
	}

	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getKdvsizTutar() {
		return kdvsizTutar;
	}

	public void setKdvsizTutar(String kdvsizTutar) {
		this.kdvsizTutar = kdvsizTutar;
	}

	public String getKdvTutar() {
		return kdvTutar;
	}

	public void setKdvTutar(String kdvTutar) {
		this.kdvTutar = kdvTutar;
	}

	public String getToplamTutar() {
		return toplamTutar;
	}

	public void setToplamTutar(String toplamTutar) {
		this.toplamTutar = toplamTutar;
	}

	public String getKargoFirmasi() {
		return kargoFirmasi;
	}

	public void setKargoFirmasi(String kargoFirmasi) {
		this.kargoFirmasi = kargoFirmasi;
	}

	public Date getKargoTarihi() {
		return kargoTarihi;
	}

	public void setKargoTarihi(Date kargoTarihi) {
		this.kargoTarihi = kargoTarihi;
	}

	public String getDetay() {
		return detay;
	}

	public void setDetay(String detay) {
		this.detay = detay;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	
	
	

}
