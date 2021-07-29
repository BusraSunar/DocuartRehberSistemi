package com.deneme.Controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.deneme.Model.*;

import com.deneme.service.RehberService;
import com.deneme.service.VeriService;
import com.deneme.service.BolumService;
import com.deneme.service.DepartmanService;
import com.deneme.service.FirmaService;
import com.deneme.service.PersonelService;
import com.deneme.service.mailService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 

@Controller
public class MainController {
	

	@Autowired
    private PersonelService service;
	
	@Autowired
	private RehberService RehberService;
	
	@Autowired
	private mailService mail;
	
	@Autowired
	private FirmaService FirmaService;
	
	@Autowired
	private VeriService VeriService;
	
	@Autowired
	private BolumService BolumService;
	
	@Autowired
	private DepartmanService DepartmanService;
	
	String kullanici="";
	String department="";
	//Suanki kullanici
	
	Long editId=(long) -1;	//fill metodunda bunu metoddan alip esitliyorsunn gunucellediginde de id uzerinde guncellenir
	String editName="";
	String editSurname="";
	String editActivity="";
	String editDepartman="";
	Boolean guncelle=true;
	Boolean kaydet=false;
	
	//yukarisi PersonelEkle sayfasi icin
	
	Long rehberEditId=(long)-1;
	String rehberEditName="";
	String rehberEditSurname="";
	String editFirmaAdi="";
	String editSube="";
	String editGorevi="";
	String editEmail="";
	String editCepTelefonu="";
	String editIsTelefonu="";
	String editDahili="";
	String editKim="";
	String editDurum="";
	Boolean guncelleButtonEnabled=true;
	Boolean kaydetButtonEnabled=false;
	
	//yukaridaki attributelar RehberEkle icin
	
	Long firmaEditId=(long)-1;
	String firmaAdiEdit="";
	String firmaDurumEdit="";
	Boolean ekleFirma=false;
	Boolean guncellemeFirma =true;

	
	//yukaridaki FirmaEkle icin attributelar
	
	String select="";
	String searchBar ="";
	
	//rehber sayfasindaki select ve search bar icin
	
	Long excelEditId=(long)-1;
	String excelEditFirmaAdi="";
	String excelEditTur="";
	java.sql.Date excelEditTarih;
	String excelEditNo="";
	String excelEditKdvsizTutar="";
	String excelEditKdvTutar="";
	String excelEditToplamTutar="";
	String excelEditKargo="";
	java.sql.Date excelEditKargoTarihi;
	String excelEditNot="";
	String excelEditAciklama="";
	Boolean excelGuncelle=true;
	Boolean excelKaydet=false;
	
	//yukardaki excelVeriGiris icin attributelar
	
	Boolean blockEnanbled=true; 
	Boolean blockKaydet=true;
	Boolean blockGuncelle=true;
	Long parametreEditId=(long)-1;
	String parametreEditBolumAdi="";
	String parametreEditParametre="";
	String parametreEditAciklama="";
	String parametreEditDurum="";
	
	//yukaridakiler parametre listesi ve parametre veri girisi icin attributelardir
	
	List<Personel> personelList=new ArrayList<Personel>();
	List<String> personelName=new ArrayList<String>();
	List<Rehber> RehberList = new ArrayList<Rehber>();
	List<Rehber> rehber = new ArrayList<Rehber>();
	List<Firma> firmaList=new ArrayList<Firma>();
	List<Firma> firmaAktifList = new ArrayList<Firma>();
	List<Veri> veriList = new ArrayList<Veri>();
	List<Bolum> bolumList = new ArrayList<Bolum>();
	List<Veri> zamanAralik =new ArrayList<Veri>();
	List<Departman> departmanList = new ArrayList<Departman>();
	
	@RequestMapping("/")
	public String home(){
		
		return "login";
	}
	
