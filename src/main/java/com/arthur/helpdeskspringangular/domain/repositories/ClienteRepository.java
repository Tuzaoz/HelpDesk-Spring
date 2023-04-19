package com.arthur.helpdeskspringangular.domain.repositories;

import com.arthur.helpdeskspringangular.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
