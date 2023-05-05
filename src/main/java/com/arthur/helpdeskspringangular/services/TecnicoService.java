package com.arthur.helpdeskspringangular.services;

import com.arthur.helpdeskspringangular.domain.Tecnico;
import com.arthur.helpdeskspringangular.services.exceptions.ObjectNotFoundExcpetion;
import com.arthur.helpdeskspringangular.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundExcpetion("Objeto não encontrado! id:"+id));
    }
}
