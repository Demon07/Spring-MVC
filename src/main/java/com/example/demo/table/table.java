package com.example.demo.table;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.web.User;
@Controller
public class table {
	List<User> list=new ArrayList<>();
	@GetMapping("/table")
	public String table(HttpSession session,Model model,HttpServletRequest request,User user) {
		
		session.removeAttribute(user.getId());
		if(user.getId()!=null) {
			request.getSession().setAttribute(user.getId(), user);
		}
		List<User> list = new ArrayList<User>();
		java.util.Enumeration<String>   e   =   request.getSession().getAttributeNames();     
		System.out.println(e);
		while( e.hasMoreElements())   {   
		    String sessionName=(String)e.nextElement();   
		    User user2 = (User) request.getSession().getAttribute(sessionName); 
		    list.add(user2);
		}  
		model.addAttribute("list",list);
		
		return "table";
	}
	@PostMapping("/insert")
	public String addForm(User user,HttpServletRequest request) {
		
		request.getSession().setAttribute(user.getId(), user);
		User user2 = (User) request.getSession().getAttribute(user.getId());
		
		return "redirect:table";
	}
	
	@GetMapping("/update")
	public String userFrom(Model model,String id,HttpServletRequest request) {
		User user =(User)request.getSession().getAttribute(id);
		model.addAttribute("user",user);
		return "update";
	}
	
	
	@GetMapping("/addForm")
	public String addForm() {
		return "insert";
	}
}
