package com.fjulca.api.empleado.service;

import java.util.List;
import org.springframework.http.ResponseEntity;

import com.fjulca.api.empleado.dto.AuthRequest;
import com.fjulca.api.empleado.dto.AuthResponse;
import com.fjulca.api.empleado.entity.Usuario;

public interface UserService {

	ResponseEntity<AuthResponse> login(AuthRequest authRequest);
	List<Usuario> listarUsuario();
}
