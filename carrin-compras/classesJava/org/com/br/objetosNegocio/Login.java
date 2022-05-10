package org.com.br.objetosNegocio;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "users")
public class Login {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name = "";
	private String email;
	private String email_verified_at;
	private String password;
	private String created_at;
	private String updated_at;

	public Login() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getEmail_verified_at() {
		return email_verified_at;
	}

	public void setEmail_verified_at(String email_verified_at) {
		this.email_verified_at = email_verified_at;
	}

	public void geraValoresDefault() {
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date1 = simpleDateFormat.format(new Date());
		created_at = date1;
		updated_at = date1;
		name = email;
		
	}
	
	public static void main(String[] args) {
		Login login = new Login();
		login.geraValoresDefault();
		System.out.println(login.getCreated_at());
		System.out.println("passou aqui");
		System.exit(1);
	}
	
	

	
}
