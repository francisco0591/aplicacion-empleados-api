package com.fjulca.api.empleado.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fjulca.api.empleado.entity.Empleado;
import com.fjulca.api.empleado.service.EmpleadoService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
@SecurityRequirement(name = "Authorization")
@RequestMapping("/api/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@Operation(summary = "Listar Empleados", description = "Servicio que lista toda los empleados validado por su token")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Servicio ejecutado correctamente"),
			@ApiResponse(code = 401, message = "Servicio no autorizado"),
			@ApiResponse(code = 403, message = "Servicio restringido"),
			@ApiResponse(code = 404, message = "Servicio no encontrado"),
			@ApiResponse(code = 500, message = "Servicio error interno") })
	@GetMapping("/")
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(empleadoService.findAll());
	}

	@Operation(summary = "Buscar empleado por id", description = "Servicio que busca los empleados por su id validado por su token")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Servicio ejecutado correctamente"),
			@ApiResponse(code = 401, message = "Servicio no autorizado"),
			@ApiResponse(code = 403, message = "Servicio restringido"),
			@ApiResponse(code = 404, message = "Servicio no encontrado"),
			@ApiResponse(code = 500, message = "Servicio error interno") })
	@GetMapping("/buscarxId/{id}")
	public ResponseEntity<?> buscarxId(@PathVariable Long id) {
		Optional<Empleado> empleado = empleadoService.findById(id);
		if (empleado.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(empleado.get());
	}

	@Operation(summary = "Registra Empleado", description = "Servicio que registra los empleados validado por su token")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Servicio ejecutado correctamente"),
			@ApiResponse(code = 401, message = "Servicio no autorizado"),
			@ApiResponse(code = 403, message = "Servicio restringido"),
			@ApiResponse(code = 404, message = "Servicio no encontrado"),
			@ApiResponse(code = 500, message = "Servicio error interno") })
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Empleado empleado) {
		Empleado empleadoDb = empleadoService.save(empleado);
		return ResponseEntity.status(HttpStatus.CREATED).body(empleadoDb);

	}

	@Operation(summary = "Actualizar Empleado", description = "Servicio que actualiza los empleados validado por su token")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Servicio ejecutado correctamente"),
			@ApiResponse(code = 401, message = "Servicio no autorizado"),
			@ApiResponse(code = 403, message = "Servicio restringido"),
			@ApiResponse(code = 404, message = "Servicio no encontrado"),
			@ApiResponse(code = 500, message = "Servicio error interno") })
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Empleado empleado, @PathVariable Long id) {
		Optional<Empleado> empleadoOp = empleadoService.findById(id);
		if (empleadoOp.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Empleado empleadoDb = empleadoOp.get();
		empleadoDb.setNombre(empleado.getNombre());
		empleadoDb.setApellido(empleado.getApellido());
		empleadoDb.setEdad(empleado.getEdad());
		empleadoDb.setFechaNacimiento(empleado.getFechaNacimiento());
		empleadoDb.setSalario(empleado.getSalario());
		return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.save(empleadoDb));
	}

	@Operation(summary = "Eliminar empleado", description = "Servicio que elimina un empleado por su id validado por su token")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Servicio ejecutado correctamente"),
			@ApiResponse(code = 401, message = "Servicio no autorizado"),
			@ApiResponse(code = 403, message = "Servicio restringido"),
			@ApiResponse(code = 404, message = "Servicio no encontrado"),
			@ApiResponse(code = 500, message = "Servicio error interno") })
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		empleadoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