	@RequestMapping("/signIn")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, Model model) throws FileNotFoundException, IOException {
		
		String name = request.getParameter("userName");
		String password  = request.getParameter("password");
		
		String hashedPassword= encryptWithMD5(password);
		request.getSession().setAttribute("activeUser", null);
		String error=null;
		request.getSession().setAttribute("errorMessage",null);
		List<Personel> example= service.signIn(name, hashedPassword);
		ModelAndView mav = new ModelAndView("redirect:/ara");
		ModelAndView mav2 = new ModelAndView("redirect:/");
		if(!example.isEmpty()) {
			request.getSession().setAttribute("activeUser", example.get(0));
			kullanici=name;
			department=example.get(0).getDepartman();
			request.getSession().setAttribute("department", department);

			
			
			return mav;
		}else {
			error="Geçersiz Kullanıcı Adı veya Şifre";
			request.getSession().setAttribute("errorMessage",error);
			return mav2;
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		kullanici="";
		department="";
		request.getSession().setAttribute("department", department);
		request.getSession().setAttribute("activeUser", null);
		return "login";
		
	}
	
	public String encryptWithMD5(String passwordToHash) {
		String generatedPassword="";
		try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
		return generatedPassword;
	}
	
	@RequestMapping("/sifreDegistir")
	public String goToPasswordChangePage() {
		
			return "sifreDegistir";
	}
	
	@RequestMapping("/sifreYenile")
	public String changePassword(HttpServletRequest request) {
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String reNewPassword = request.getParameter("reNewPassword");
		List<Personel> kullaniciPersonel = service.findByUserName(kullanici);//Aktifleri gonder sadece
		if(newPassword.equals(reNewPassword)) {
			String oldHashedPassword = encryptWithMD5(oldPassword);
			if(kullaniciPersonel.get(0).getSifre().equals(oldHashedPassword)) {
				String newHashedPassword = encryptWithMD5(newPassword);
				kullaniciPersonel.get(0).setSifre(newHashedPassword);
				service.save(kullaniciPersonel.get(0));
			}else {
				return "sifreDegistir";
				
			}
		}else {
			return "sifreDegistir";
		}
		return "redirect:/ara";
		
	}
		
	@RequestMapping("/unuttum")
	public String forgotPage(HttpServletRequest request) {
		return "sifremiUnuttum";
		
	}
	
	@RequestMapping("/sifreGonder")
	public String forgot(HttpServletRequest request) throws MessagingException {
		String to = request.getParameter("email");
		String newPassword = RandomStringUtils.randomAlphanumeric(15);
		mail.send(to,newPassword);
		String user = request.getParameter("userName");
		List<Personel> personel = service.findByUserName(user);
		String hashedNewPassword = encryptWithMD5(newPassword);
		personel.get(0).setSifre(hashedNewPassword);
		service.save(personel.get(0));
		return "login";
	}
	
	@RequestMapping("/personelEkleSayfasi")
	public String personelEkleSayfasinaGecis(HttpServletRequest request){
		departman(request);
		personelList(request);
		adSoyadListele(request);
		makeItBlankForRehberEkle(request);
		makeItBlackForParametre(request);
		makeItBlackForFirma(request);
		makeItBlackForExcel(request);
		sogrulaSayfasiList(request);
		return "PersonelEkle";
		
	}

	@RequestMapping("/rehberEkleSayfasi")
	public String rehberEkleSayfasinaGecis(HttpServletRequest request,Model model){
		departman(request);
		personelList(request);
		adSoyadListele(request);
		displayTableInRehberEkle(model,request);
		makeItBlankForPersonel(request);
		makeItBlackForParametre(request);
		makeItBlackForFirma(request);
		makeItBlackForExcel(request);
		sogrulaSayfasiList(request);
		return "RehberEkle";
	}
	
	@RequestMapping("/ExcelVeriGirisiSayfasi")
	public String ExcelVeriGirisiSayfasi(HttpServletRequest request){
		bolumListele(request);
		bolumListesi(request);
		departman(request);
		aktifFirmaListesi(request);
		makeItBlackForParametre(request);
		makeItBlackForFirma(request);
		makeItBlankForPersonel(request);
		makeItBlankForRehberEkle(request);
		sogrulaSayfasiList(request);
		return "ExcelVeriGirisi";
		
	}

	@RequestMapping("/FirmaEkleSayfasi")
	public String FirmaEkleSayfasi(HttpServletRequest request,Model model){
		departman(request);
		makeItBlackForParametre(request);
		makeItBlankForPersonel(request);
		makeItBlackForExcel(request);
		makeItBlankForRehberEkle(request);
		sogrulaSayfasiList(request);
		return "FirmaEkle";
	}
	
	@RequestMapping("/ParametreListesiSayfasi")
	public String ParametreListesiSayfasi(HttpServletRequest request){
		makeItBlackForFirma(request);
		departman(request);
		makeItBlackForExcel(request);
		makeItBlankForPersonel(request);
		makeItBlackForParametre(request);
		makeItBlankForRehberEkle(request);
		sogrulaSayfasiList(request);
		return "ParametreListesi";
		
	}

	@RequestMapping("/ParametreVeriGirisiSayfasi")
	public String ParametreVeriGirisiSayfasi(HttpServletRequest request,Model model){
		departman(request);
		makeItBlackForFirma(request);	
		makeItBlackForExcel(request);
		makeItBlankForPersonel(request);
		makeItBlankForRehberEkle(request);
		sogrulaSayfasiList(request);
		return "ParametreVeriGirisi";
	}
	
	@RequestMapping("/SorgulaSayfasi")
	public String SorgulaSayfasi(HttpServletRequest request) {
		departman(request);
		sogrulaSayfasiList(request);
		return "Sorgula";
	}
	
	//sayfalara gecis saglayan metotlar
	
	public void makeItBlankForPersonel(HttpServletRequest request) {
		editId=(long) -1;
		request.getSession().setAttribute("boxName", "");
		request.getSession().setAttribute("boxSurname", "");
		request.getSession().setAttribute("dropDown", "");
	}
	
	public void makeItBlankForRehberEkle(HttpServletRequest request) {
		rehberEditId=(long) -1;
		request.getSession().setAttribute("adBox", "");
		request.getSession().setAttribute("soyadBox", "");
		request.getSession().setAttribute("firmaAdiBox", "");
		request.getSession().setAttribute("subeBox", "");
		request.getSession().setAttribute("goreviBox", "");
		request.getSession().setAttribute("emailBox", "");
		request.getSession().setAttribute("cepTelefonuBox", "");
		request.getSession().setAttribute("isTelefonuBox", "");
		request.getSession().setAttribute("dahiliBox", "");
		request.getSession().setAttribute("kimBox", "");
		request.getSession().setAttribute("dropdownRehber", "");
	}
	
	public void makeItBlackForParametre(HttpServletRequest request) {
		parametreEditId=(long) -1;
		request.getSession().setAttribute("bolumAdiBox","");
		request.getSession().setAttribute("parametreBox","");
		request.getSession().setAttribute("parametreAciklamaBox","");
		request.getSession().setAttribute("dropDownDurum","");
	}
	
	public void makeItBlackForFirma(HttpServletRequest request) {
		firmaEditId=(long) -1;
		request.getSession().setAttribute("firmaAdiFirmaBox", "");
		request.getSession().setAttribute("dropDownFirma", "");
		
		}
	
	public void makeItBlackForExcel(HttpServletRequest request) {
		excelEditId=(long) -1;
		request.getSession().setAttribute("excelDropdown", "");
		request.getSession().setAttribute("dropDownTUR", "");
		request.getSession().setAttribute("excelTarihBox", "");
		request.getSession().setAttribute("excelNoBox", "");
		request.getSession().setAttribute("excelKdvsizBox", "");
		request.getSession().setAttribute("excelKdvBox", "");
		request.getSession().setAttribute("excelToplamTutarBox", "");
		request.getSession().setAttribute("excelKargoBox", "");
		request.getSession().setAttribute("excelKargoTarihBox", "");
		request.getSession().setAttribute("excelDetayBox", "");
		request.getSession().setAttribute("excelAciklamaBox", "");
		
	}
	
	//make the inputs blank
	
	@RequestMapping("/listele")
	public String listele(Model model, HttpServletRequest request){
		Personel personel = new Personel();
		model.addAttribute("personel", personel);
		String queryName = request.getParameter("serachPersonel");
		request.getSession().setAttribute("guncelle",guncelle );
		request.getSession().setAttribute("kaydet",kaydet );
		if(queryName!=null && queryName.length()>0 ) {
			personelList=service.findName(queryName);
			request.getSession().setAttribute("listPersonel", personelList);
			
		}else {
			personelList = service.listAll();
			for(int i=0;i<personelList.size();i++) {
				personelName.add(personelList.get(i).getAd());
			}

			request.getSession().setAttribute("listPersonel", personelList);
			request.getSession().setAttribute("listName", personelName);
			
		}
		
		return "redirect:/personelEkleSayfasi";
	}
	
	@RequestMapping("/Buttons")
    public String Buttons(@ModelAttribute ("personel") Personel personel,HttpServletRequest request){
		if(request.getParameter("Kaydet")!=null) {
			String UserName = request.getParameter("ad").toLowerCase() +"." + request.getParameter("soyad").toLowerCase();
			personel.setKullaniciAdi(UserName);
			String hashedPassword = encryptWithMD5("");
			personel.setSifre(hashedPassword);
			personel.setDepartman(request.getParameter("departman"));
			service.save(personel);
		}else if(request.getParameter("Güncelle")!=null) {

			String newName= request.getParameter("ad"); 
			String newUserName = request.getParameter("ad").toLowerCase() +"." + request.getParameter("soyad").toLowerCase();
			String newSurname= request.getParameter("soyad");
			String newActivity= request.getParameter("durum");
			String newDepartman = request.getParameter("departman");
			
			Personel personelNew = new Personel();
			Personel sifreAl = service.get(editId);
			personelNew.setId(editId);
			personelNew.setAd(newName);
			personelNew.setSoyad(newSurname);
			personelNew.setKullaniciAdi(newUserName);
			personelNew.setSifre(sifreAl.getSifre());
			personelNew.setDurum(newActivity);
			personelNew.setDepartman(newDepartman);
			
			service.save(personelNew);
			editId=(long) -1;
			request.getSession().setAttribute("boxName", "");
			request.getSession().setAttribute("boxSurname", "");
			request.getSession().setAttribute("dropDown", "");
			request.getSession().setAttribute("dropDownDepartman", "");

			
			guncelle=true;
			kaydet=false;
			
			request.getSession().setAttribute("guncelle",guncelle );
			request.getSession().setAttribute("kaydet",kaydet );
		}else if(request.getParameter("Temizle")!=null) {
			
			request.getSession().setAttribute("boxName", "");
			request.getSession().setAttribute("boxSurname", "");
			request.getSession().setAttribute("dropDown", "");
			request.getSession().setAttribute("dropDownDepartman", "");

			request.getSession().setAttribute("guncelle",guncelle );
			request.getSession().setAttribute("kaydet",kaydet );
		}
		
		return "redirect:/listele";
	
    }
	
	@RequestMapping("fill")
	public String fillTextBox(@RequestParam("id") Long id, HttpServletRequest request) {
		editId=id;
		Personel personel = service.get(editId);
		editName = personel.getAd();
		editSurname = personel.getSoyad();
		editDepartman = personel.getDepartman();
		editActivity = personel.getDurum();
		request.getSession().setAttribute("boxName", editName);
		request.getSession().setAttribute("boxSurname", editSurname);
		request.getSession().setAttribute("dropDown", editActivity);
		request.getSession().setAttribute("dropDownDepartman", editDepartman);

		guncelle=false;
		kaydet=true;
		
		request.getSession().setAttribute("guncelle",guncelle );
		request.getSession().setAttribute("kaydet",kaydet );
	    return "redirect:/listele";
	}
	
	/*@RequestMapping("delete") //buranin calisma mantigini sor (amaci textboxlarin icindekini silmek mi yoksa datayi silmek mi)
	public String deleteFromTable(@RequestParam("id") Long id) {
		service.delete(id);
	    return "redirect:/listele";
	}*/

	//buraya kadar olanlar personelEkle sayfasi icindi
	
	public void adSoyadListele(HttpServletRequest request) {
		List<String> adSoyad = new ArrayList<String>();
		for(int i=0;i<personelList.size();i++) { //herhalde sadece aktif personellerin rehberi gorulmek istenir 
			if(personelList.get(i).getDurum().equalsIgnoreCase("Aktif"))
				adSoyad.add(personelList.get(i).getAd() + " " + personelList.get(i).getSoyad());
		}
		request.getSession().setAttribute("adSoyad", adSoyad);
		 
	}

	public void personelList(HttpServletRequest request) {
		personelList = service.listAll();
		request.getSession().setAttribute("listPersonel", personelList);
		
	}
	
	//yukaridaki iki metod global
	
	public void displayTableInRehberEkle(Model model,HttpServletRequest request) {
		RehberList = RehberService.listAll();
		request.getSession().setAttribute("listRehber", RehberList);
		
	}
	
	public void sogrulaSayfasiList(HttpServletRequest request) {
		zamanAralik = VeriService.listAll();
		request.getSession().setAttribute("listVeri", zamanAralik);
	}
	
	public void bolumListesi(HttpServletRequest request) {
		List<Bolum> list = BolumService.listAll();
		request.getSession().setAttribute("bolumExcel", list);
	}
	
	public void departman(HttpServletRequest request) {
		departmanList = DepartmanService.listAll();
		request.getSession().setAttribute("departmanList", departmanList);
	}
	@RequestMapping("/ara")
	public String rehberList(HttpServletRequest request, Model model ) throws FileNotFoundException, IOException {
		personelList(request);
		departman(request);
		adSoyadListele(request);
		displayTableInRehberEkle(model,request);
		makeItBlankForPersonel(request);
		makeItBlackForFirma(request);
		makeItBlackForExcel(request);
		sogrulaSayfasiList(request);
		makeItBlankForRehberEkle(request);

		List<String> rehberName = new ArrayList<String>();
		select = request.getParameter("sec"); //Rehber sayfasindaki aktif personelden secim
		searchBar = request.getParameter("searchBar"); //rehber sayfasindaki  searchBar
		request.getSession().setAttribute("guncelleRehber",guncelleButtonEnabled );
		request.getSession().setAttribute("kaydetRehber",kaydetButtonEnabled );
		if(select==null || select.length()==0) {
			rehber = RehberService.findByActivity("Aktif");
			for(int i=0;i<rehber.size();i++) {
				rehberName.add(rehber.get(i).getAd() + "  " + rehber.get(i).getSoyad());
			}
		}else if(select.length()>0 && (searchBar==null || searchBar.length()==0 )) {
			rehber = RehberService.findByAssociateAndActivity(select,"Aktif");
			
		}else if(select.length()>0 && searchBar.length()>0) {
			int k = searchBar.indexOf("  ");//to differ name and surname because the person could have multiple names and surnames
			String name = searchBar.substring(0,k);
			String surname = searchBar.substring(k+2);

			rehber = RehberService.findByNameAndSurnameAndAssociateAndActivity(select, name , surname ,"Aktif");
			
		}
		request.getSession().setAttribute("listRehberName", rehberName);
		request.getSession().setAttribute("listAssocaites", rehber);
		
		return "Rehber";

	}
	
	//yukaridaki rehber icin metot
	
	@RequestMapping("/rehberEkleButtons")
    public String Buttons2(HttpServletRequest request){
		if(request.getParameter("KaydetRehber")!=null) {
			Rehber Rehber = new Rehber();
			Rehber.setAd(request.getParameter("ad"));
			Rehber.setSoyad(request.getParameter("soyad"));
			Rehber.setFirmaAdi(request.getParameter("firmaAdi"));
			Rehber.setSube(request.getParameter("sube"));
			Rehber.setGorevi(request.getParameter("gorevi"));
			Rehber.setEmail(request.getParameter("email"));
			Rehber.setCepTelefonu(request.getParameter("cepTelefonu"));
			Rehber.setIsTelefonu(request.getParameter("isTelefonu"));
			Rehber.setDahili(request.getParameter("dahili"));
			Rehber.setPersonelBaglantisi(request.getParameter("kim"));
			Rehber.setDurum(request.getParameter("durumRehber"));
			RehberService.save(Rehber);
			
		}else if(request.getParameter("GüncelleRehber")!=null) {
			Rehber Rehber = new Rehber();
			Rehber.setId(rehberEditId);
			Rehber.setAd(request.getParameter("ad"));
			Rehber.setSoyad(request.getParameter("soyad"));
			Rehber.setFirmaAdi(request.getParameter("firmaAdi"));
			Rehber.setSube(request.getParameter("sube"));
			Rehber.setGorevi(request.getParameter("gorevi"));
			Rehber.setEmail(request.getParameter("email"));
			Rehber.setCepTelefonu(request.getParameter("cepTelefonu"));
			Rehber.setIsTelefonu(request.getParameter("isTelefonu"));
			Rehber.setDahili(request.getParameter("dahili"));
			Rehber.setPersonelBaglantisi(request.getParameter("kim"));
			Rehber.setDurum(request.getParameter("durumRehber"));
			RehberService.save(Rehber);
			
			rehberEditId=(long) -1;
			request.getSession().setAttribute("adBox", "");
			request.getSession().setAttribute("soyadBox", "");
			request.getSession().setAttribute("firmaAdiBox", "");
			request.getSession().setAttribute("subeBox", "");
			request.getSession().setAttribute("goreviBox", "");
			request.getSession().setAttribute("emailBox", "");
			request.getSession().setAttribute("cepTelefonuBox", "");
			request.getSession().setAttribute("isTelefonuBox", "");
			request.getSession().setAttribute("dahiliBox", "");
			request.getSession().setAttribute("kimBox", "");
			request.getSession().setAttribute("dropdownRehber", "");
			
			guncelleButtonEnabled=true;
			kaydetButtonEnabled=false;
			
			request.getSession().setAttribute("guncelleRehber",guncelleButtonEnabled );
			request.getSession().setAttribute("kaydetRehber",kaydetButtonEnabled );

			
		}else if(request.getParameter("TemizleRehber")!=null) {
			//RehberService.delete(rehberEditId);
			request.getSession().setAttribute("adBox", "");
			request.getSession().setAttribute("soyadBox", "");
			request.getSession().setAttribute("firmaAdiBox", "");
			request.getSession().setAttribute("subeBox", "");
			request.getSession().setAttribute("goreviBox", "");
			request.getSession().setAttribute("emailBox", "");
			request.getSession().setAttribute("cepTelefonuBox", "");
			request.getSession().setAttribute("isTelefonuBox", "");
			request.getSession().setAttribute("dahiliBox", "");
			request.getSession().setAttribute("kimBox", "");
			request.getSession().setAttribute("dropdownRehber", "");

		}
		
		return "redirect:/rehberEkleSayfasi";
	
    }
	
	@RequestMapping("fillRehber")
	public String fillTextBoxRehber(@RequestParam("id") Long id, HttpServletRequest request) {
		Rehber Rehber =RehberService.get(id);
		rehberEditId=id;
		rehberEditName=Rehber.getAd();
		rehberEditSurname=Rehber.getSoyad();
		editFirmaAdi=Rehber.getFirmaAdi();
		editSube=Rehber.getSube();
		editGorevi=Rehber.getGorevi();
		editEmail=Rehber.getEmail();
		editCepTelefonu=Rehber.getCepTelefonu();
		editIsTelefonu=Rehber.getIsTelefonu();
		editDahili=Rehber.getDahili();
		editKim=Rehber.getPersonelBaglantisi();
		editDurum=Rehber.getDurum();
		
		guncelleButtonEnabled=false;
		kaydetButtonEnabled=true;
		
		request.getSession().setAttribute("adBox", rehberEditName);
		request.getSession().setAttribute("soyadBox", rehberEditSurname);
		request.getSession().setAttribute("firmaAdiBox", editFirmaAdi);
		request.getSession().setAttribute("subeBox", editSube);
		request.getSession().setAttribute("goreviBox", editGorevi);
		request.getSession().setAttribute("emailBox", editEmail);
		request.getSession().setAttribute("cepTelefonuBox", editCepTelefonu);
		request.getSession().setAttribute("isTelefonuBox", editIsTelefonu);
		request.getSession().setAttribute("dahiliBox", editDahili);
		request.getSession().setAttribute("kimBox", editKim);
		request.getSession().setAttribute("dropdownRehber", editDurum);

		request.getSession().setAttribute("guncelleRehber",guncelleButtonEnabled );
		request.getSession().setAttribute("kaydetRehber",kaydetButtonEnabled );
		
	    return "redirect:/rehberEkleSayfasi";
	}
	
	@RequestMapping("/listeleFirma")
	public String listeleFirma(HttpServletRequest request) {
		
		
		firmaList=FirmaService.listAll();
		request.getSession().setAttribute("firmaList", firmaList);

		request.getSession().setAttribute("ekleFirma",ekleFirma );
		request.getSession().setAttribute("guncellemeFirma",guncellemeFirma );
		return "redirect:/FirmaEkleSayfasi";
		
	}
	
	@RequestMapping("buttonsFirma")
	public String buttonsFirma(HttpServletRequest request) {
		
		if(request.getParameter("EkleFirma")!=null) {
			Firma firma = new Firma();
			firma.setFirmaAdi(request.getParameter("firmaAdiFirma"));
			firma.setDurum(request.getParameter("firmaDurum"));
			FirmaService.save(firma);
			
		}else if(request.getParameter("GüncelleFirma")!=null) {
			Firma firma = new Firma();
			firma.setId(firmaEditId);
			firma.setFirmaAdi(request.getParameter("firmaAdiFirma"));
			firma.setDurum(request.getParameter("firmaDurum"));
			FirmaService.save(firma);

			firmaEditId=(long) -1;
			request.getSession().setAttribute("firmaAdiFirmaBox", "");
			request.getSession().setAttribute("dropDownFirma", "");
			
			guncellemeFirma=true;
			ekleFirma=false;
			
			request.getSession().setAttribute("ekleFirma",ekleFirma );
			request.getSession().setAttribute("guncellemeFirma",guncellemeFirma );

			
		}
		
		return "redirect:/listeleFirma";
	}
	
	@RequestMapping("fillFirma")
	public String fillFirma(@RequestParam("id") Long id, HttpServletRequest request) {
		Firma firma = FirmaService.get(id);
		firmaEditId = id;
		firmaAdiEdit = firma.getFirmaAdi();
		firmaDurumEdit = firma.getDurum();
		guncellemeFirma=false;
		ekleFirma=true;
		
		request.getSession().setAttribute("firmaAdiFirmaBox", firmaAdiEdit);
		request.getSession().setAttribute("dropDownFirma", firmaDurumEdit);

		request.getSession().setAttribute("ekleFirma",ekleFirma );
		request.getSession().setAttribute("guncellemeFirma",guncellemeFirma );
		
	    return "redirect:/FirmaEkleSayfasi";
	}
	
	//yurkardaki metotlar FirmaEkle icin
		
	public void aktifFirmaListesi(HttpServletRequest request) {
		
		firmaAktifList=FirmaService.findByActivity("Aktif");
		request.getSession().setAttribute("firmaAktifList", firmaAktifList);
		
	}
	
	@RequestMapping("/listeleExcel")
	public String listeleExcel(HttpServletRequest request) {
		//DateTime currentDate = new DateTime();
		aktifFirmaListesi(request);
		List<String> veriFirmaAdi = new ArrayList<String>();
		List<Veri> son1Ay =  VeriService.listAll();
			//veriList = VeriService.listAll();
			/*for(int i=0;i<veriList.size();i++) {
				DateTime time = new DateTime(veriList.get(i).getTarih());
				Days diffInDays = Days.daysBetween(time, currentDate);
				if(diffInDays.getDays()<=30 && diffInDays.getDays()>=0) {
					son1Ay.add(veriList.get(i));
					veriFirmaAdi.add(veriList.get(i).getFirmaAdi());
				}

			}*/

		request.getSession().setAttribute("veriFirmaAdi", veriFirmaAdi);

		request.getSession().setAttribute("son1Ay", son1Ay);
		request.getSession().setAttribute("excelKaydet",excelKaydet );
		request.getSession().setAttribute("excelGuncelle",excelGuncelle );

		return "redirect:/ExcelVeriGirisiSayfasi";
	}
		
	@RequestMapping("/veriButtons")
    public String veriButtons(HttpServletRequest request, @RequestParam("pdf") MultipartFile file) throws ParseException, FileNotFoundException, IOException{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if(request.getParameter("excelKaydet")!=null) {
			Veri veri = new Veri();

			java.util.Date date = formatter.parse(request.getParameter("excelTarih"));
			java.sql.Date sqlDate = new Date(date.getTime());
			java.util.Date date2 = formatter.parse(request.getParameter("excelKargoTarih"));
			java.sql.Date sqlDate2 = new Date(date2.getTime());
			
			
			veri.setFirmaAdi(request.getParameter("dropDownExcel"));
			veri.setPdf(file.getBytes());
			veri.setTur(request.getParameter("dropDownTur"));
			veri.setTarih(sqlDate);
			veri.setNo(request.getParameter("excelNo"));
			veri.setKdvsizTutar(request.getParameter("excelKdvsiz"));
			veri.setKdvTutar(request.getParameter("excelKdv"));
			veri.setToplamTutar(request.getParameter("excelToplamTutar"));
			veri.setKargoFirmasi(request.getParameter("excelKargo"));
			veri.setKargoTarihi(sqlDate2);
			veri.setDetay(request.getParameter("excelDetay"));
			veri.setAciklama(request.getParameter("excelAciklama"));
			
			VeriService.save(veri);
			
		}else if(request.getParameter("excelGüncelle")!=null) {
			Veri veri = new Veri();
			java.util.Date date = formatter.parse(request.getParameter("excelTarih"));
			java.sql.Date sqlDate = new Date(date.getTime());
			java.util.Date date2 = formatter.parse(request.getParameter("excelKargoTarih"));
			java.sql.Date sqlDate2 = new Date(date2.getTime());
			System.out.println("ID= " + excelEditId);
			veri.setId(excelEditId);
			veri.setFirmaAdi(request.getParameter("dropDownExcel"));
			veri.setPdf(file.getBytes());
			veri.setTur(request.getParameter("dropDownTur"));
			veri.setTarih(sqlDate);
			veri.setNo(request.getParameter("excelNo"));
			veri.setKdvsizTutar(request.getParameter("excelKdvsiz"));
			veri.setKdvTutar(request.getParameter("excelKdv"));
			veri.setToplamTutar(request.getParameter("excelToplamTutar"));
			veri.setKargoFirmasi(request.getParameter("excelKargo"));
			veri.setKargoTarihi(sqlDate2);
			veri.setDetay(request.getParameter("excelDetay"));
			veri.setAciklama(request.getParameter("excelAciklama"));
			
			VeriService.save(veri);
			excelEditId=(long) -1;
			request.getSession().setAttribute("excelDropdown", "");
			request.getSession().setAttribute("dropDownTUR", "");
			request.getSession().setAttribute("excelTarihBox", "");
			request.getSession().setAttribute("excelNoBox", "");
			request.getSession().setAttribute("excelKdvsizBox", "");
			request.getSession().setAttribute("excelKdvBox", "");
			request.getSession().setAttribute("excelToplamTutarBox", "");
			request.getSession().setAttribute("excelKargoBox", "");
			request.getSession().setAttribute("excelKargoTarihBox", "");
			request.getSession().setAttribute("excelDetayBox", "");
			request.getSession().setAttribute("excelAciklamaBox", "");
			
			excelGuncelle=true;
			excelKaydet=false;
			
			request.getSession().setAttribute("excelGuncelle",excelGuncelle );
			request.getSession().setAttribute("excelKaydet",excelKaydet );

			
		}else if(request.getParameter("excelTemizle")!=null) {
			request.getSession().setAttribute("excelDropdown", "");
			request.getSession().setAttribute("dropDownTUR", "");
			request.getSession().setAttribute("excelTarihBox", "");
			request.getSession().setAttribute("excelNoBox", "");
			request.getSession().setAttribute("excelKdvsizBox", "");
			request.getSession().setAttribute("excelKdvBox", "");
			request.getSession().setAttribute("excelToplamTutarBox", "");
			request.getSession().setAttribute("excelKargoBox", "");
			request.getSession().setAttribute("excelKargoTarihBox", "");
			request.getSession().setAttribute("excelDetayBox", "");
			request.getSession().setAttribute("excelAciklamaBox", "");

		}
		
		return "redirect:/buttonsSorgula";
	
    }
	
	@RequestMapping("fillExcel")
	public String fillExcel(@RequestParam("id") Long id, HttpServletRequest request) {
		Veri veri = VeriService.get(id);
		excelEditId=id;
		excelEditFirmaAdi=veri.getFirmaAdi();
		excelEditTur=veri.getTur();
		excelEditTarih=veri.getTarih();
		excelEditNo=veri.getNo();
		excelEditKdvsizTutar=veri.getKdvsizTutar();
		excelEditKdvTutar=veri.getKdvTutar();
		excelEditToplamTutar=veri.getToplamTutar();
		excelEditKargo=veri.getKargoFirmasi();
		excelEditKargoTarihi=veri.getKargoTarihi();
		excelEditNot=veri.getDetay();
		excelEditAciklama=veri.getAciklama();
		
		
		excelGuncelle=false;
		excelKaydet=true;
		
		request.getSession().setAttribute("excelDropdown", excelEditFirmaAdi);
		request.getSession().setAttribute("dropDownTUR",excelEditTur);
		request.getSession().setAttribute("excelTarihBox", excelEditTarih);
		request.getSession().setAttribute("excelNoBox", excelEditNo);
		request.getSession().setAttribute("excelKdvsizBox", excelEditKdvsizTutar);
		request.getSession().setAttribute("excelKdvBox", excelEditKdvTutar);
		request.getSession().setAttribute("excelToplamTutarBox",excelEditToplamTutar);
		request.getSession().setAttribute("excelKargoBox", excelEditKargo);
		request.getSession().setAttribute("excelKargoTarihBox", excelEditKargoTarihi);
		request.getSession().setAttribute("excelDetayBox", excelEditNot);
		request.getSession().setAttribute("excelAciklamaBox", excelEditAciklama);

		request.getSession().setAttribute("excelGuncelle",excelGuncelle );
		request.getSession().setAttribute("excelKaydet",excelKaydet );
		
	    return "redirect:/listeleExcel";
	}
	
	public void writeToExcel(List<Veri> zamanAralik ,HttpServletResponse response) throws FileNotFoundException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Fatura");
         
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        Font font = sheet.getWorkbook().createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 14);
        cellStyle.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
        cellStyle.setFont(font);
     
        String[] header = {"FIRMA ADI","TÜRÜ","TARIH","NO","KDV'SİZ TUTAR","KDV TUTARI","TOPLAM TUTARI","KARGO FİRMASI","KARGO TARİHİ","NOT","AÇIKLAMA"};
        Row row2 = sheet.createRow(0);
        row2.setHeightInPoints((2 * sheet.getDefaultRowHeightInPoints()));
        
        for(int i=0;i<header.length;i++) {
        	Cell cellTitle = row2.createCell(i);
            cellTitle.setCellStyle(cellStyle);
            cellTitle.setCellValue(header[i]);
        }
           
       Object[][] book = new Object[7][11];
       for(int i=0;i<zamanAralik.size();i++) {
		   book[i][0]=zamanAralik.get(i).getFirmaAdi();
		   book[i][1]=zamanAralik.get(i).getTur();
		   book[i][2]= ""+zamanAralik.get(i).getTarih();
		   book[i][3]=zamanAralik.get(i).getNo();
		   book[i][4]=zamanAralik.get(i).getKdvsizTutar();
		   book[i][5]=zamanAralik.get(i).getKdvTutar();
		   book[i][6]=zamanAralik.get(i).getToplamTutar();
		   book[i][7]=zamanAralik.get(i).getKargoFirmasi();
		   book[i][8]=""+zamanAralik.get(i).getKargoTarihi();
		   book[i][9]=zamanAralik.get(i).getDetay();
		   book[i][10]=zamanAralik.get(i).getAciklama();
    	   
       }
        
 
        int rowCount = 0;
        for (Object[] aBook : book) {
    		Row row = sheet.createRow(++rowCount);
            row.setHeightInPoints((2 * sheet.getDefaultRowHeightInPoints()));          
            int columnCount = 0;
            for (Object field : aBook) {
                Cell cell = row.createCell(columnCount++);
                if (field instanceof String) 
                    cell.setCellValue((String) field);
                 else if (field instanceof Integer) 
                    cell.setCellValue((Integer) field);  
            }
             
        }
        
        for(int i=0;i<12;i++) {
        	sheet.setColumnWidth(i,2 * sheet.getColumnWidth(i) );
        }

        
        response.setContentType("application/vnd.ms-excel");
        response.addHeader("content-disposition", "attachment; filename="+"Fatura.xlsx");	
    	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        byte[] bytes = outputStream.toByteArray();

		OutputStream os= response.getOutputStream();
		os.write(bytes);
		os.flush();
		os.close();
		         
       
	}

		
	//yukardaki metotlar excel veri giris cikis sayfasi icin
	
	@RequestMapping("/bolumListele")
	public String bolumListele(HttpServletRequest request) {
		String search = (String) request.getAttribute("deneme");
		//List<String> bolumAdiList = new ArrayList<>();
		
		if(search ==null || search.length()==0) {
			bolumList = BolumService.findByActivity("Aktif");
			/*for(int i=0;i<bolumList.size();i++) {
				bolumAdiList.add(bolumList.get(i).getAd());
			}*/
			
		}
		
		//request.getSession().setAttribute("bolumAdiList", bolumAdiList);
		request.getSession().setAttribute("bolumList", bolumList);
		
		return "redirect:/ParametreListesiSayfasi";
	}
	
	@RequestMapping("/BolumButtons")
    public String BolumButtons(HttpServletRequest request){
		if(request.getParameter("bolumYeniBolum")!=null) {
			blockEnanbled=false;
			blockKaydet=false;
			blockGuncelle=true;
			makeItBlackForParametre(request);
			request.getSession().setAttribute("blockEnanbled", blockEnanbled);
			request.getSession().setAttribute("blockKaydet", blockKaydet);
			request.getSession().setAttribute("blockGuncelle", blockGuncelle);
			
		}else if(request.getParameter("bolumYeniParametre")!=null) {
			blockEnanbled=true;
			blockKaydet=false;
			blockGuncelle=true;
			
			/*parametreEditId = BolumService.findByName(request.getParameter("dropDownParametre")).get(0).getId();
			Bolum bolum = BolumService.get(parametreEditId);
			parametreEditBolumAdi=bolum.getAd();
			parametreEditAciklama = bolum.getAciklama();
			parametreEditDurum = bolum.getDurum();*/
			
			/*request.getSession().setAttribute("bolumAdiBox",parametreEditBolumAdi);
			request.getSession().setAttribute("parametreAciklamaBox",parametreEditAciklama);
			request.getSession().setAttribute("dropDownDurum",parametreEditDurum);*/
			request.getSession().setAttribute("bolumAdiBox",request.getParameter("dropDownParametre") );

			
			request.getSession().setAttribute("blockEnanbled", blockEnanbled);
			request.getSession().setAttribute("blockKaydet", blockKaydet);
			request.getSession().setAttribute("blockGuncelle", blockGuncelle);


		}
		
		return "redirect:/ParametreVeriGirisiSayfasi";
	
    }
	
	
	
	@RequestMapping("/parametreButtons")
    public String parametreButtons(HttpServletRequest request){
		if(request.getParameter("parametreKaydet")!=null) {
			Bolum bolum =new Bolum();
			bolum.setAd(request.getParameter("bolumAdi"));
			bolum.setParametre(request.getParameter("parametre"));
			bolum.setAciklama(request.getParameter("parametreAciklama"));
			bolum.setDurum(request.getParameter("dropDownParametre"));
			BolumService.save(bolum);
			
			
		}else if(request.getParameter("parametreGuncelle")!=null) {
			if(parametreEditId!=(long)-1) {
				Bolum bolum = new Bolum();
				bolum.setId(parametreEditId);
				bolum.setAd(request.getParameter("bolumAdi"));
				bolum.setParametre(request.getParameter("parametre"));
				bolum.setAciklama(request.getParameter("parametreAciklama"));
				bolum.setDurum(request.getParameter("dropDownParametre"));
				BolumService.save(bolum);
				
				parametreEditId=(long) -1;
				request.getSession().setAttribute("bolumAdiBox","");
				request.getSession().setAttribute("parametreBox","");
				request.getSession().setAttribute("parametreAciklamaBox","");
				request.getSession().setAttribute("dropDownDurum","");
			}else {
				parametreEditId = BolumService.findByName(request.getParameter("bolumAdi")).get(0).getId();
				Bolum bolum = new Bolum();
				bolum.setId(parametreEditId);
				bolum.setParametre(request.getParameter("parametre"));
				bolum.setAciklama(request.getParameter("parametreAciklama"));
				bolum.setDurum(request.getParameter("dropDownParametre"));
				BolumService.save(bolum);
				
				parametreEditId=(long) -1;
				request.getSession().setAttribute("bolumAdiBox","");
				request.getSession().setAttribute("parametreBox","");
				request.getSession().setAttribute("parametreAciklamaBox","");
				request.getSession().setAttribute("dropDownDurum","");
			}
			
		}
		return "redirect:/bolumListele";
	}
	
	@RequestMapping("fillParametre")
	public String fillParametre(@RequestParam("id") Long id, HttpServletRequest request) {
		parametreEditId=id;
		Bolum bolum = BolumService.get(id);
		parametreEditBolumAdi=bolum.getAd();
		parametreEditParametre = bolum.getParametre();
		parametreEditAciklama = bolum.getAciklama();
		parametreEditDurum = bolum.getDurum();

		blockEnanbled=false;
		blockKaydet=true;
		blockGuncelle=false;
		
		request.getSession().setAttribute("bolumAdiBox",parametreEditBolumAdi);
		request.getSession().setAttribute("parametreBox",parametreEditParametre);
		request.getSession().setAttribute("parametreAciklamaBox",parametreEditAciklama);
		request.getSession().setAttribute("dropDownDurum",parametreEditDurum);
		
		request.getSession().setAttribute("blockKaydet",blockKaydet );
		request.getSession().setAttribute("blockGuncelle",blockGuncelle );
		request.getSession().setAttribute("blockEnanbled",blockEnanbled );

	    return "redirect:/ParametreVeriGirisiSayfasi";
	}
	
	//parametre metodlari
	
	@RequestMapping("/buttonsSorgula")
	public String buttonsSorgula(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, IOException  {
		makeItBlackForFirma(request);	
		makeItBlackForExcel(request);
		makeItBlankForPersonel(request);
		makeItBlankForRehberEkle(request);
		makeItBlackForParametre(request);
		aktifFirmaListesi(request);
		
		request.getSession().setAttribute("listVeri", zamanAralik);
		if(request.getParameter("Sorgula")!=null) {
			String selectSorgula = request.getParameter("dropDownSorgula");
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date;
			java.util.Date date2;
			java.sql.Date sqlDate;
			java.sql.Date sqlDate2;
			List<Veri> list= VeriService.listAll();
			zamanAralik = new ArrayList<Veri>();
			try {
				date = formatter.parse(request.getParameter("baslangicTarih"));
				sqlDate = new Date(date.getTime());
				date2 = formatter.parse(request.getParameter("bitisTarih"));
				sqlDate2 = new Date(date2.getTime());
				
				if((selectSorgula==null || selectSorgula.length()==0)) {
					for(int i=0;i<list.size();i++) {
						if(list.get(i).getTarih().compareTo(sqlDate)>=0 && list.get(i).getTarih().compareTo(sqlDate2)<=0) {
							zamanAralik.add(list.get(i));
						}
					}
					request.getSession().setAttribute("listVeri", zamanAralik);
					

				}
				else if(selectSorgula.length()>0 ) {
					list=VeriService.findName(selectSorgula);
					for(int i=0;i<list.size();i++) {
						if(list.get(i).getTarih().compareTo(sqlDate)>=0 && list.get(i).getTarih().compareTo(sqlDate2)<=0) {
							zamanAralik.add(list.get(i));
						}
					}
					request.getSession().setAttribute("listVeri", zamanAralik);

				}
			} catch (ParseException e) {
				if(selectSorgula.length()>0 ) {
					zamanAralik=VeriService.findName(selectSorgula);
					request.getSession().setAttribute("listVeri", zamanAralik);

					
				}else {
					zamanAralik = VeriService.listAll();
					request.getSession().setAttribute("listVeri", zamanAralik);

					
				}
				e.printStackTrace();
			}

		}else if(request.getParameter("excelOustur")!=null) {
			writeToExcel(zamanAralik,response);
		}
		return "redirect:/SorgulaSayfasi";
	}

	@RequestMapping("/pdfLoader")
	public void PdfLoader(@RequestParam("id") Long id,HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		 byte[] byteArray= VeriService.get(id).getPdf();
		 response.setContentType("application/pdf");
		 response.addHeader("content-disposition", "inline; filename="+"fatura");	
		 
		 OutputStream os= response.getOutputStream();
		 os.write(byteArray);
		 os.flush();
		 os.close();
		
		
	}
	
	/*@RequestMapping("deleteRehber")
	public String deleteFromRehberTable(@RequestParam("id") Long id ) {
		RehberService.delete(id);
	    return "redirect:/rehberEkleSayfasi";
	}*/
	
	//yukardakiler rehberekle icin metotlar

	

	
	/*@RequestMapping("/display")
	public String displayTable(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) { //buradana devam ettt
		
		List<User> list=new ArrayList<User>();
		ArrayList<String> name=new ArrayList<String>();
        String queryName = request.getParameter("searchBarName");

		if(valid.equals(true)) {
			if(queryName!=null && queryName.length()>0 ) {
				
				list=service.findName(queryName);
				//model.addAttribute("listUser", list);
				request.getSession().setAttribute("listUser", list);
				
			}else {

				list=service.listAll();
				for(int i=0;i<list.size();i++) {
					name.add(list.get(i).getName());
				}
				request.getSession().setAttribute("listName", name);
				request.getSession().setAttribute("listUser", list);
				
			}
				
		    return "table";
		}
		          
		return "index";
		
	}
	@RequestMapping("/addTransfer")
	public String showAddDataPage(Model model) {
		if(valid.equals(true)) {
			User user = new User();
			model.addAttribute("user", user);
			return "addNew";
		}else {
			return "index";
		}
		
	}
	@RequestMapping(value = "/addData" , method = RequestMethod.POST)
	public ModelAndView saveData(@ModelAttribute("user") User user) {
		service.save(user);
		ModelAndView mav = new ModelAndView("redirect:/display");
		return mav;
	}
	
	@RequestMapping(value ="/delete/{id}", method = RequestMethod.POST)
	public String deleteUser(@PathVariable(value="id") Long id) {
	    service.delete(id);
	    return "redirect:/display";       
	}
	
	@RequestMapping(value ="/fill/{id}", method = RequestMethod.POST)
	public String fillTextBox(@PathVariable(value="id") Long id, Model model, HttpServletRequest request) {
		editId=id;
		User user = service.get(editId);
		editName = user.getName();
		editEmail = user.getEmail();
		request.getSession().setAttribute("boxName", editName);
		request.getSession().setAttribute("boxEmail", editEmail);

	    return "redirect:/display";       
	}
	
	@RequestMapping("/update")
	public ModelAndView editData(HttpServletRequest request, HttpServletResponse response,  HttpSession session){
		String newName= request.getParameter("textName"); //name attributeun value su 
		String newEmail= request.getParameter("textEmail");
		User user = new User();
		user.setId(editId);
		user.setName(newName);
		user.setEmail(newEmail);
		service.save(user);
		editId=(long) -1;
		session.setAttribute("boxName", "");
		session.setAttribute("boxEmail", "");
		
		return new ModelAndView("redirect:/display");
		
	}
	
	@RequestMapping("/logout")
	public String logout() {
		valid=false;
		return "index";
		
	}*/
	
}











