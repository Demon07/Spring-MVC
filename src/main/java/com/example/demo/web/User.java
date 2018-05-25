package com.example.demo.web;

public class User {
	
	String Name;
	@Override
	public String toString() {
		return "User [Name=" + Name + ", Age=" + Age + ", tell=" + tell + ", getName()=" + getName() + ", getAge()="
				+ getAge() + ", getTell()=" + getTell() + "]";
	}
	int Age;
	int tell;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getTell() {
		return tell;
	}
	public void setTell(int tell) {
		this.tell = tell;
	}


}
