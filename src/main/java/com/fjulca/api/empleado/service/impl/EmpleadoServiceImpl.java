package com.fjulca.api.empleado.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fjulca.api.empleado.entity.Empleado;
import com.fjulca.api.empleado.repository.EmpleadoRepository;
import com.fjulca.api.empleado.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> findAll() {
		return empleadoRepository.findAll();
	}

	@Override
	public Optional<Empleado> findById(Long id) {
		return empleadoRepository.findById(id);
	}

	@Override
	public Empleado save(Empleado nota) {
		return empleadoRepository.save(nota);
	}

	@Override
	public void deleteById(Long id) {
		empleadoRepository.deleteById(id);
	}

}
