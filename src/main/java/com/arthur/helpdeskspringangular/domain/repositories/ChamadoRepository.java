package com.arthur.helpdeskspringangular.domain.repositories;

import com.arthur.helpdeskspringangular.domain.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado,Integer> {
}
