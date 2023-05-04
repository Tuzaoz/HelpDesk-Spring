package com.arthur.helpdeskspringangular.repositories;

import com.arthur.helpdeskspringangular.domain.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado,Integer> {
}
