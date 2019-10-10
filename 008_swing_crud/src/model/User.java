package model;

public class User {
private int id;

private String username,password,user_status;
public User(int codigo,String nombre,String contraseña,String estado) {
	
	this.id = codigo;
	this.username = nombre;
	this.password = contraseña;
	this.user_status = estado;
}
public int getId() {
	return id;
}
public String getUsername() {
	return username;
}
public String getPassword() {
	return password;
}
public String getUser_status() {
	return user_status;
}

//sobrecarga toString
}//cierra el clas
