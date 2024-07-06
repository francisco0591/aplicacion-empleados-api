package com.fjulca.api.empleado.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fjulca.api.empleado.dto.AuthRequest;
import com.fjulca.api.empleado.dto.AuthResponse;
import com.fjulca.api.empleado.entity.Usuario;
import com.fjulca.api.empleado.repository.UsuarioRepository;
import com.fjulca.api.empleado.security.jwt.JWTUtil;
import com.fjulca.api.empleado.security.jwt.PBKDF2Encoder;
import com.fjulca.api.empleado.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PBKDF2Encoder passwordEncoder;

	@Override
	public ResponseEntity<AuthResponse> login(AuthRequest authRequest) {
		//obtiene el usuario por el password ingresando en el request
	    Usuario u = usuarioRepository.findByUsuario(authRequest.getPassword());
	    //valida si existe el usuario
		if (u != null) {
			//System.out.println("clave:" + passwordEncoder.encode(authRequest.getPassword()));
			// valida los passwords si son iguales convertidos en base 64
			if (passwordEncoder.encode(authRequest.getPassword()).equals(u.getPassword())) {
				//si son iguales genera el token de acceso
				return ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(u)));
			} else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@Override
	public List<Usuario> listarUsuario() {
		return usuarioRepository.findAll();

	}

	
}
