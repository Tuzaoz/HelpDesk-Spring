package com.arthur.helpdeskspringangular.domain.repositories;

import com.arthur.helpdeskspringangular.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Integer> {
}
