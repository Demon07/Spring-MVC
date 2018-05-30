package com.example.demo.datawcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.web.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Controller
@Api(value="dashboard",tags={"仪表盘操作接口"})
public class testcontroller {
	
	@ApiOperation("删除接口")
	@DeleteMapping("/Delete")
	public String Delete(@RequestBody User us) {
		
		
		System.out.println(us);
		return "success";
	}
	@ApiOperation("更新接口")
	@PutMapping("/update")
	public String Update(@RequestBody User us) {
		
		
		return "success";
	}
	@ApiOperation("新增接口")
	@PostMapping("/add")
	public User Add(@RequestBody User us) {
		System.out.println(us.toString());
		
		return us;
	}
	@ApiOperation("查询接口")
	@PostMapping("/search")
	public User search(@RequestBody User us) {
		
		return us;
	}
}
