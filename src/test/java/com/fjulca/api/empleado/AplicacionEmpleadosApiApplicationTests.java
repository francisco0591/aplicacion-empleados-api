package com.fjulca.api.empleado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.fjulca.api.empleado.entity.Empleado;
import com.fjulca.api.empleado.service.EmpleadoService;


@SpringBootTest
class AplicacionEmpleadosApiApplicationTests {

	@Autowired
	EmpleadoService empleadoService;

	@Test
	@Transactional()
	@Disabled
	void saveEmpleado() {
		Empleado empleado = new Empleado();
		empleado.setNombre("Fernando");
		empleado.setApellido("Soto");
		empleado.setEdad(24);
		empleado.setFechaNacimiento(new Date(1998,02,13));
		empleado.setSalario(5500);
		Empleado empleadoDb =empleadoService.save(empleado);
		assertNotNull(empleadoDb);
	}
	
	@Test
	@Transactional(readOnly = true)
	@Disabled
	void listarEmpleado() {
		List<Empleado> listarEmpleado = empleadoService.findAll();
		assertFalse(listarEmpleado.isEmpty());
	}

	@Test
	@Transactional(readOnly = true)
	@Disabled
	void buscarEmpleadoxId() {
		Optional<Empleado> empleado = empleadoService.findById((long)1);
		assertNotNull(empleado.get());
	}
//	
	@Test
	@Transactional()
	@Disabled
	void actualizarEmpleado() {
		Optional<Empleado> empleadoOp = empleadoService.findById((long)1);
		Empleado empleadoDb = empleadoOp.get();
		empleadoDb.setNombre("Beto");
		empleadoDb.setApellido("Fernandez");
		empleadoDb.setEdad(20);
		empleadoDb.setFechaNacimiento(new Date(2000,02,13));
		assertNotNull(empleadoService.save(empleadoDb));
	}
//	
	@Test
	@Transactional()
	void eliminarEmpleadoxId() {
		empleadoService.deleteById((long)1);
		Optional<Empleado> empleado = empleadoService.findById((long)1);
		assertEquals(true,empleado.isEmpty());
	}
}
