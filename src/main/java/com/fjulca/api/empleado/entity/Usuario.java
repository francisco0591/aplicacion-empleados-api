package com.fjulca.api.empleado.entity;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario implements UserDetails {

	@Id
	private int id;
	private String usuario;
	private String nombre;
	private String apellido;
	@JsonIgnore
	private String clave;
	private String roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Stream.of(roles.split(", ")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());

	}

	@JsonIgnore
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return clave;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

}
