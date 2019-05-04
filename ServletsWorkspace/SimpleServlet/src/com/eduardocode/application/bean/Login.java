/**
 * 
 */
package com.eduardocode.application.bean;

import java.io.Serializable;

/**
 * Clase que representa el bean de un objeto de tipo login, para poder
 * loguearse dentro de la app
 * @author cheetos
 *
 */
public class Login implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1470857141573335578L;
	private String name;
	private String password;
	
	public Login() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean authentication() {
		return (this.password.equals("eduardo1234")) ? true : false;
	}

}
