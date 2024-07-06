package com.fjulca.api.empleado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.fjulca.api.empleado.entity.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
	@Query("select u from Empleado u where u.id=?1")
	List<Empleado> findByUsuario(int empleado);
}
