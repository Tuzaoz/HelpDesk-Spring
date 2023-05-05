package com.arthur.helpdeskspringangular.services;

import com.arthur.helpdeskspringangular.domain.Tecnico;
import com.arthur.helpdeskspringangular.domain.dtos.TecnicoDTO;
import com.arthur.helpdeskspringangular.services.exceptions.ObjectNotFoundExcpetion;
import com.arthur.helpdeskspringangular.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundExcpetion("Objeto não encontrado! id:"+id));
    }

    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }

    public Tecnico add(TecnicoDTO tecnicoDTO) {
        tecnicoDTO.setId(null);
        Tecnico tecnico = new Tecnico(tecnicoDTO);
        tecnicoRepository.save(tecnico);
        return tecnico;
    }
}
