package com.arthur.helpdeskspringangular.repositories;

import com.arthur.helpdeskspringangular.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico,Integer> {
}
