package com.example.demo.web;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class DemoController {
	@RequestMapping (value="/save",method=RequestMethod.POST)
	public String save(@RequestBody User User) {
		
	
		System.out.println(User);
		return "success";
	}
	@RequestMapping(value="/do",method=RequestMethod.GET)
	public String save2() {
		
		
		return "input";
	}
	@RequestMapping(value="/save2",method=RequestMethod.POST)
	public String save2(@Valid User user,BindingResult result,Model model) {
		if (result.hasErrors()) {
        model.addAttribute("MSG","出错啦！");
        
        return "input";
        }else {
        	model.addAttribute("MSG","成功！");
        }
        	
		model.addAttribute("user", user);
		System.out.println(user);
		return "success";
	}
	
	@RequestMapping (value="/delete",method=RequestMethod.POST)
	public String Delete(User us) {
		
		
		System.out.println(us);
		return "success";
	}
	@RequestMapping (value="/get",method=RequestMethod.GET)
	public String MapTest(@RequestParam Map<String,String> params) {
		/*Iterator<Entry<String,String>>iterator=params.entrySet().iterator();
		while(iterator.hasNext())
		{
			Entry<String,String> entry = iterator.next();
			System.err.println(entry.getKey());
			System.err.println(entry.getValue());
		}*/
		System.out.println(params);
		return "success";
	}
	@ResponseBody
	@RequestMapping("/read")
	public User read(Model model ) {
		model.addAttribute("name","peng...");
		User user=new User();
		user.setName("peng");
		user.setAge(23);
		model.addAttribute("user",user);
		return user;
		
	}
	
	@RequestMapping(value="/read1",method=RequestMethod.POST)
	public String read1(Model model,HttpServletRequest req, HttpServletResponse resp)
	{
		req.setAttribute("sex", "male");
		
				return "read";
		
	}
	@RequestMapping(value="/upload")
	public String upload(@RequestParam(value = "file",required = false) MultipartFile file,Model model)
	{
		String path = "D:/data/";
		String fileName = file.getOriginalFilename();
		File targetFile = new File("D:/data/");
		if ( !targetFile.exists()) {
			System.err.println("创建"+targetFile.isDirectory());
			System.err.println(targetFile.mkdirs());
			
		}
		try {
			file.transferTo(new File("D:/data/"+fileName));
			System.err.println(file.getSize());
			model.addAttribute("msg","操作成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "success";
		
	}
}
