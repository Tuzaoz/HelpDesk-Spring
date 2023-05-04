package com.arthur.helpdeskspringangular.repositories;

import com.arthur.helpdeskspringangular.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
