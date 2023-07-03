package com.Entity;

public class User {

    private int id;
    private String username;
    private String password;
    private int age;
    private String gender;
    private String email;

    public User(){

    }
    public User(int id,String username,String password,int age,String gender,String email){
        super();
        this.id =id;
        this.username = username;
        this.password = password;
        this.setAge(age);
        this.setGender(gender);
        this.setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
}
