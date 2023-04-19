package com.arthur.helpdeskspringangular.domain.repositories;

import com.arthur.helpdeskspringangular.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico,Integer> {
}
