package com.fjulca.api.empleado.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fjulca.api.empleado.dto.AuthRequest;
import com.fjulca.api.empleado.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
Clase Controller Usuario para los servicios usuario
@author  Francisco Julca
*/
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController extends Exception {


	@Autowired
	private UserService userService;
	
	@Operation(summary = "Login", description = "Servicio de login del sistema")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Servicio ejecutado correctamente"),
			@ApiResponse(code = 401, message = "Servicio no autorizado"),
			@ApiResponse(code = 403, message = "Servicio restringido"),
			@ApiResponse(code = 404, message = "Servicio no encontrado"),
			@ApiResponse(code = 500, message = "Servicio error interno") })
	@PostMapping("/api/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
		try {
			return userService.login(authRequest);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}


}
