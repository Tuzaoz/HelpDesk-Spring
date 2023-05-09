package com.arthur.helpdeskspringangular.services;

import com.arthur.helpdeskspringangular.domain.Chamado;
import com.arthur.helpdeskspringangular.repositories.ChamadoRepository;
import com.arthur.helpdeskspringangular.services.exceptions.ObjectNotFoundExcpetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {
    @Autowired
    private ChamadoRepository repository;

    public Chamado findById(Integer id){
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundExcpetion("Objeto não encontrado! id:"+id));
    }
    public List<Chamado> findAll(){
        return repository.findAll();
    }
}
