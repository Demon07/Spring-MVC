package com.example.demo.web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	
	public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
	@NotEmpty(message="姓名不能为空")
	@Length(min=2,max=6,message="长度为2~6位")
	String Name;
	@NotNull(message="年龄不能为空")
	@Min(message="年龄不能小于1",value = 1)
	@Max(message="最大年龄不得超过150", value = 150)
	Integer Age;
	@NotNull(message="电话不能为空")
		@Pattern(regexp=REGEX_MOBILE,message="输入的手机号不合法")
	String tell;
	
	@Override
	public String toString() {
		return "User [Name=" + Name + ", Age=" + Age + ", tell=" + tell + ", getName()=" + getName() + ", getAge()="
				+ getAge() + ", getTell()=" + getTell() + "]";
	}
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getAge() {
		return Age;
	}


	public void setAge(Integer age) {
		Age = age;
	}


	public String getTell() {
		return tell;
	}


	public void setTell(String tell) {
		this.tell = tell;
	}


}
