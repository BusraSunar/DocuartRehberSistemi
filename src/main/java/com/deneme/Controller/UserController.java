package com.deneme.Controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.deneme.Model.*;
import com.deneme.service.ProductService;


@Controller
public class UserController {

	@Autowired
    private ProductService service;
	
	Boolean valid=true;
	Long editId=(long) -1;
	String editName="";
	String editEmail="";
	
	
	
	@RequestMapping("/")
	public String home(){
		
		return "index";
	}
	@RequestMapping("/signIn")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, Model model) {
		String name = request.getParameter("name");
		String email  = request.getParameter("email");
		List<User> example= service.signIn(name, email);
		ModelAndView mav = new ModelAndView("redirect:/display");
		ModelAndView mav2 = new ModelAndView("redirect:/errorMessage");
		if(!example.get(0).equals(null)) {
			valid=true;
			return mav;
		}else {
			valid= false;
			return mav2;
		}
		
	}
	
	@RequestMapping("/display")
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
		
	}
	
}











