package com.fjulca.api.empleado.service;

import java.util.List;
import java.util.Optional;

import com.fjulca.api.empleado.entity.Empleado;

public interface EmpleadoService {

	public List<Empleado> findAll();

	public Optional<Empleado> findById(Long id);

	public Empleado save(Empleado nota);

	public void deleteById(Long id);
}
