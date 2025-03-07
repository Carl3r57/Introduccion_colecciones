package com.model;

public class Usuario {

	private String nombre;
	private String apellidos;
	private String email;
	private int intentos;
	private Credencial credencial;
	
	
	public Usuario(String nombre, String apellidos, String email, String passwd) throws Exception {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.intentos = 3;
		this.credencial = new Credencial(nombre, apellidos, passwd);
	}
	
	public Usuario(String nombre, String apellidos, String passwd) throws Exception {
		super();
		this.credencial = new Credencial(passwd, nombre, apellidos);
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.intentos = 3;
	}

	public boolean esCuentaBloqueada() {
		return intentos == 0;
	}
	
	public boolean esPassSegura(String pass) {
		return this.credencial.esPassSegura(pass);
	}
	
	private void setCredencial(Credencial credencial) {
		this.credencial = credencial;
	}
	
	public boolean modificarPasswd(String oldpass, String newPass, String newPassVerif) {
		boolean changed = false;
		changed = this.credencial.comprobarPasswd(oldpass) && newPass.equals(newPassVerif);
	
		try {
			this.credencial.setPasswd(newPass);
		} catch (Exception e) {
			e.printStackTrace();
			changed = false;
		}
		return changed;		
	}
	
	
	public boolean hacerLogin(String username, String passwd) {
	    if (intentos <= 0) {
	        return false;  // Cuenta bloqueada
	    }
	    boolean signed = false;
	    if (username.equals(credencial.getUsername()) && credencial.comprobarPasswd(passwd)) {
	        signed = true;
	        this.intentos = 3;  // Reseteamos los intentos después de un login exitoso
	    } else {
	        intentos--;
	    }
	    return signed;
	}

	
	public String toString() {
		return this.credencial.getUsername();
	}
}
